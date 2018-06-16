package com.example.hazard.convoaid.Logic

class Matrix2d<T>(val rows: Int, val cols: Int, private val data: Array<T>) {

    companion object {
        operator inline fun <reified T> invoke(rows: Int, cols: Int, init: (Int, Int) -> T): Matrix2d<T> {
            return Matrix2d(rows, cols, Array(rows * cols, { i ->
                val r = Math.floor(i.toDouble() / cols).toInt()
                init(r, i - r * cols)
            }))
        }
    }

    init {
        if (rows * cols != data.size) throw IllegalArgumentException("Illegal array size: ${data.size}")
    }

    operator fun get(row: Int, col: Int): T = data[row * cols + col]

    operator fun set(row: Int, col: Int, v: T) {
        data[row * cols + col] = v
    }
}