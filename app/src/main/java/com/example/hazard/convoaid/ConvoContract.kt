package com.example.hazard.convoaid

interface ConvoContract {

    fun setFadeMax(maxVal: Int)

    fun incrementFade()

    fun incrementPoints()

    fun decrementPoints()

    fun reset()
}