package edu.wss2023.bxx.am.mobilehealthiersg.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.wss2023.bxx.am.mobilehealthiersg.components.BackBar
import edu.wss2023.bxx.am.mobilehealthiersg.components.readConditions

@Composable
fun ViewConditionDetailsScreen(toBack:() -> Unit
){
    var conditions = readConditions(LocalContext.current)
    BackBar(
        "Conditions", toBack
    ) {
        Column (
            modifier = Modifier.fillMaxSize().padding(top = 120.dp).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            conditions.forEachIndexed { index, item ->
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        conditions[index].name,
                        modifier = Modifier,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    IconButton(onClick = {}) { Icon(Icons.Default.Edit, "Edit") }
                }
            }
        }
    }
}