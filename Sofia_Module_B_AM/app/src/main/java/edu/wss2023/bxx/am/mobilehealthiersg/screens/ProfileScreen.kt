package edu.wss2023.bxx.am.mobilehealthiersg.screens

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.content.FileProvider
import coil3.compose.AsyncImage
import edu.wss2023.bxx.am.mobilehealthiersg.components.NavDrawer
import java.io.File

fun createFile(context: Context): Uri {
    val file = File.createTempFile("image.png", context.cacheDir.name)
    return FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
}

@Composable
fun ProfileScreen(
    toProfile: () -> Unit,
    toMedicalRecords: () -> Unit,
    toFoodJournal: () -> Unit,
    toNOK: () -> Unit
){
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var permission by remember { mutableStateOf(context.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) }
    val permissionActivity = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { permission = it }
    var currentUri by remember { mutableStateOf<String?>(null) }
    var photo by remember { mutableStateOf<String?>(null) }
    val cameraActivity = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {
            photo = currentUri
            showDialog = false
        }
    }
    val galleryActivity = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
        photo = it.toString()
        showDialog = false
    }

    if (showDialog) {
        Dialog(
            onDismissRequest = {
                showDialog = false
            }
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Select a picture from the gallery or take a picture")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(
                            onClick = {
                                galleryActivity.launch(PickVisualMediaRequest(
                                    mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                ))
                            }
                        ) {
                            Text("Gallery")
                        }
                        TextButton(
                            onClick = {
                                if (permission) {
                                    val uri = createFile(context)
                                    currentUri = uri.toString()
                                    cameraActivity.launch(uri)
                                } else {
                                    permissionActivity.launch(android.Manifest.permission.CAMERA)
                                }
                            }
                        ) {
                            Text("Take Picture")
                        }
                        TextButton(
                            onClick = {
                                showDialog = false
                            }
                        ) {
                            Text("Cancel")
                        }
                    }
                }
            }
        }
    }
    NavDrawer(
        "Profile", toProfile, toMedicalRecords, toFoodJournal
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .size(200.dp)
                    .clickable {
                        showDialog = true
                    },
            ) {
                // Foreground image
                AsyncImage(
                    model = photo,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(CircleShape)
                )
            }
            Text(
                "Hello, John Michael Tan",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("NRIC:")
                Text("T0012345X")
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("Gender:")
                Text("Male")
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("Email:")
                Text("john.michael.tan@example.com")
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("Mobile:")
                Text("+65 9123 4567")
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("Date Of Birth:")
                Text("1990-05-14")
            }
            Button (
                onClick = {
                    toNOK()
                },
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(40.dp)
                    .fillMaxWidth(0.8f)
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