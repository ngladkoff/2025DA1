package ar.edu.uade.c012025.deliverytracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeliveryCounter(count: MutableState<Int>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count.value > 0) {
            Text(
                text = "Has pedido ${count.value} deliveries",
                modifier = modifier.padding(16.dp)
            )
        }
        ElevatedButton(
            onClick = { count.value++ },
            Modifier.padding(top = 8.dp),
            enabled = count.value < 5
        ) {
            Text("Hice otro pedido!!")
        }
    }
}