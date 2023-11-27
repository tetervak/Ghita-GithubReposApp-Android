package ca.tetervak.githubreposapp.data.repository

import androidx.paging.PagingData
import ca.tetervak.githubreposapp.data.remote.Repo
import kotlinx.coroutines.flow.Flow

interface PagedReposRepository {
    fun getPagedReposFlow(pageSize: Int): Flow<PagingData<Repo>>
}