package com.example.bmi_app.View.BmiResultScreen.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_app.ui.theme.montserrat

@Composable
fun BmiResultIcon(result: Double){
    var final_result = "%.1f".format(result)
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .height(160.dp)
            .width(160.dp),
        colors = CardDefaults.cardColors(Color.Black),
        elevation = CardDefaults.cardElevation(10.dp)
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    final_result.toString(),
                    fontSize = 60.sp,
                    color = Color.White,
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "kg/m2",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontFamily = montserrat,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}