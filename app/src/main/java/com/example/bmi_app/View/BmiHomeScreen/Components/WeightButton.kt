package com.example.bmi_app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun weightBar(): Int{
    var weightList = (1..100).toList()
    var weightValue = remember{mutableStateOf(0)}
    var weights: Int = weightValue.value
    Card(
        modifier = Modifier
            .height(100.dp)
            .width(170.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(10.dp)
            ) {
                items(weightList) { index ->
                    Text(
                        text = index.toString(),
                        fontSize = 40.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable (onClick = {
                            weightValue.value = index
                        } )
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                }
            }
        }
    }
    return weights
}
