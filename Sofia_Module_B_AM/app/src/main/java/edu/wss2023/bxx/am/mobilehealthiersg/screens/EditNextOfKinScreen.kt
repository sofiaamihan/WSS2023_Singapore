package edu.wss2023.bxx.am.mobilehealthiersg.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.wss2023.bxx.am.mobilehealthiersg.components.BackBar
import edu.wss2023.bxx.am.mobilehealthiersg.data.TokenDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun EditNextOfKinScreen(
    tokenDataStore: TokenDataStore,
    toBack:() -> Unit
){
//    var name1: String? = remember { mutableStateOf("").toString() }
//    var name2: String? = remember { mutableStateOf("").toString() }
//    var contact1: String? = remember { mutableStateOf("").toString() }
//    var contact2: String? = remember { mutableStateOf("").toString() }
//    var rs1: String? = remember { mutableStateOf("").toString() }
//    var rs2 : String? = remember { mutableStateOf("").toString() }
    var name1= remember { mutableStateOf("") }
    var name2= remember { mutableStateOf("") }
    var contact1= remember { mutableStateOf("") }
    var contact2 = remember { mutableStateOf("") }
    var rs1 = remember { mutableStateOf("") }
    var rs2= remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()



    LaunchedEffect(Unit) {
        name1.value = tokenDataStore.getName1.first().toString()
        name2.value = tokenDataStore.getName2.first().toString()
        contact1.value = tokenDataStore.getContact1.first().toString()
        contact2.value = tokenDataStore.getContact2.first().toString()
        rs1.value = tokenDataStore.getRelationship1.first().toString()
        rs2.value = tokenDataStore.getRelationship2.first().toString()
    }

    BackBar(
        "Next-Of-Kin", toBack
    ) {
        Column (
            modifier = Modifier
                .padding(top = 180.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                "Emergency Contact 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            OutlinedTextField(
                value = name1.value,
                onValueChange = { name1.value = it },
                label = {Text("Name")}
            )
            OutlinedTextField(
                value = contact1.value,
                onValueChange = { contact1.value = it },
                label = {Text("Contact")}
            )
            OutlinedTextField(
                value = rs1.value,
                onValueChange = { rs1.value = it },
                label = {Text("Relationship")}
            )
            Text(
                "Emergency Contact 2",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            OutlinedTextField(
                value = name2.value,
                onValueChange = { name2.value = it },
                label = {Text("Name")}
            )
            OutlinedTextField(
                value = contact2.value,
                onValueChange = { contact2.value = it },
                label = {Text("Contact")}
            )
            OutlinedTextField(
                value = rs2.value,
                onValueChange = { rs2.value = it },
                label = {Text("Relationship")}
            )
            Button (
                onClick = {
                    scope.launch{
                        tokenDataStore.saveName1(name1.value)
                        tokenDataStore.saveName2(name2.value)
                        tokenDataStore.saveContact1(contact1.value)
                        tokenDataStore.saveContact2(contact2.value)
                        tokenDataStore.saveRelationship1(rs1.value)
                        tokenDataStore.saveRelationship2(rs2.value)
                        toBack()
                    }
                },
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(40.dp)
                    .fillMaxWidth(0.8f),
                enabled = if (
                    name1.value.isNotEmpty() &&
                    name2.value.isNotEmpty() &&
                    contact1.value.isNotEmpty() &&
                    contact2.value.isNotEmpty() &&
                    rs1.value.isNotEmpty() &&
                    rs2.value.isNotEmpty()
                ) true else false
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Text("Next-Of-Kin Information")
                    Icon(Icons.Filled.Edit, "Edit")
                }
            }

        }
    }
}