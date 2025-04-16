package ar.edu.uade.c012025.deliverytracker

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.uade.c012025.deliverytracker.ui.theme.DeliveryTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("DeliveryTracker", "Ingresé a MainActivity onCreate")
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                DeliveryScreen()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("DeliveryTracker", "Ingresé a MainActivity onStart")
    }
}
