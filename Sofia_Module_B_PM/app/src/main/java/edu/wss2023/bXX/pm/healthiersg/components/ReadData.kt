package edu.wss2023.bXX.pm.healthiersg.components

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import edu.wss2023.bXX.pm.healthiersg.R
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.String

data class Event(
    val id: String,
    val name: String,
    val description: String,
    val dataTime: String,
    val location: String
)

data class Procedures(
    val blood: Boolean = false,
    val urine: Boolean = false,
    val fast: Boolean = false
)

data class Appointments(
    val id: String,
    val date: String,
    val time: String,
    val doctor: String,
    val department: String,
    val type: String,
//    val procedures: Procedures,
    val clinic: String
)

data class Clinic(
    val clinic: String,
    val name: String,
    val email: String,
    val phone: String,
    val address: String
)

fun readNorth(context: Context): List<Event>{
    val inputStream = context.resources.openRawResource(R.raw.event_informations)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("North")

    var eventList = mutableListOf<Event>()

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        val event = Event(
            id = item.getString("Event_ID"),
            name = item.getString("Name"),
            description = item.getString("Description"),
            dataTime = item.getString("Date and Time"),
            location = item.getString("Location")
        )
        eventList.add(event)
    }
    return eventList
}

fun readSouth(context: Context): List<Event>{
    val inputStream = context.resources.openRawResource(R.raw.event_informations)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("South")

    var eventList = mutableListOf<Event>()

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        val event = Event(
            id = item.getString("Event_ID"),
            name = item.getString("Name"),
            description = item.getString("Description"),
            dataTime = item.getString("Date and Time"),
            location = item.getString("Location")
        )
        eventList.add(event)
    }
    return eventList
}

fun readEast(context: Context): List<Event>{
    val inputStream = context.resources.openRawResource(R.raw.event_informations)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("East")

    var eventList = mutableListOf<Event>()

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        val event = Event(
            id = item.getString("Event_ID"),
            name = item.getString("Name"),
            description = item.getString("Description"),
            dataTime = item.getString("Date and Time"),
            location = item.getString("Location")
        )
        eventList.add(event)
    }
    return eventList
}

fun readWest(context: Context): List<Event>{
    val inputStream = context.resources.openRawResource(R.raw.event_informations)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("West")

    var eventList = mutableListOf<Event>()

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        val event = Event(
            id = item.getString("Event_ID"),
            name = item.getString("Name"),
            description = item.getString("Description"),
            dataTime = item.getString("Date and Time"),
            location = item.getString("Location")
        )
        eventList.add(event)
    }
    return eventList
}

fun readCentral(context: Context): List<Event>{
    val inputStream = context.resources.openRawResource(R.raw.event_informations)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("Central")

    var eventList = mutableListOf<Event>()

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        val event = Event(
            id = item.getString("Event_ID"),
            name = item.getString("Name"),
            description = item.getString("Description"),
            dataTime = item.getString("Date and Time"),
            location = item.getString("Location")
        )
        eventList.add(event)
    }
    return eventList
}

@RequiresApi(Build.VERSION_CODES.O)
fun readUpcoming(context: Context): List<Appointments>{
    val inputStream = context.resources.openRawResource(R.raw.appointments)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("appointments")

    val date = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    var apps = mutableListOf<Appointments>()

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        val givenDate = LocalDate.parse(item.getString("Date"), formatter)
        if(givenDate.isBefore(date)){
            val app = Appointments(
                id = item.getString("Appointment_ID"),
                date = item.getString("Date"),
                time = item.getString("Time"),
                doctor = item.getString("Doctor_Name"),
                department = item.getString("Department"),
                type = item.getString("Appointment_Type"),
                clinic = item.getString("Clinic_ID")
            )
            apps.add(app)
        }
    }
    return apps
}

@RequiresApi(Build.VERSION_CODES.O)
fun readPast(context: Context): List<Appointments>{
    val inputStream = context.resources.openRawResource(R.raw.appointments)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("appointments")

    val date = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    var apps = mutableListOf<Appointments>()

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        val givenDate = LocalDate.parse(item.getString("Date"), formatter)
        if(givenDate.isAfter(date)){
            val app = Appointments(
                id = item.getString("Appointment_ID"),
                date = item.getString("Date"),
                time = item.getString("Time"),
                doctor = item.getString("Doctor_Name"),
                department = item.getString("Department"),
                type = item.getString("Appointment_Type"),
                clinic = item.getString("Clinic_ID")
            )
            apps.add(app)
        }
    }
    return apps
}

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun getClinic(
    context: Context,
    clinic: String,
): Clinic{
    val inputStream = context.resources.openRawResource(R.raw.appointments)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val jsonString = bufferedReader.use { it.readText() }
    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("clinics")
    var app = Clinic("", "", "", "","")

    for(i in 0 until jsonArray.length()){
        val item = jsonArray.getJSONObject(i)
        if(clinic == item.getString("Clinic_ID")){
            app = Clinic(
                clinic = item.getString("Clinic_ID"),
                name = item.getString("Name"),
                email = item.getString("Email"),
                phone = item.getString("Phone"),
                address = item.getString("Address")
            )
        }
    }
    return app
}

