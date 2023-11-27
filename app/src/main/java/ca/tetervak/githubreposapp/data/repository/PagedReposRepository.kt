package ca.tetervak.githubreposapp.data.repository

import androidx.paging.Pager
import ca.tetervak.githubreposapp.data.remote.Repo

interface PagedReposRepository {
    fun getReposPager(): Pager<Int, Repo>
}