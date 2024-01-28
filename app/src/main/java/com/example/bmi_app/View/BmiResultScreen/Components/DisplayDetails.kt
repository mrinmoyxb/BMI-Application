package com.example.bmi_app.View.BmiResultScreen.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.bmi_app.R


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
        colors = CardDefaults.cardColors(colorResource(id = R.color.primary_color)),
        border = BorderStroke(1.dp, Color.White),
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