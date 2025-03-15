package edu.wss2023.bXX.pm.healthiersg.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.wss2023.bXX.pm.healthiersg.screens.AppointmentDetails
import edu.wss2023.bXX.pm.healthiersg.screens.Appointments
import edu.wss2023.bXX.pm.healthiersg.screens.Recordings
import edu.wss2023.bXX.pm.healthiersg.screens.UpcomingEvents


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
                }
            )
        }
        composable (Screens.Details.route){
            AppointmentDetails()
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
