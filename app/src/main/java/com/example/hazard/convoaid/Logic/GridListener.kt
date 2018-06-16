package com.example.hazard.convoaid.Logic

import android.graphics.Color
import com.example.hazard.convoaid.GridModel

interface GridListener {
    fun onGridChanged(grid: Array<Color>)
}