package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.runtime.Composable
import edu.wss2023.bxx.am.mobilehealthiersg.components.BackBar

@Composable
fun AddMealEntryScreen(
    toBack:() -> Unit
){
    BackBar(
        "Add Meal", toBack
    ) { }
}