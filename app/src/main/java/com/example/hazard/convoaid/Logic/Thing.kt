package com.example.hazard.convoaid.Logic

import android.view.View
import com.example.hazard.convoaid.ColorFader
import com.example.hazard.convoaid.Fader
import com.example.hazard.convoaid.Timer

class Thing(private val points: Points, private val fader: Fader): View.OnClickListener, Setup{
    private lateinit var timer: Timer
    private var length: Long = 0

    override fun onClick(v: View?) {
        points.inc()
        timer.cancel()
        timer = Timer(length, fader)
        timer.start()
    }

    override fun start(){
        timer = Timer(length, fader)
        timer.start()
    }

    override fun setTimer(length: Long){
        this.length = length
    }



}