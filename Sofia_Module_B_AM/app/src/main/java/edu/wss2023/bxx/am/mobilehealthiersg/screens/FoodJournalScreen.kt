package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.runtime.Composable
import edu.wss2023.bxx.am.mobilehealthiersg.components.NavDrawer

@Composable
fun FoodJournalScreen(
    toProfile: () -> Unit,
    toMedicalRecords: () -> Unit,
    toFoodJournal: () -> Unit,
){
    NavDrawer(
        "Food Journal", toProfile, toMedicalRecords, toFoodJournal
    ) {}}