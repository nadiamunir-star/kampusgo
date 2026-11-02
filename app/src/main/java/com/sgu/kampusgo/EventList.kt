// Guided by Android Basics codelab: Add a scrollable list.
package com.sgu.kampusgo


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventList(
    events: List<Event>,
    onEventClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (events.isEmpty()) {
        Text(
            text = "No events",
            modifier = modifier.padding(24.dp)
        )
    } else {
        LazyColumn(modifier = modifier) {
            items(events, key = { it.id }) { event ->
                Column(
                    modifier = Modifier
                        .clickable { onEventClick(event.id) }
                        .padding(16.dp)
                ) {
                    Text(event.title)
                    Text(event.category)
                    Text(event.venue)
                    Text(event.startsAt)
                }
            }
        }
    }
}
