package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
import java.time.LocalDate
import java.time.LocalDateTime

@Composable
fun FoodJournalScreen(
    toProfile: () -> Unit,
    toMedicalRecords: () -> Unit,
    toFoodJournal: () -> Unit,
    toAddMeal: () -> Unit,
    toEditMeal: () -> Unit
){
    var date = LocalDate.now()
    NavDrawer(
        date.toString(), toProfile, toMedicalRecords, toFoodJournal
    ) {
        Column (
            modifier = Modifier
                .padding(top = 180.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                onClick = {toAddMeal()},
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(100.dp)
                    .fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
            ) {
                Text("Add Meal")
            }
            Button(
                onClick = {toEditMeal()},
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(100.dp)
                    .fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
            ) {
                Text("Edit Meal")
            }
    }}}