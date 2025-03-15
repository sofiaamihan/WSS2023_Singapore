package edu.wss2023.bXX.pm.healthiersg.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.wss2023.bXX.pm.healthiersg.components.NavigationDrawer

@Composable
fun Appointments(
    toEvents: () -> Unit,
    toAppointments: () -> Unit,
    toRecordings: () -> Unit,
){
    NavigationDrawer(
        "Appointments", toEvents, toAppointments, toRecordings
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Appointments")
        }
    }
}