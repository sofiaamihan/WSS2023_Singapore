package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.runtime.Composable
import edu.wss2023.bxx.am.mobilehealthiersg.components.BackBar

@Composable
fun EditMealEntryScreen(
    toBack:() -> Unit
){
    BackBar(
        "Edit Meal", toBack
    ) { }
}