package com.nie.nieapp.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 说明：
 * Created by code_nil on 2018/3/2.
 * 君子自强不息
 */
class SlideShoeView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    val slidePath= Path()
    val paint=Paint()
    init {
        paint.color=Color.RED
        paint.isAntiAlias=true
        paint.style=Paint.Style.FILL
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //执行测量
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画滑动块
        slidePath.moveTo(0f,100f)
        slidePath.lineTo(200f,200f)
//        slidePath.lineTo(400f,200f)
//        slidePath.lineTo(0f,400f)
//        slidePath.lineTo(0f,200f)
//        slidePath.lineTo(0f,100f)
//        slidePath.close()
        canvas.drawPath(slidePath, paint)
        //画竖线
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }
}