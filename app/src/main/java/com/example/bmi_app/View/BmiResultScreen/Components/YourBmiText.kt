package com.example.bmi_app.View.BmiResultScreen.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.bmi_app.ui.theme.montserrat

@Composable
fun ResultText(){
    Text("Your BMI is: ",
        fontSize = 32.sp,
        color = Color.Black,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}