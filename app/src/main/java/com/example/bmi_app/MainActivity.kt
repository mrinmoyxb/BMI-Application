package com.example.bmi_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmi_app.ViewModel.SetUpNavGraph
import com.example.bmi_app.ui.theme.BMIAPPTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            BMIAPPTheme {
                val navController: NavHostController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}

