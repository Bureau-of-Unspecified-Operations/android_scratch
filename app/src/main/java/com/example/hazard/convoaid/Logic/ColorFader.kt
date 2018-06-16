package com.example.hazard.convoaid.Logic

import android.annotation.TargetApi
import android.graphics.Color
import android.graphics.Color.rgb
import android.os.Build
import com.example.hazard.convoaid.Logic.ColorFaderListener
import com.example.hazard.convoaid.Logic.Fader

@TargetApi(Build.VERSION_CODES.O)
/**
 * 100 calls to inc should make the cur color the endcolor
 */
class ColorFader(private val sR: Int, private val sG: Int, private val sB: Int,
                 private val fR: Int, private val fG: Int, private val fB: Int,
                 private val listener: ColorFaderListener): Fader {
    private val interval: Int = 100
    private var curColor: Int = rgb(sR, sG, sB)
    private val rDif = fR - sR
    private val gDif = fG - sG
    private val bDif = fB - sB


    @TargetApi(Build.VERSION_CODES.O)
    override fun fade() {
        val r: Int = Color.red(curColor)
        val g: Int = Color.green(curColor)
        val b: Int = Color.blue(curColor)

        curColor = rgb(rDif / interval + r * Math.signum(rDif.toDouble()), gDif / interval + g * Math.signum(gDif.toDouble()),
                                bDif  / interval + b * Math.signum(bDif.toDouble()))
        listener.onColorChange(curColor)
    }
}