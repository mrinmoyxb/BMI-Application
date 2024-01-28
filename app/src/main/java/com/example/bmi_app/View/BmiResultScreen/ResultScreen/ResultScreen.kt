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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmi_app.View.BmiResultScreen.Components.BmiResultIcon
import com.example.bmi_app.View.BmiResultScreen.Components.DisplayInfo
import com.example.bmi_app.View.BmiResultScreen.Components.HealthSummaryScreen
import com.example.bmi_app.View.BmiResultScreen.Components.ResultStatement
import com.example.bmi_app.View.BmiResultScreen.Components.ResultText
import com.example.bmi_app.ui.theme.montserrat


@SuppressLint("SuspiciousIndentation")
@Composable
fun ResultScreen(navController: NavHostController, bmi_value: Float, age: Int, height: Int, weight: Int){

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
        DisplayInfo("Male", painterResource(id = R.drawable.man_black), age, height, weight)
        Spacer(modifier = Modifier.height(20.dp))
        HealthSummaryScreen(results)

    }

}


@Preview(showBackground = true)
@Composable
fun displayResult(){
    val navController = rememberNavController()
    //ResultScreen(navController = navController, bmi_value = 23.2f)
}

