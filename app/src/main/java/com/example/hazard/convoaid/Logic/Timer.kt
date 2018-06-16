package com.example.hazard.convoaid.Logic

import android.os.CountDownTimer

class Timer(tillFinish: Long, private val fader: Fader): CountDownTimer(tillFinish, interval) {
    companion object {
       const val interval: Long = 600
    }
    private val startFading: Long = 60000

    override fun onFinish() {

    }

    override fun onTick(millisUntilFinished: Long) {
        if (millisUntilFinished < startFading){
            fader.inc()
        }
    }

}