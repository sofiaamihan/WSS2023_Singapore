package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.runtime.Composable
import edu.wss2023.bxx.am.mobilehealthiersg.components.NavDrawer

@Composable
fun MedicalRecordsScreen(
    toProfile: () -> Unit,
    toMedicalRecords: () -> Unit,
    toFoodJournal: () -> Unit,
){
    NavDrawer(
        "Medical Records", toProfile, toMedicalRecords, toFoodJournal
    ) {}}