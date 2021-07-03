package com.parth.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.Dimension
import androidx.appcompat.widget.AppCompatImageView

class CurvedBottomImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    @AttrRes defaultAttr: Int = 0
) : AppCompatImageView(context, attributeSet, defaultAttr) {


    private var centerY: Float = 0f
    private var curveRadius: Float = 0f

    @Dimension(unit = Dimension.DP)
    var margin: Float = 0f
    private val clipPath = Path()

    init {
        this.setImageResource(R.color.black)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val height = measuredHeight
        val width = measuredWidth
        val smallHeight = height * 0.2f
        curveRadius = smallHeight / 2 + width * width / (8 * smallHeight)
        centerY = (height - curveRadius)
        clipPath.reset()
        clipPath.addRect(0f, 0f, width.toFloat(), centerY, Path.Direction.CW)
        clipPath.addCircle(
            (width / 2).toFloat(),
            centerY,
            curveRadius.toFloat(),
            Path.Direction.CW
        )
    }


    override fun onDraw(canvas: Canvas?) {
        canvas!!.clipPath(clipPath)
        super.onDraw(canvas)
    }

}