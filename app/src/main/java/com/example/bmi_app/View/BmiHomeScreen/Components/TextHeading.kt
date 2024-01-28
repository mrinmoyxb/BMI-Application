package com.example.bmi_app.View.BmiHomeScreen.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.bmi_app.ui.theme.montserrat

@Composable
fun TextHeading(t: String, modifier: Modifier = Modifier){
    Text(text = t,
        fontSize = 20.sp,
        color = Color.Black,
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}
