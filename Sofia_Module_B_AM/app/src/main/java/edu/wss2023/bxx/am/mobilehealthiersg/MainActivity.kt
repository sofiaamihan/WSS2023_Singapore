package edu.wss2023.bxx.am.mobilehealthiersg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import edu.wss2023.bxx.am.mobilehealthiersg.components.RootNavGraph
import edu.wss2023.bxx.am.mobilehealthiersg.ui.theme.MobileHealthierSGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileHealthierSGTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
    }
}
