package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.wss2023.bxx.am.mobilehealthiersg.components.NavDrawer

@Composable
fun MedicalRecordsScreen(
    toProfile: () -> Unit,
    toMedicalRecords: () -> Unit,
    toFoodJournal: () -> Unit,
    toAllRecords: () -> Unit,
    toLabResults: () -> Unit,
    toConditions: () -> Unit,
    toAddRecords: () -> Unit,
){
    NavDrawer(
        "Medical Records", toProfile, toMedicalRecords, toFoodJournal
    ) {
        Column (
            modifier = Modifier
                .padding(top = 180.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var search = remember { mutableStateOf("") }
            OutlinedTextField(
                value = search.value,
                onValueChange = {search.value = it},
                label = { Text("Search") },
                leadingIcon = { Icon(Icons.Default.Search, "Search") }
            )
            Button(
                onClick = {toAllRecords()},
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(100.dp)
                    .fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
            ) {
                Text("All Records")
            }
            Row (
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = {toLabResults()},
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .height(100.dp)
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
                ) {
                    Text("Lab Results")
                }
                Button(
                    onClick = {toConditions()},
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .height(100.dp)
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
                ) {
                    Text("Conditions")
                }
            }
            Button(
                onClick = {toAddRecords()},
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(100.dp)
                    .fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
            ) {
                Row {
                    Icon(Icons.Default.Add, "Add")
                    Text("Add Record")
                }
            }
        }
    }
}