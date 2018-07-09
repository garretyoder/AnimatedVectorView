package io.multimoon.animatedvectorview

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Looper
import android.support.annotation.DrawableRes
import android.support.graphics.drawable.Animatable2Compat
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.util.AttributeSet
import android.widget.ImageView

class AnimatedVectorView: ImageView {
    val mainHandler = android.os.Handler(Looper.getMainLooper())
    constructor(context: Context): this(context, null)
    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AnimatedVectorView)
        val aDrawable = typedArray.getResourceId(R.styleable.AnimatedVectorView_vectorSrc, 0)
        typedArray.recycle()
        setVectorSrc(aDrawable)
    }

    fun setVectorSrc(@DrawableRes drawable: Int) {
        mainHandler.removeCallbacksAndMessages(null)
        val aDrawable = AnimatedVectorDrawableCompat.create(context, drawable)
        setImageDrawable(aDrawable)
        aDrawable?.let {
            it.registerAnimationCallback(object: Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    mainHandler.post {
                        it.start()
                    }
                }
            })
        }
        aDrawable?.start()
    }

}