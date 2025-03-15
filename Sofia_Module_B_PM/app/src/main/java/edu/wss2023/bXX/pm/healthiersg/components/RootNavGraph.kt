package edu.wss2023.bXX.pm.healthiersg.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.wss2023.bXX.pm.healthiersg.screens.AppointmentDetails
import edu.wss2023.bXX.pm.healthiersg.screens.Appointments
import edu.wss2023.bXX.pm.healthiersg.screens.Recordings
import edu.wss2023.bXX.pm.healthiersg.screens.UpcomingEvents


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Events.route
    ){
        composable (Screens.Events.route){
            UpcomingEvents(
                toEvents = {
                    navController.navigate(Screens.Events.route)
                },
                toAppointments = {
                    navController.navigate(Screens.Appointments.route)
                },
                toRecordings = {
                    navController.navigate(Screens.Recordings.route)
                }
            )
        }
        composable (Screens.Appointments.route){
            Appointments(
                toEvents = {
                    navController.navigate(Screens.Events.route)
                },
                toAppointments = {
                    navController.navigate(Screens.Appointments.route)
                },
                toRecordings = {
                    navController.navigate(Screens.Recordings.route)
                },
                toDetails = { date, doctor, clinic ->
                    navController.navigate("${Screens.Details.route}/${date}/${doctor}/${clinic}")
                }
            )
        }
        composable ("${Screens.Details.route}/{date}/{doctor}/{clinic}"){ backStackEntry ->
            val date: String = backStackEntry.arguments?.getString("date") ?: ""
            val doctor: String = backStackEntry.arguments?.getString("doctor") ?: ""
            val clinic: String = backStackEntry.arguments?.getString("clinic") ?: ""
            AppointmentDetails(
                toEvents = {
                    navController.navigate(Screens.Events.route)
                },
                toAppointments = {
                    navController.navigate(Screens.Appointments.route)
                },
                toRecordings = {
                    navController.navigate(Screens.Recordings.route)
                },
                date,
                doctor,
                clinic
            )
        }
        composable (Screens.Recordings.route){
            Recordings(
                toEvents = {
                    navController.navigate(Screens.Events.route)
                },
                toAppointments = {
                    navController.navigate(Screens.Appointments.route)
                },
                toRecordings = {
                    navController.navigate(Screens.Recordings.route)
                }
            )
        }
    }
}

sealed class Screens(val route: String){
    object Events: Screens("EVENTS")
    object Appointments: Screens("APPOINTMENTS")
    object Details: Screens("DETAILS")
    object Recordings: Screens("RECORDINGS")
}
