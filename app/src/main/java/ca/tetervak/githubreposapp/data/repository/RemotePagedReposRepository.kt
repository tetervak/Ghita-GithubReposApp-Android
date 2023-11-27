package ca.tetervak.githubreposapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ca.tetervak.githubreposapp.data.remote.Repo
import ca.tetervak.githubreposapp.data.remote.ReposPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemotePagedReposRepository @Inject constructor(
    private val reposPagingSource: ReposPagingSource,
) : PagedReposRepository {

    override fun getReposPager(): Pager<Int, Repo> =
        Pager(
            config = PagingConfig(pageSize = reposPagingSource.pageSize),
            pagingSourceFactory = {
                reposPagingSource
            })
}