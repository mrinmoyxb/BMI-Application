package com.example.bmi_app

import android.app.FragmentManager.BackStackEntry
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument



@Composable
fun SetUpNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home"){
        // home screen:
        composable(route = "home"){
            HomeScreen(navController = navController)
        }

        // result screen
        composable(route = "result/{bmi_value}",
            arguments = listOf(
                navArgument("bmi_value"){
                    type = NavType.FloatType
                }
            )
        )
        {
            val bmi_r = it.arguments?.getFloat("bmi_value")
            ResultScreen(navController = navController, bmi_value = bmi_r!!)
        }
    }
}
