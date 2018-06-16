package com.example.hazard.convoaid

import android.graphics.Color
import com.example.hazard.convoaid.Logic.ColorFaderListener

class ColorFader(private val startColor: Color, private val endColor: Color, private val listener: ColorFaderListener): Fader {
    private var curColor: Color = Color()

    override fun inc() {
       listener.onColorChange(curColor)
    }

    override fun setMaxVal(mVal: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}