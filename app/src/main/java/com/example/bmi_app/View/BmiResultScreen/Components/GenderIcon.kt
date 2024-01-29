package com.example.bmi_app.View.BmiResultScreen.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_app.ui.theme.montserrat

@Composable
fun GenderIcon(sex: String, imgSource: Painter){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = imgSource,
                contentDescription = "",
                modifier = Modifier.size(60.dp),
                tint = Color.Black
            )
            Text(
                sex,
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = 45.dp)
            )

        }
    }
}