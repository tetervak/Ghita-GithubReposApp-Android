package ca.tetervak.githubreposapp.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import javax.inject.Inject
import javax.inject.Singleton


val TAG: String = "ReposPagingSource"

@Singleton
class ReposPagingSource @Inject constructor(
    private val reposApi: ReposApi
) : PagingSource<Int, Repo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        try {
            val nextPage = params.key ?: 1 // the page that we want to get
            val loadSize = params.loadSize
            Log.d(TAG,"requested page=$nextPage, loadSize=$loadSize")
            val repos = reposApi.getRepos(
                page = nextPage,
                pageSize = loadSize,
            ).repos
            Log.d(TAG,"received page=$nextPage, size=${repos.size}")
            return LoadResult.Page(
                data = repos,
                prevKey = if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? {
        return null
    }
}
