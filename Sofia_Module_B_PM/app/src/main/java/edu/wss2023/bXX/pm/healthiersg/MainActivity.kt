package edu.wss2023.bXX.pm.healthiersg

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import edu.wss2023.bXX.pm.healthiersg.components.RootNavGraph
import edu.wss2023.bXX.pm.healthiersg.screens.Appointments
import edu.wss2023.bXX.pm.healthiersg.screens.Recordings
import edu.wss2023.bXX.pm.healthiersg.screens.UpcomingEvents
import edu.wss2023.bXX.pm.healthiersg.ui.theme.HealthierSGTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthierSGTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
    }
}

