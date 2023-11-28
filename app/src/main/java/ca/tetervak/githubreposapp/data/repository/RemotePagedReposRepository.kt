package ca.tetervak.githubreposapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ca.tetervak.githubreposapp.data.remote.Repo
import ca.tetervak.githubreposapp.data.remote.ReposApi
import ca.tetervak.githubreposapp.data.remote.ReposPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemotePagedReposRepository @Inject constructor(
    private val reposApi: ReposApi
) : PagedReposRepository {

    override fun getReposPager(): Pager<Int, Repo> =
        Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { ReposPagingSource(reposApi) }
        )
}