package edu.wss2023.bXX.pm.healthiersg.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.wss2023.bXX.pm.healthiersg.R

@Composable
//@Preview(device = "spec:width=1280dp,height=800dp,dpi=240", showSystemUi = true)
fun EventCard(
    id: Int,
    title: String,
    description: String,
    dateTime: String,
    location: String,
){
    val modelState = remember { mutableStateOf(false) }

    if(modelState.value){
        EventDialog(
            id, title, description, dateTime, location, {modelState.value = false}
        )
    }


    ElevatedCard (
        modifier = Modifier
            .clickable{modelState.value = true}
            .width(180.dp)
            .height(260.dp),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
        ){
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
                    .fillMaxWidth()
            ){
                Image(painter = painterResource(id), contentDescription = "Image")
            }
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    modifier = Modifier.padding(top = 8.dp, start = 4.dp)
                )
                Text(
                    text = dateTime,
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    modifier = Modifier.padding(top = 4.dp, start = 4.dp)
                )
                Text(
                    text = location,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 12.sp,
                    modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
                )
            }
        }
    }
}