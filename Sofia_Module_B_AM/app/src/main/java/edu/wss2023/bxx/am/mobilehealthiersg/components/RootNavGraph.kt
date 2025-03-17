package edu.wss2023.bxx.am.mobilehealthiersg.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.wss2023.bxx.am.mobilehealthiersg.screens.AddMealEntryScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.AddRecordScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.EditMealEntryScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.EditNextOfKinScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.FoodJournalScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.MedicalRecordsListScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.MedicalRecordsScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.ProfileScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.ViewConditionDetailsScreen
import edu.wss2023.bxx.am.mobilehealthiersg.screens.ViewLabResultDetailsScreen
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


sealed class Screens(val route: String){
    object Profile: Screens("PROFILE")
    object NextOfKin: Screens("NOK")
    object MedicalRecords: Screens("MEDICAL_RECORDS")
    object MRList: Screens("MEDICAL_RECORDS_LIST")
    object Conditions: Screens("CONDITIONS")
    object LabResults: Screens("LAB_RESULTS")
    object AddRecord: Screens("ADD_RECORD")
    object FoodJournal: Screens("FOOD_JOURNAL")
    object AddMeal: Screens("ADD_MEAL")
    object EditMeal: Screens("EDIT_MEAL")
}

@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost (
        navController = navController,
        startDestination = Screens.Profile.route
    ){
        composable(Screens.NextOfKin.route){
            EditNextOfKinScreen()
        }
        composable(Screens.MedicalRecords.route){
            MedicalRecordsScreen(
                toProfile = {
                    navController.navigate(Screens.Profile.route)
                },
                toMedicalRecords = {
                    navController.navigate(Screens.MedicalRecords.route)
                },
                toFoodJournal = {
                    navController.navigate(Screens.FoodJournal.route)
                }
            )
        }
        composable(Screens.MRList.route){
            MedicalRecordsListScreen()
        }
        composable(Screens.Conditions.route){
            ViewConditionDetailsScreen()
        }
        composable(Screens.LabResults.route){
            ViewLabResultDetailsScreen()
        }
        composable(Screens.AddRecord.route){
            AddRecordScreen()
        }
        composable(Screens.FoodJournal.route){
            FoodJournalScreen(
                toProfile = {
                    navController.navigate(Screens.Profile.route)
                },
                toMedicalRecords = {
                    navController.navigate(Screens.MedicalRecords.route)
                },
                toFoodJournal = {
                    navController.navigate(Screens.FoodJournal.route)
                }
            )
        }
        composable(Screens.AddMeal.route){
            AddMealEntryScreen()
        }
        composable(Screens.EditMeal.route){
            EditMealEntryScreen()
        }
        composable(Screens.Profile.route){
            ProfileScreen(
                toProfile = {
                    navController.navigate(Screens.Profile.route)
                },
                toMedicalRecords = {
                    navController.navigate(Screens.MedicalRecords.route)
                },
                toFoodJournal = {
                    navController.navigate(Screens.FoodJournal.route)
                },
                toNOK = {
                    navController.navigate(Screens.NextOfKin.route)
                }
            )
        }
    }
}
