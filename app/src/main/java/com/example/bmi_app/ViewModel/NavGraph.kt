package com.example.bmi_app.ViewModel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bmi_app.HomeScreen
import com.example.bmi_app.ResultScreen


@Composable
fun SetUpNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home"){

        // home screen:
        composable(route = "home"){
            HomeScreen(navController = navController)
        }

        // result screen
        composable(route = "final/{bmi_value}/{age}/{height}/{weight}", arguments = listOf(
                navArgument("bmi_value"){
                    type = NavType.FloatType
                },
                navArgument("age"){
                    type = NavType.IntType
                },
                navArgument("height"){
                    type = NavType.IntType
                },
                navArgument("weight"){
                    type = NavType.IntType
                }
            )
        )
        {
            val bmi_r = it.arguments!!.getFloat("bmi_value")
            val age = it.arguments!!.getInt("age")
            val height = it.arguments!!.getInt("height")
            val weight = it.arguments!!.getInt("weight")
            ResultScreen(navController = navController, bmi_value = bmi_r, age = age, height = height, weight = weight)
        }
    }
}
