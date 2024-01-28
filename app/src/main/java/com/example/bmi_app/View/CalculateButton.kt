package com.example.bmi_app

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.bmi_app.ViewModel.CalculateViewModel



@SuppressLint("RememberReturnType")
@Composable
fun calculateButton(h: Int, w: Int, a: Int , navController: NavController){
    //val b = remember{ mutableDoubleStateOf(0.0) }
    //var result: Double = 0.0
    val context = LocalContext.current

    val viewModel: CalculateViewModel = viewModel()
    val result: Float by viewModel.result.observeAsState(initial = 0.0f)
Column(
    modifier = Modifier.fillMaxSize()
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color(0xFF26C6DA)),
        modifier = Modifier
            .width(350.dp)
            .height(70.dp)
            .clickable(onClick = {
                viewModel.calculateBodyMassIndex(h, w)
                //navController.navigate("final/${result}")
            })
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "CALCULATE BMI",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )
        }
    }
    Text("Result: $result", fontSize = 20.sp, color = Color.Black)
}

}

