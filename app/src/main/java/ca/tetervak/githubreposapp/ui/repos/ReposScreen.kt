package ca.tetervak.githubreposapp.ui.repos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import ca.tetervak.githubreposapp.data.remote.Repo


@Composable
fun ReposScreen(repos: LazyPagingItems<Repo>, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        ),
        modifier = modifier
    ) {
        when (val refreshLoadState = repos.loadState.refresh) {
            is LoadState.Loading -> {
                item {
                    LoadingItem(Modifier.fillParentMaxSize())
                }
            }

            is LoadState.Error -> {
                val error = refreshLoadState.error
                item {
                    ErrorItem(
                        message = error.localizedMessage ?: "",
                        modifier = Modifier.fillParentMaxSize(),
                        onClick = { repos.retry() }
                    )
                }
            }

            else -> Unit
        }

        items(repos.itemCount) { index ->
            repos[index]?.let { repo ->
                RepositoryItem(index, repo)
            }
        }

        when (val appendLoadState = repos.loadState.append) {
            is LoadState.Loading -> {
                item {
                    LoadingItem(Modifier.fillMaxWidth())
                }
            }

            is LoadState.Error -> {
                val error = appendLoadState.error
                item {
                    ErrorItem(
                        message = error.localizedMessage ?: "",
                        onClick = { repos.retry() })
                }
            }

            else -> Unit
        }
    }
}

@Composable
fun RepositoryItem(index: Int, item: Repo) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .height(120.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = (index + 1).toString(),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .weight(0.2f)
                    .padding(8.dp)
            )
            Column(modifier = Modifier.weight(0.8f)) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.headlineSmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }
        }
    }
}

