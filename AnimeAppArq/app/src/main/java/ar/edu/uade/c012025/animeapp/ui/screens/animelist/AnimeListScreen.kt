package ar.edu.uade.c012025.animeapp.ui.screens.animelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AnimeUIList
import ar.edu.uade.c012025.animeapp.ui.theme.AnimeAppTheme

@Composable
fun AnimeListScreen(
    modifier: Modifier = Modifier,
    vm: AnimeListScreenViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Listado de Anime",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(12.dp))
        AnimeUIList(vm.uiState.animeList, Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeListScreenPreview() {
    AnimeAppTheme {
        //AnimeListScreen(List<Anime>())
    }
}