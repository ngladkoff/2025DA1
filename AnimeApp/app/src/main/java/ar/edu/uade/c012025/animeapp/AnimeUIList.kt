package ar.edu.uade.c012025.animeapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items

@Composable
fun AnimeUIList(
    list: List<Anime>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier= modifier
    ) {
        items(
            items = list,
            key = { it -> it.id}
        ) {
            anime -> AnimeUiItem(anime)
        }
    }
}