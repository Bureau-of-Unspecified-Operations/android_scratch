package com.example.hazard.convoaid.UI

import android.graphics.Color

interface HazardGridView {
    fun setRows(rows: Int)

    fun setCols(cols: Int)

    fun setBorderColor(color: Color)

    fun setStartColor(color: Color)
}