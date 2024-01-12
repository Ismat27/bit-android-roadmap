package com.alat.roadmap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OpeyemiViewModel : ViewModel() {
    private val _likesFood = MutableLiveData<String>()

    val likesFood: LiveData<String> = _likesFood

    fun updateOpeyemiFood(foodItem: String) {
        _likesFood.value = foodItem
    }

    fun receiveFoodLater(foodItem: String) {
        Thread {
            _likesFood.postValue(foodItem)
        }
            .start()
    }

}