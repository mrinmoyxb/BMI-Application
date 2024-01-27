package com.example.bmi_app.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculateViewModel: ViewModel() {

    private var _result = MutableLiveData(0.0)
    val result: LiveData<Double> = _result

    fun calculateBodyMassIndex(h: Int, w: Int): Double{
        val heightCm: Double = h.toDouble()/100.0
        var r: Double = (w/(heightCm*heightCm))
        r = String.format("%.1f",result).toDouble()
        _result.value = r
        return _result.value!!
    }
}