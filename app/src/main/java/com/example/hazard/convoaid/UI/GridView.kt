package com.example.hazard.convoaid.UI

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.example.hazard.convoaid.Const
import com.example.hazard.convoaid.Logic.GridListener

@TargetApi(Build.VERSION_CODES.O)
class GridView(context: Context, private val rows: Int, private val cols: Int): RelativeLayout(context), GridListener {
    private val w: Int = width / cols
    private val h: Int = height / rows

    init{
        for (r in 0..rows) {
            for (c in 0..cols) {
                val parameters = RelativeLayout.LayoutParams(w, h)
                parameters.topMargin = rows * h
                parameters.leftMargin = cols * w
                val view = View(context)
                view.setBackgroundColor(Const.startColor)
                val index = c + r * rows
                addView(view, index, parameters)
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    override fun onGridChanged(grid: Array<Int>) {
        for (childIndex in 0..childCount){
            val view = getChildAt(childIndex)
            view.setBackgroundColor(grid[childIndex])

        }

    }



}