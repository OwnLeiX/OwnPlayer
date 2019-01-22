package own.lx.player.common.tool

import android.support.v8.renderscript.Allocation
import android.support.v8.renderscript.Element
import android.support.v8.renderscript.RenderScript
import android.support.v8.renderscript.ScriptIntrinsicBlur

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/22.
 */
class BlurBitmapChain : BitmapProcessor.Chain {

    private var radius: Float

    constructor(radius: Float) {
        this.radius = radius
    }

    fun setRadius(r: Float) {
        this.radius = r
    }

    override fun process(render: RenderScript, inAlc: Allocation, outAlc: Allocation) {
        val intrinsicBlur = ScriptIntrinsicBlur.create(render, Element.U8_4(render))
        intrinsicBlur.setInput(inAlc)
        intrinsicBlur.setRadius(radius)
        intrinsicBlur.forEach(outAlc)
    }
}