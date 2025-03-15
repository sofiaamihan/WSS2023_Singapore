package edu.wss2023.bXX.pm.healthiersg.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.wss2023.bXX.pm.healthiersg.components.NavigationDrawer
import edu.wss2023.bXX.pm.healthiersg.components.readCentral
import edu.wss2023.bXX.pm.healthiersg.components.readEast
import edu.wss2023.bXX.pm.healthiersg.components.readNorth
import edu.wss2023.bXX.pm.healthiersg.components.readSouth
import androidx.compose.ui.unit.sp
import edu.wss2023.bXX.pm.healthiersg.components.EventCard
import edu.wss2023.bXX.pm.healthiersg.components.readWest
import edu.wss2023.bXX.pm.healthiersg.R

@Composable
fun UpcomingEvents(
    toEvents: () -> Unit,
    toAppointments: () -> Unit,
    toRecordings: () -> Unit,
){
    val north = readNorth(LocalContext.current)
    val south = readSouth(LocalContext.current)
    val east = readEast(LocalContext.current)
    val west = readWest(LocalContext.current)
    val central = readCentral(LocalContext.current)
    val nPics = listOf<Int>(
        R.drawable.n001,
        R.drawable.n002,
        R.drawable.n003,
        R.drawable.n004,
        R.drawable.n005,
        R.drawable.n006,
        R.drawable.n007,
        R.drawable.n008,
        R.drawable.n009,
        R.drawable.n010,
    )
    val sPics = listOf<Int>(
        R.drawable.s001,
        R.drawable.s002,
        R.drawable.s003,
        R.drawable.s004,
        R.drawable.s005,
        R.drawable.s006,
        R.drawable.s007,
        R.drawable.s008,
        R.drawable.s009,
        R.drawable.s010,
    )
    val ePics = listOf<Int>(
        R.drawable.e001,
        R.drawable.e002,
        R.drawable.e003,
        R.drawable.e004,
        R.drawable.e005,
        R.drawable.e006,
        R.drawable.e007,
        R.drawable.e008,
        R.drawable.e009,
        R.drawable.e010,
    )
    val wPics = listOf<Int>(
        R.drawable.w001,
        R.drawable.w002,
        R.drawable.w003,
        R.drawable.w004,
        R.drawable.w005,
        R.drawable.w006,
        R.drawable.w007,
        R.drawable.w008,
        R.drawable.w009,
        R.drawable.w010,
    )
    val cPics = listOf<Int>(
        R.drawable.c001,
        R.drawable.c002,
        R.drawable.c003,
        R.drawable.c004,
        R.drawable.c005,
        R.drawable.c006,
    )
    NavigationDrawer(
        "Upcoming Events", toEvents, toAppointments, toRecordings
    ) {

        LazyColumn (
            modifier = Modifier
                .padding(top = 100.dp, start = 64.dp, end = 64.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item{
                Text(
                    text = "NORTH AREA",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{
                LazyRow (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(north.size){ index ->
                        var item = north[index]
                        EventCard(
                            nPics[index],
                            item.name,
                            item.description,
                            item.dataTime,
                            item.location
                        )
                    }
                }
            }
            item{
                Text(
                    text = "SOUTH AREA",
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{
                LazyRow (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(south.size){ index ->
                        var item = south[index]
                        EventCard(
                            sPics[index],
                            item.name,
                            item.description,
                            item.dataTime,
                            item.location
                        )
                    }
                }
            }
            item{
                Text(
                    text = "EAST AREA",
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{
                LazyRow (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(east.size){ index ->
                        var item = east[index]
                        EventCard(
                            ePics[index],
                            item.name,
                            item.description,
                            item.dataTime,
                            item.location
                        )
                    }
                }
            }
            item{
                Text(
                    text = "WEST AREA",
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{
                LazyRow (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(west.size){ index ->
                        var item = west[index]
                        EventCard(
                            wPics[index],
                            item.name,
                            item.description,
                            item.dataTime,
                            item.location
                        )
                    }
                }
            }
            item{
                Text(
                    text = "CENTRAL AREA",
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    letterSpacing = 5.sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            item{
                LazyRow (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(central.size){ index ->
                        var item = central[index]
                        EventCard(
                            cPics[index],
                            item.name,
                            item.description,
                            item.dataTime,
                            item.location
                        )
                    }
                }
            }
        }
    }
}
