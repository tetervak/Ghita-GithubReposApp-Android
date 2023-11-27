package ca.tetervak.githubreposapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReposPagingSource @Inject constructor(
    private val reposApi: ReposApi
) : PagingSource<Int, Repo>() {

    val pageSize: Int = 20

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        try {
            val nextPage = params.key ?: 1 // the page that we want to get
            val repos = reposApi.getRepos(
                page = nextPage,
                pageSize = pageSize,
            ).repos
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
