package com.rodriguez.basketballapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var scoreLocal = MutableLiveData("0")
    var scoreGuest = MutableLiveData("0")

    fun resetScore() {
        scoreLocal.value = "0"
        scoreGuest.value = "0"
    }

    fun addPoints(points: Int, isLocal: Boolean) {
        if (isLocal) {
            scoreLocal.value = (scoreLocal.value!!.toInt() + points).toString()
        } else {
            scoreGuest.value = (scoreGuest.value!!.toInt() + points).toString()
        }
    }

    fun subtractScore(isLocal: Boolean) {
        if (isLocal) {
            if (scoreLocal.value!!.toInt() > 0) {
                scoreLocal.value = (scoreLocal.value!!.toInt() - 1).toString()
            }
        } else {
            if (scoreGuest.value!!.toInt() > 0) {
                scoreGuest.value = (scoreGuest.value!!.toInt() - 1).toString()
            }
        }
    }
}