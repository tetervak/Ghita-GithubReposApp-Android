package ca.tetervak.githubreposapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import ca.tetervak.githubreposapp.data.remote.Repo
import kotlinx.coroutines.flow.Flow

interface PagedReposRepository {
    fun getReposPager(pageSize: Int): Pager<Int, Repo>
}