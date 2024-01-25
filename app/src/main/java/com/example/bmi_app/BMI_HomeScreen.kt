package com.example.bmi_app

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    var h: Int = 0
    var w: Int = 0
    var a: Int = 0
    Scaffold(
        topBar = {BmiTopBar()},
    ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GenderCard(
                blackIcon = painterResource(id = R.drawable.man_black),
                blueIcon = painterResource(id = R.drawable.men_blue),
                text = "Male"
            )
            Spacer(modifier = Modifier.width(20.dp))
            GenderCard(
                blackIcon = painterResource(id = R.drawable.women_black),
                blueIcon = painterResource(id = R.drawable.women_blue),
                text = "Female"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Age and Weight Heading
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextHeading("Age")
            TextHeading("Weight(kg)", Modifier.offset(x = 25.dp))
        }

        // Age and Weight Button
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            a = ageInputBar()
            Spacer(modifier = Modifier.width(20.dp))
            w = weightBar()
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Height Heading
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextHeading("Height(cm)")
        }
        Spacer(modifier = Modifier.height(20.dp))
        h = heightBar()
        Spacer(modifier = Modifier.height(20.dp))
        calculateButton(h, w, a, navController)
        //Spacer(modifier = Modifier.height(20.dp))
    }
    }
}



// Composable 1: Gender Cards
@Composable
fun GenderCard(
    modifier: Modifier = Modifier,
    blackIcon: Painter,
    blueIcon: Painter,
    text: String
){
    var cardState = remember{mutableStateOf(false)}
    var iconState = remember{mutableStateOf(false)}
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .height(170.dp)
            .width(170.dp)
            .clickable { cardState.value = !cardState.value },
        colors = CardDefaults.cardColors(if (cardState.value || iconState.value) Color(0xFFE1F5FE) else Color(0xFFEEEEEE)),
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
                    .clickable { iconState.value = !iconState.value },
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


// Age input bar:
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ageInputBar(): Int{
    var counterValue = remember{mutableStateOf(20)}
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


// Text Heading:
@Composable
fun TextHeading(t: String, modifier: Modifier = Modifier){
    Text(text = t,
        fontSize = 20.sp,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}


@Composable
fun DisplayResult(d1: Double){
    Text(d1.toString(), fontSize = 32.sp, color = Color.Black)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiTopBar(){
    TopAppBar(
        title = {Text("BMI Calculator",
            fontSize = 32.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )},
        colors = TopAppBarDefaults.largeTopAppBarColors(Color.White)
    )
}


