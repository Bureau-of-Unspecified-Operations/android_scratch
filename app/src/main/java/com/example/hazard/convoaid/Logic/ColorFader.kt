package com.example.hazard.convoaid.Logic

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import com.example.hazard.convoaid.Logic.ColorFaderListener
import com.example.hazard.convoaid.Logic.Fader

@TargetApi(Build.VERSION_CODES.O)
/**
 * 100 calls to inc should make the cur color the endcolor
 */
class ColorFader(private val sR: Float, private val sG: Float, private val sB: Float,
                 private val fR: Float, private val fG: Float, private val fB: Float,
                 private val listener: ColorFaderListener): Fader {
    private val interval: Int = 100
    private var curColor: Color = Color.valueOf(sR, sG, sB)
    private val rDif = fR - sR
    private val gDif = fG - sG
    private val bDif = fB - sB


    @TargetApi(Build.VERSION_CODES.O)
    override fun fade() {
        val r: Float = curColor.red()
        val g: Float = curColor.green()
        val b: Float = curColor.blue()

        curColor = Color.valueOf(rDif / interval + r * Math.signum(rDif), gDif / interval + g * Math.signum(gDif),
                                bDif  / interval + b * Math.signum(bDif))
        listener.onColorChange(curColor)
    }
}