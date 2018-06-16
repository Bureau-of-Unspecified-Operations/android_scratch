package com.example.hazard.convoaid.Logic

import android.view.View

class Manager(private val points: Points, private val fader: Fader): View.OnClickListener, Setup{
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

    companion object {
        fun secToLong(time: Int): Long{
            return (time * 60 * 1000).toLong()
        }
    }



}