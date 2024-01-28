package com.example.bmi_app.View.BmiResultScreen.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun HealthSummaryScreen(bmiResult: Double){
    val underweightRisk: String = "Increased risk of malnutrition, osteoporosis, weakened immune system, fertility issues, anemia, and breathing problems."
    val underweightImpact: String = " Fatigue, difficulty gaining weight, delayed growth and development in children."

    val normalRisk: String = "Considered the lowest risk category for chronic diseases."
    val normalImpact: String = "Lower risk of type 2 diabetes, heart disease, stroke, certain cancers, and other chronic conditions."

    val overweightRisk: String = "Increased risk of developing chronic diseases, including type 2 diabetes, heart disease, stroke, certain cancers, and sleep apnea."
    val overweightImpact: String = "Increased risk of fatigue, high blood pressure, high cholesterol, and musculoskeletal problems."

    val obeseRisk: String = "Significantly increased risk of developing various chronic diseases, including type 2 diabetes, heart disease, stroke, certain cancers, sleep apnea, and respiratory problems."
    val obeseImpact: String = "Increased risk of fatigue, difficulty breathing, joint pain, and decreased mobility."

    var resultRisk: String = when(bmiResult){
        in 0.0..18.5 -> underweightRisk
        in 18.6..24.9 -> normalRisk
        in 25.0..29.9 -> overweightRisk
        in 30.0..100.0 -> obeseRisk
        else -> {""}
    }

    var resultImpact: String = when(bmiResult){
        in 0.0..18.5 -> underweightImpact
        in 18.6..24.9 -> normalImpact
        in 25.0..29.9 -> overweightImpact
        in 30.0..100.0 -> obeseImpact
        else -> {""}
    }

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color(0xFFECEFF1)),
        modifier = Modifier
            .height(200.dp)
            .width(350.dp),
        border = BorderStroke(1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Health Risks",
                fontSize = 20.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Text(resultRisk,
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Impact on health",
                fontSize = 20.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Text(resultImpact,
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}