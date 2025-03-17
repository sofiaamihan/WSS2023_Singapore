package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.runtime.Composable
import edu.wss2023.bxx.am.mobilehealthiersg.components.BackBar

@Composable
fun AddRecordScreen(
    toBack:() -> Unit
){
    BackBar(
        "Add Record", toBack
    ) { }
}