package ca.tetervak.githubreposapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ca.tetervak.githubreposapp.data.remote.Repo
import ca.tetervak.githubreposapp.data.remote.ReposPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemotePagedReposRepository @Inject constructor(
    private val reposPagingSource: ReposPagingSource
) : PagedReposRepository {

    override fun getReposPager(pageSize: Int): Pager<Int, Repo> =
        Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                reposPagingSource
            })
}