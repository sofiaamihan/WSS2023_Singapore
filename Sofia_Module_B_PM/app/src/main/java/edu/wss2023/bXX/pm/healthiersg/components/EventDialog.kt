package edu.wss2023.bXX.pm.healthiersg.components

import android.R.attr.text
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDialog(
    id: Int,
    title: String,
    description: String,
    dateTime: String,
    location: String,
    onDismiss: () -> Unit,
){
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        content = {
            Row (
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .fillMaxHeight(0.4f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth(0.4f)
                ){
                    Image(painter = painterResource(id), contentDescription = "Image")
                }
                Column (
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxHeight(0.5f),
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        modifier = Modifier.padding(top = 8.dp, start = 4.dp)
                    )
                    Text(
                        text = description,
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        modifier = Modifier.padding(top = 4.dp, start = 4.dp)
                    )
                    Text(
                        text = dateTime,
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        modifier = Modifier.padding(top = 4.dp, start = 4.dp)
                    )
                    Text(
                        text = location,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 14.sp,
                        modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ){
                        Share(LocalContext.current)
                    }
                }
            }
        },
    )
}

@Composable
fun Share(context: Context){
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, "Share this event")

    IconButton (
        onClick = {
            startActivity(context, shareIntent, null)
        },
        modifier = Modifier.size(50.dp)
    ) {
        Icon(Icons.Default.IosShare, "Share")
    }
}