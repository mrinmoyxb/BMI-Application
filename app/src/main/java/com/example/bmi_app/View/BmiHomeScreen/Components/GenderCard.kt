package com.example.bmi_app.View.BmiHomeScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_app.R

@Composable
fun GenderMaleCard(
    modifier: Modifier = Modifier,
    blackIcon: Painter,
    blueIcon: Painter,
    text: String,

){
    var cardState = remember{ mutableStateOf(false) }
    var iconState = remember{ mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .height(170.dp)
            .width(170.dp)
            .clickable { cardState.value = !cardState.value
                        GenderState.male = !GenderState.male
                       },
        colors = CardDefaults.cardColors(if (cardState.value || iconState.value) {Color(0xFFE1F5FE)}else Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(10.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clickable { iconState.value = !iconState.value
                                 GenderState.male = true
                               },
                painter = (if (cardState.value || iconState.value) blueIcon else blackIcon),
                contentDescription = "Male")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text,
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium)

        }
    }
}



@Composable
fun GenderFemaleCard(
    modifier: Modifier = Modifier,
    blackIcon: Painter,
    blueIcon: Painter,
    text: String,

    ){
    var cardState = remember{ mutableStateOf(false) }
    var iconState = remember{ mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .height(170.dp)
            .width(170.dp)
            .clickable { cardState.value = !cardState.value
                GenderState.female = !GenderState.female
            },
        colors = CardDefaults.cardColors(if (cardState.value || iconState.value) {Color(0xFFE1F5FE)}else Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(10.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clickable { iconState.value = !iconState.value
                        GenderState.female = !GenderState.female
                    },
                painter = (if (cardState.value || iconState.value) blueIcon else blackIcon),
                contentDescription = "Male")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text,
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium)

        }
    }
}
@Preview(showBackground = true)
@Composable
fun DisplayGenderCard(){
    GenderMaleCard(blackIcon = painterResource(id = R.drawable.man_black), blueIcon = painterResource(id = R.drawable.men_blue), text = "Male")
    GenderMaleCard(blackIcon = painterResource(id = R.drawable.women_black), blueIcon = painterResource(id = R.drawable.women_blue), text = "female")
}