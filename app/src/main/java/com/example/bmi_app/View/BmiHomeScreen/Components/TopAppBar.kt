package com.example.bmi_app.View.BmiHomeScreen.Components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_app.ui.theme.montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiTopBar(){
    TopAppBar(
        title = {
            Text("BMI Calculator",
                fontSize = 32.sp,
                color = Color.Black,
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(Color.White),
        modifier = Modifier.shadow(10.dp)
    )
}