package com.example.bmi_app.ViewModel



sealed class Screens(val route: String){
    object Home: Screens("home")
    object Result: Screens("result/{bmi_value}") // pass this to navigate button
}
