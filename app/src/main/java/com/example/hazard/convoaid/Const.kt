package com.example.hazard.convoaid

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi

@TargetApi(Build.VERSION_CODES.O)
class Const{
   companion object {
       public val startColor: Color = Color.valueOf(Color.GREEN)
       public val endColor: Color = Color.valueOf(Color.GRAY)
       public val borderColor: Color = Color.valueOf(Color.BLACK)
       public val columns: Int = 10
       public val rows: Int = 10

   }

}