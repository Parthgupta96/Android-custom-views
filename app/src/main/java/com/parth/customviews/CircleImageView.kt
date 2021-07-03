package com.parth.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageView

class CircleImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    @AttrRes defaultAttr: Int = 0
) : AppCompatImageView(context, attributeSet, defaultAttr) {


    private val clipPath = Path()

    init {
        this.setImageResource(R.color.black)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        val size = Math.min(measuredWidth, measuredHeight)
//        setMeasuredDimension(size, size)


        val desiredWidth = 100
        val desiredHeight = 100

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        //Measure Width

        //Measure Width
        width = when (widthMode) {
            MeasureSpec.EXACTLY -> {
                //Must be this size
                widthSize
            }
            MeasureSpec.AT_MOST -> {
                //Can't be bigger than...
                widthSize
            }
            else -> {
                //Be whatever you want
                desiredWidth
            }
        }

        //Measure Height

        //Measure Height
        height = when (heightMode) {
            MeasureSpec.EXACTLY -> {
                //Must be this size
                heightSize
            }
            MeasureSpec.AT_MOST -> {
                //Can't be bigger than...
                heightSize
            }
            else -> {
                //Be whatever you want
                heightSize
            }
        }

        //MUST CALL THIS
        val size = Math.min(height, width)
        setMeasuredDimension(size, size)


    }


    override fun onDraw(canvas: Canvas?) {
        val size = Math.min(height, width)
        clipPath.reset()
        clipPath.addCircle(width / 2f, height / 2f, size / 2f, Path.Direction.CW)
        canvas!!.clipPath(clipPath)
        super.onDraw(canvas)


    }

}