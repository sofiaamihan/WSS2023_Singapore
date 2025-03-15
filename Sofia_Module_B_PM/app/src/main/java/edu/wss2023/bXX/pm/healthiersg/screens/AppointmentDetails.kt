package edu.wss2023.bXX.pm.healthiersg.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.wss2023.bXX.pm.healthiersg.components.ContactDialog
import edu.wss2023.bXX.pm.healthiersg.components.NavigationDrawer
import edu.wss2023.bXX.pm.healthiersg.components.getClinic
import edu.wss2023.bXX.pm.healthiersg.components.readPast
import edu.wss2023.bXX.pm.healthiersg.components.readUpcoming

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppointmentDetails(
    toEvents: () -> Unit,
    toAppointments: () -> Unit,
    toRecordings: () -> Unit,
    date: String,
    doctor: String,
    clinic: String,
) {
    val clinicDetails = getClinic(LocalContext.current, clinic)
    val openDialog = remember { mutableStateOf(false) }

    if(openDialog.value){
        ContactDialog(
            clinicDetails.name,
            clinicDetails.email,
            clinicDetails.phone,
            {openDialog.value = false}
        )
    }
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
                    text = "LOCATION",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{Text(clinicDetails.address)}
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
            item{
                Button(
                    onClick = {openDialog.value = true},
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Text("Contact Information")
                }
            }
        }
    }
}