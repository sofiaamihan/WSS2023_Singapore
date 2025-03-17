package edu.wss2023.bxx.am.mobilehealthiersg.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import edu.wss2023.bxx.am.mobilehealthiersg.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer(
    title: String,
    toProfile: () -> Unit,
    toMedicalRecords: () -> Unit,
    toFoodJournal: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
){
//    var scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberScrollState())
    var items = listOf("Profile", "Medical Records", "Food Journal")
    var selectedItemIndex by remember { mutableIntStateOf(0) }
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    var scope = rememberCoroutineScope()
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
                    Image(painter = painterResource(R.drawable.launcher_icon), "Icon", modifier = Modifier.size(100.dp))
                    Spacer(modifier = Modifier.height(24.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {Text(item)},
                            selected = index == selectedItemIndex,
                            onClick = {
                                if (index == 0){
                                    toProfile()
                                } else if (index == 1){
                                    toMedicalRecords()
                                }else {
                                    toFoodJournal()
                                }
                                selectedItemIndex = index
                                scope.launch{
                                    drawerState.close()
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
                    title = { Text(title) },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch{
                                   drawerState.open()
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu, "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer)
                )
            }
        ){ paddingValues ->
            content(paddingValues)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackBar(
    title: String,
    toBack: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(title) },
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(
                        onClick = {
                            toBack()
                        }
                    ) {
                        Icon(Icons.Default.ArrowBackIosNew, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer)
            )
        }
    ){  paddingValues ->
        content(paddingValues)
    }
}