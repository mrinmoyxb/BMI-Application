package com.example.bmi_app

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmi_app.ViewModel.SetUpNavGraph
import com.example.bmi_app.ui.theme.BMIAPPTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT, Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT, Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            BMIAPPTheme {
                val navController: NavHostController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}

