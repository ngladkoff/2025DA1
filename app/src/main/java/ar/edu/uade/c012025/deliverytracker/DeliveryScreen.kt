package ar.edu.uade.c012025.deliverytracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun DeliveryScreen(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    var lista = rememberSaveable { getList().toMutableList() }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column {
            DeliveryCounter(mutableStateOf(count), modifier.padding(innerPadding))
            DeliveryList(lista, modifier)
        }
    }
}

private fun getList() = List(10) { i ->
    val ahora = LocalDateTime.now()
    DeliveryItem(i, ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), "Delivery # $i")
}

@Preview(showBackground = true)
@Composable
fun DeliveryScreenPreview() {
    MaterialTheme {
        DeliveryScreen()
    }
}