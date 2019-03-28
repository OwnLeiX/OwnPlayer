package own.lx.player.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/3/28.
 */
class ScrollEnableViewPager : ViewPager {

    private var isScrollEnabled: Boolean = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    fun isScrollEnabled(): Boolean {
        return isScrollEnabled
    }

    fun setScrollEnabled(enable: Boolean): Unit {
        this.isScrollEnabled = enable
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return isScrollEnabled && super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return isScrollEnabled && super.onTouchEvent(ev)
    }
}