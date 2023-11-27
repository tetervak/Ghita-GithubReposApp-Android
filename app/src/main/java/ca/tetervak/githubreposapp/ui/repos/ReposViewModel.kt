package ca.tetervak.githubreposapp.ui.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import ca.tetervak.githubreposapp.data.remote.Repo
import ca.tetervak.githubreposapp.data.repository.PagedReposRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(
    pagedReposRepository: PagedReposRepository
) : ViewModel() {

    val repos: Flow<PagingData<Repo>> =
        pagedReposRepository.getReposPager().flow.cachedIn(viewModelScope)
}

