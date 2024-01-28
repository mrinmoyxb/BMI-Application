package com.example.bmi_app

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@SuppressLint("SuspiciousIndentation")
@Composable
fun ResultScreen(navController: NavHostController, bmi_value: Float){

    val results: Double = bmi_value.toDouble()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ResultText()
        Spacer(modifier = Modifier.height(20.dp))
        BmiResultIcon(results)
        Spacer(modifier = Modifier.height(40.dp))
        ResultStatement(results)
        Spacer(modifier = Modifier.height(40.dp))
        DisplayInfo("Male", painterResource(id = R.drawable.man_black), 22, 165, 62)
        Spacer(modifier = Modifier.height(20.dp))
        HealthSummaryScreen(results)

    }

}

// Final Screen with all composable
@Composable
fun DisplayInfo(
    sex: String,
    painter: Painter,
    age: Int,
    height: Int,
    weight: Int
){
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .width(350.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(Color(0xFFF3E5F5)),
        border = BorderStroke(1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(8.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxSize()
        ){
            GenderIcon(sex, painter)
            AgeIcon(ageValue = age)
            HeightIcon(heightValue = height)
            WeightIcon(weightValue = weight)

        }
    }
}


// Gender Icon
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
                fontSize = 20.sp,
                color = Color(0xFF616161),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = 45.dp)
            )

        }
    }
}

// Age Icon
@Composable
fun AgeIcon(ageValue: Int){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top  = 8.dp, start = 15.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(
                ageValue.toString(),
                fontSize = 50.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                //modifier = Modifier.offset(y = -10.dp)
            )
            Text(
                text = "Age",
                fontSize = 20.sp,
                color = Color(0xFF616161),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = 40.dp)
            )
        }

    }
}

// Height Icon
@Composable
fun HeightIcon(heightValue: Int){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top  = 8.dp, start = 15.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(
                heightValue.toString(),
                fontSize = 50.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                //modifier = Modifier.offset(y = -10.dp)
            )
            Text(
                text = "Height",
                fontSize = 20.sp,
                color = Color(0xFF616161),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = 40.dp)
            )
        }

    }
}

// Weight Icon
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
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Weight",
                fontSize = 20.sp,
                color = Color(0xFF616161),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = 40.dp)
            )
        }

    }
}


// BMI result icon
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
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "kg/m2",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }

        }
    }
}


// Result Statement:
@Composable
fun ResultStatement(bmiResult: Double){
    var cardColor: Color = when(bmiResult){
        in 0.0..18.5 -> Color(0xFF4FC3F7) // underweight
        in 18.6..24.9->Color(0xFF76FF03) // normal
        in 25.0..29.9 -> Color(0xFFF9A825) // overweight
        in 30.0..100.0 ->Color(0xFFBF360C) // obese
        else -> {Color.White}
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
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

// "Result" text
@Composable
fun ResultText(){
    Text("Your BMI is: ",
        fontSize = 32.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

// Health Summary
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
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Text(resultRisk,
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Impact on health",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Text(resultImpact,
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}

