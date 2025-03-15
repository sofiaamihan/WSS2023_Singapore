package edu.wss2023.bXX.pm.healthiersg.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.wss2023.bXX.pm.healthiersg.components.EventCard
import edu.wss2023.bXX.pm.healthiersg.components.NavigationDrawer
import edu.wss2023.bXX.pm.healthiersg.components.getClinic
import edu.wss2023.bXX.pm.healthiersg.components.readPast
import edu.wss2023.bXX.pm.healthiersg.components.readUpcoming

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Appointments(
    toEvents: () -> Unit,
    toAppointments: () -> Unit,
    toRecordings: () -> Unit,
    toDetails: (String, String, String) -> Unit
) {
    val upcoming = readUpcoming(LocalContext.current)
    val past = readPast(LocalContext.current)

    NavigationDrawer(
        "Appointments", toEvents, toAppointments, toRecordings
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 100.dp, start = 64.dp, end = 64.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "UPCOMING APPOINTMENTS",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    items(upcoming.size) { index ->
                        var item = upcoming[index]
                        var location = getClinic(LocalContext.current, item.clinic).address
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            TextButton(onClick = {
                                toDetails(item.date, item.doctor, item.clinic)
                            }) {
                                Text("${item.type} @ ${location}")
                            }
                            Text(
                                item.date + item.time,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
            item {
                Text(
                    text = "PAST APPOINTMENTS",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    items(past.size) { index ->
                        var item = past[index]
                        var location = getClinic(LocalContext.current, item.clinic).address
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            TextButton(onClick = {
                                toDetails(item.date, item.doctor, item.clinic)
                            }) {
                                Text("${item.type} @ ${location}")
                            }
                            Text(
                                item.date + item.time,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}