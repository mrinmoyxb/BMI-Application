package com.example.bmi_app

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmi_app.View.BmiHomeScreen.Components.BmiTopBar
import com.example.bmi_app.View.BmiHomeScreen.Components.GenderCard
import com.example.bmi_app.View.BmiHomeScreen.Components.TextHeading
import com.example.bmi_app.View.BmiHomeScreen.Components.ageInputBar


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
        modifier = Modifier.fillMaxSize().padding(top = 55.dp).background(Color.White),
        verticalArrangement = Arrangement.Center,
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

        Spacer(modifier = Modifier.height(10.dp))

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
        Spacer(modifier = Modifier.height(10.dp))
        h = heightBar()
        Spacer(modifier = Modifier.height(25.dp))
        calculateButton(h, w, a, navController)
    }
    }
}



@Preview(showBackground = true)
@Composable
fun displayScreen(){
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}



