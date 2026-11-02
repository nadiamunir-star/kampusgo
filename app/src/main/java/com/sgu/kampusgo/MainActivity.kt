package com.sgu.kampusgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sgu.kampusgo.ui.theme.KampusGoTheme
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Capture the Activity BEFORE setContent. The button needs it to build an Intent.
        val activity = this
        setContent {
            KampusGoTheme {
// Holds the typed text while this screen is open. A redraw keeps it. Rotation still runs onCreate again.
                var name by remember { mutableStateOf("") }
                var npm by remember { mutableStateOf("") }

                var showEmpty by remember { mutableStateOf(false) }
                val events = if (showEmpty) emptyList() else sampleEvents
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                        EventList(
                            events = events,
                            onEventClick = { id ->
                                val intent = Intent(activity, EventDetailActivity::class.java)
                                intent.putExtra("id", id)
                                activity.startActivity(intent)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Button(onClick = { showEmpty = !showEmpty }) {
                            Text(if (showEmpty) "Show events" else "Show empty")
                        }
                        Button(onClick = {
                            activity.startActivity(
                                Intent(activity, ProfileXmlActivity::class.java)
                            )
                        }) {
                            Text("XML form")
                        }
                    }
                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KampusGoTheme {
        Greeting("Nadia")
    }
}