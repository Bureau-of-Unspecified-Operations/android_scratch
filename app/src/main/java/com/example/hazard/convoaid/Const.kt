package com.example.hazard.convoaid

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build


@TargetApi(Build.VERSION_CODES.O)
class Const{
   companion object {
       public val startColor: Int = Color.GREEN
       public val endColor: Int = Color.GRAY
       public val pointsColor: Int = Color.BLUE
       public val borderColor: Int = Color.BLACK
       public val columns: Int = 10
       public val rows: Int = 10

   }

}