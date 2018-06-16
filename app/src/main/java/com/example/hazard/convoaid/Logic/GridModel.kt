package com.example.hazard.convoaid.Logic

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import com.example.hazard.convoaid.Logic.ColorFaderListener
import com.example.hazard.convoaid.Logic.GridListener
import com.example.hazard.convoaid.Logic.Points

@TargetApi(Build.VERSION_CODES.O)
class GridModel(row: Int, col: Int, private val listener: GridListener): Points, ColorFaderListener {
    @RequiresApi(Build.VERSION_CODES.O)
    private val startColor: Color = Color.valueOf(Color.GREEN)
    private val pointColor: Color = Color.valueOf(Color.BLUE)
    private val grid: Array<Color> = Array(row * col, {i -> startColor})
    private var pointIndex: Int = 0

    override fun onColorChange(color: Color) {
        for(i in pointIndex..grid.size){
            grid.set(i, color)
        }
        listener.onGridChanged(grid)
    }

    override fun inc() {
        pointIndex ++
        grid.set(pointIndex, pointColor)
        listener.onGridChanged(grid)
    }

    override fun reset() {
        pointIndex = 0
        for (i in 0..grid.size){
            grid.set(i, startColor)
        }
        listener.onGridChanged(grid)
    }
}