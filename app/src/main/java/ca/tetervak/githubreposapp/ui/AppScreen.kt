package ca.tetervak.githubreposapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems

import ca.tetervak.githubreposapp.ui.repos.ReposViewModel
import ca.tetervak.githubreposapp.ui.repos.ReposScreen
import ca.tetervak.githubreposapp.data.remote.Repo

@Composable
fun AppScreen() {
    val viewModel: ReposViewModel = viewModel()
    val reposFlow = viewModel.repos
    val lazyRepoItems: LazyPagingItems<Repo> =
        reposFlow.collectAsLazyPagingItems()

    ReposScreen(lazyRepoItems)
}