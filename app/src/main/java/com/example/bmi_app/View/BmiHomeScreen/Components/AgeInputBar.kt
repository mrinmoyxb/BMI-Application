package com.example.bmi_app.View.BmiHomeScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ageInputBar(): Int{
    var counterValue = remember{ mutableStateOf(20) }
    var age: Int = counterValue.value
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(100.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Subtract Counter
            Surface(
                shape = CircleShape,
                modifier = Modifier.size(35.dp),
                color = Color.Black,
            ){
                Image(painter = painterResource(id = R.drawable.minus_white),
                    contentDescription = "add",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .clickable(onClick = {
                            if (counterValue.value > 1) counterValue.value -= 1
                            else 1
                        })
                )
            }

            Box(
                contentAlignment = Alignment.Center,
            ) {
                TextField(
                    value = counterValue.value.toString(),
                    onValueChange = { counterValue.value = it.toInt() },
                    shape = RectangleShape,
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .height(90.dp)
                        .width(78.dp),
                    maxLines = 1,
                    textStyle = TextStyle(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        autoCorrect = true
                    ),
                )
            }

            // Add Counter:
            Surface(
                shape = CircleShape,
                modifier = Modifier.size(35.dp),
                color = Color.Black,
            ){
                Image(painter = painterResource(id = R.drawable.plus_white),
                    contentDescription = "subtract",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .clickable(onClick = {
                            if (counterValue.value >= 1) {
                                counterValue.value += 1
                            } else 1
                        }
                        )
                )
            }
        }
    }
    return age
}
