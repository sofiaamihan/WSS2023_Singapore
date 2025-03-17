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
import edu.wss2023.bxx.am.mobilehealthiersg.data.TokenDataStore
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
fun RootNavGraph(navController: NavHostController, tokenDataStore: TokenDataStore){
    NavHost (
        navController = navController,
        startDestination = Screens.Profile.route
    ){
        composable(Screens.NextOfKin.route){
            EditNextOfKinScreen(
                tokenDataStore,
                toBack = {
                    navController.popBackStack()
                }
            )
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
                },
                toAllRecords = {
                    navController.navigate(Screens.MRList.route)
                },
                toLabResults = {
                    navController.navigate(Screens.LabResults.route)
                },
                toConditions = {
                    navController.navigate(Screens.Conditions.route)
                },
                toAddRecords = {
                    navController.navigate(Screens.AddRecord.route)
                }
            )
        }
        composable(Screens.MRList.route){
            MedicalRecordsListScreen(
                toBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screens.Conditions.route){
            ViewConditionDetailsScreen(
                toBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screens.LabResults.route){
            ViewLabResultDetailsScreen(
                toBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screens.AddRecord.route){
            AddRecordScreen(
                toBack = {
                    navController.popBackStack()
                }
            )
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
                },
                toAddMeal = {
                    navController.navigate(Screens.AddMeal.route)
                },
                toEditMeal = {
                    navController.navigate(Screens.EditMeal.route)
                }
            )
        }
        composable(Screens.AddMeal.route){
            AddMealEntryScreen(
                toBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screens.EditMeal.route){
            EditMealEntryScreen(
                toBack = {
                    navController.popBackStack()
                }
            )
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
