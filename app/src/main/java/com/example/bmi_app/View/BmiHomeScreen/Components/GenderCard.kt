package com.example.bmi_app.View.BmiHomeScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenderCard(
    modifier: Modifier = Modifier,
    blackIcon: Painter,
    blueIcon: Painter,
    text: String
){
    var cardState = remember{ mutableStateOf(false) }
    var iconState = remember{ mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .height(170.dp)
            .width(170.dp)
            .clickable { cardState.value = !cardState.value },
        colors = CardDefaults.cardColors(if (cardState.value || iconState.value) Color(0xFFE1F5FE) else Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(10.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clickable { iconState.value = !iconState.value },
                painter = (if (cardState.value || iconState.value) blueIcon else blackIcon),
                contentDescription = "Male")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text,
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium)

        }
    }
}
