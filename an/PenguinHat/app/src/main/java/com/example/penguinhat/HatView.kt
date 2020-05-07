package com.example.penguinhat

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class HatView(var bitmapX : Float, var bitmapY : Float, context : Context?) : View(context) {

    constructor(context: Context) : this(65F, 0F, context)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.hat)
        if (canvas != null) {
            canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint)
            if (bitmap.isRecycled()) {
                bitmap.recycle()
            }
        }
    }
}