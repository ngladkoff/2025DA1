package ar.edu.uade.c012025.deliverytracker

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DeliveryList(
    lista: List<DeliveryItem>,
    modifier: Modifier) {
    LazyColumn()
    {
        items(lista) {
            item ->
                Text(text = "${item.fechaHora}", modifier= modifier)
        }
    }
}