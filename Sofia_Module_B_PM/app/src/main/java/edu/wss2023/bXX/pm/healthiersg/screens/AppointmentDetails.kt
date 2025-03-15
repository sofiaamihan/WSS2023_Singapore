package edu.wss2023.bXX.pm.healthiersg.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.wss2023.bXX.pm.healthiersg.components.NavigationDrawer
import edu.wss2023.bXX.pm.healthiersg.components.readPast
import edu.wss2023.bXX.pm.healthiersg.components.readUpcoming

@Composable
fun AppointmentDetails(
    toEvents: () -> Unit,
    toAppointments: () -> Unit,
    toRecordings: () -> Unit,
    date: String,
    doctor: String,
) {
    NavigationDrawer(
        "Appointment Details", toEvents, toAppointments, toRecordings
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 100.dp, start = 64.dp, end = 64.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "APPOINTMENT DATE",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{Text(date)}
            item {
                Text(
                    text = "DOCTOR NAME",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{Text(doctor)}
        }
    }
}