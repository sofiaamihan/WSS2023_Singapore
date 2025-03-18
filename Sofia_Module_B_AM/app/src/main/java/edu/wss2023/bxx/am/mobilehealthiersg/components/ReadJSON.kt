package edu.wss2023.bxx.am.mobilehealthiersg.components

import android.content.Context
import edu.wss2023.bxx.am.mobilehealthiersg.R
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

data class Conditions(
    val name: String,
    val onsetDate: String,
    val abatementDate: String,
    val notes: String
)

data class LabResults(
    val name: String,
    val location: String,
    val collectionDate: String,
    val testResult: String,
    val notes: String
)

fun readConditions(context: Context): List<Conditions>{
    var inputStream = context.resources.openRawResource(R.raw.conditions)
    var bufferedReader = BufferedReader(InputStreamReader(inputStream))
    var jsonString = bufferedReader.use { it.readText() }
    var jsonObject = JSONObject(jsonString)
    var jsonArray = jsonObject.getJSONArray("conditions")

    var conditionsList = mutableListOf<Conditions>()
    for(i in 0 until jsonArray.length()){
        var item = jsonArray.getJSONObject(i)
        var condition = Conditions(
            name = item.getString("Name"),
            onsetDate = item.getString("Onset_Date"),
            abatementDate = item.getString("Abatement_Date"),
            notes = item.getString("Notes")
        )
        conditionsList.add(condition)
    }
    return conditionsList
}

fun readLabResults(context: Context): List<LabResults>{
    var inputStream = context.resources.openRawResource(R.raw.lab_results)
    var bufferedReader = BufferedReader(InputStreamReader(inputStream))
    var jsonString = bufferedReader.use { it.readText() }
    var jsonObject = JSONObject(jsonString)
    var jsonArray = jsonObject.getJSONArray("lab_results")

    var conditionsList = mutableListOf<LabResults>()
    for(i in 0 until jsonArray.length()){
        var item = jsonArray.getJSONObject(i)
        var result = LabResults(
            name = item.getString("Name"),
            location = item.getString("Location"),
            collectionDate = item.getString("Specimen_Collection_Date"),
            testResult = item.getString("Test_Result"),
            notes = item.getString("Notes")
        )
        conditionsList.add(result)
    }
    return conditionsList
}