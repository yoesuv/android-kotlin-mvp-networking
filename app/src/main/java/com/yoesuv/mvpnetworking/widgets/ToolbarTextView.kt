package com.yoesuv.mvpnetworking.widgets

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 *  Created by yusuf on 4/17/18.
 */
class ToolbarTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        val tf:Typeface = Typeface.createFromAsset(context.assets, "fonts/pacifico.ttf")
        typeface = tf
    }

}