package com.example.hazard.convoaid.UI

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.RelativeLayout
import com.example.hazard.convoaid.Logic.GridListener

class GridView(context: Context): RelativeLayout(context), GridListener, HazardGridView {
    private var rows: Int = 0
    private var cols: Int = 0

    class BlockView(context: Context, width: Int, height: Int, val color: Color): View(context){
        init{
            this.height = height
        }
    }

    override fun setRows(rows: Int) {
        this.rows = rows
    }

    override fun setCols(cols: Int) {
        this.cols = cols
    }

    override fun setBorderColor(color: Color) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStartColor(color: Color) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun onGridChanged(grid: Array<Color>) {
        for (r in 0..rows) {
            for (c in 0..cols) {

            }
        }
    }



}