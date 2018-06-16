package com.example.hazard.convoaid.UI

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.example.hazard.convoaid.Const
import com.example.hazard.convoaid.Logic.ColorFader
import com.example.hazard.convoaid.Logic.GridModel
import com.example.hazard.convoaid.Logic.Manager
import com.example.hazard.convoaid.R

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener, View.OnClickListener {



    private lateinit var start: Button
    private lateinit var slider: SeekBar
    private lateinit var time_text: TextView
    private lateinit var mainView: View
    private lateinit var manager: Manager
    private lateinit var gridModel: GridModel
    private lateinit var colorFader: ColorFader
    private lateinit var gridView: com.example.hazard.convoaid.UI.GridView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainView = findViewById(R.layout.activity_main)
        setContentView(mainView)
        setup()
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun setup(){
        //Setup gridview
        gridView = com.example.hazard.convoaid.UI.GridView(this)
        gridModel = GridModel(Const.rows,Const.columns, gridView)
        colorFader = ColorFader(Const.startColor.red(),Const.startColor.green(),Const.startColor.blue(),
                                Const.endColor.red(),Const.endColor.green(), Const.endColor.blue(), gridModel)
        manager = Manager(gridModel, colorFader)

        start = mainView.findViewById(R.id.start_button)
        slider = mainView.findViewById(R.id.seek_bar)
        time_text = mainView.findViewById(R.id.seeker_time)

        slider.setOnSeekBarChangeListener(this)
        start.setOnClickListener(this)
    }

    private fun setupGrid(){
        gridView.setRows(Const.rows)
        gridView.setCols(Const.columns)
        gridView.setStartColor(Const.startColor)
        gridView.setBorderColor(Const.borderColor)
        setContentView(gridView)
    }

    override fun onClick(v: View?) {
        setupGrid()
        manager.start()
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        time_text.setText(progress.toString())
        manager.setTimer(Manager.secToLong(progress))
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}



}
