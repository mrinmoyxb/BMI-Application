package com.example.bmi_app.View.BmiResultScreen.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_app.ui.theme.montserrat

@Composable
fun WeightIcon(weightValue: Int){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top  = 8.dp, start = 15.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(
                weightValue.toString(),
                fontSize = 50.sp,
                color = Color.Black,
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Weight",
                fontSize = 18.sp,
                color = Color(0xFF616161),
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = 40.dp)
            )
        }

    }
}