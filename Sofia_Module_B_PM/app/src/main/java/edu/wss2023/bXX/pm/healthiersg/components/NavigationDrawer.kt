package edu.wss2023.bXX.pm.healthiersg.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.wss2023.bXX.pm.healthiersg.R
import kotlinx.coroutines.launch

//class NavigationItem(){
//    val title: String
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    title: String,
    toEvents: () -> Unit,
    toAppointments: () -> Unit,
    toRecordings: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
){
    val items = listOf("Upcoming Events", "Appointments", "Recordings")
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer(modifier = Modifier.height(24.dp))
                    Image(painter = painterResource(R.drawable.healthiersg_logo), contentDescription = "Logo", modifier = Modifier.size(80.dp))
                    Spacer(modifier = Modifier.height(24.dp))
                    items.forEachIndexed{ index, item ->
                        NavigationDrawerItem(
                            label = { Text(items[index]) },
                            selected = index == selectedItemIndex,
                            onClick = {
                                if (index == 0 ){
                                    toEvents()
                                } else if (index == 1){
                                    toAppointments()
                                } else {
                                    toRecordings()
                                }
                                scope.launch{
                                    drawerState.close()
                                    selectedItemIndex = index
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
        Scaffold (
            topBar = {
                CenterAlignedTopAppBar(
                    title = {Text(title)},
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.secondaryContainer),
                    navigationIcon = {
                        IconButton(onClick ={
                            scope.launch{
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ){ paddingValues ->
            content(paddingValues)
        }
    }
}