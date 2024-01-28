package com.example.bmi_app.View.BmiResultScreen.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_app.ui.theme.montserrat

@Composable
fun ResultStatement(bmiResult: Double){
    var cardColor: Color = when(bmiResult){
        in 0.0..18.5 -> Color(0xFF4FC3F7) // underweight
        in 18.6..24.9-> Color(0xFF76FF03) // normal
        in 25.0..29.9 -> Color(0xFFF9A825) // overweight
        in 30.0..100.0 -> Color(0xFFBF360C) // obese
        else -> {
            Color.White}
    }

    var result: String = when(bmiResult){
        in 0.0..18.5 -> "Underweight"
        in 18.6..24.9 -> "Normal"
        in 25.0..29.9 -> "Overweight"
        in 30.0..100.0 -> "Obese"
        else -> {""}
    }
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(cardColor),
        elevation = CardDefaults.cardElevation(5.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .height(35.dp)
            .width(130.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                result,
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}