package com.example.bmi_app.ViewModel

import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculateViewModel: ViewModel() {

    val _result: MutableLiveData<Float> = MutableLiveData(0.0f)
    val result: LiveData<Float> = _result

    fun calculateBmi(h: Int, w: Int){
        val heightCm: Double = h.toDouble()/100.0
        var r: Double = (w/(heightCm*heightCm))
        var _r = String.format("%.1f",r).toDouble()
        _result.value = _r.toFloat()
    }
}