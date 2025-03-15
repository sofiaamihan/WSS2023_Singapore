package edu.wss2023.bXX.pm.healthiersg.components

import android.content.Context
import edu.wss2023.bXX.pm.healthiersg.R
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

data class Event(
    val id: String,
    val name: String,
    val description: String,
    val dataTime: String,
    val location: String
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