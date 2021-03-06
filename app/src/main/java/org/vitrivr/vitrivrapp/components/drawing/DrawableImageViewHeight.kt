package org.vitrivr.vitrivrapp.components.drawing

import android.content.Context
import android.util.AttributeSet

/**
 * This class extends DrawableImageView to adjust width based on height
 */
class DrawableImageViewHeight @JvmOverloads constructor(context: Context,
                                                        attrs: AttributeSet? = null,
                                                        defStyleAttr: Int = 0,
                                                        defStyleRes: Int = 0) :
        DrawableImageView(context, attrs, defStyleAttr, defStyleRes) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(heightMeasureSpec, heightMeasureSpec)
    }
}
