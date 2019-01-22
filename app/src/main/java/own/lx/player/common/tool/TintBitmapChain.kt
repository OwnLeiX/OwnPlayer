package own.lx.player.common.tool

import android.support.v8.renderscript.Allocation
import android.support.v8.renderscript.RenderScript
import android.support.v8.renderscript.Short4
import own.lx.renderscript.ScriptC_pixelTint


/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/22.
 */
class TintBitmapChain : BitmapProcessor.Chain {

    private val maskColor: Short4

    constructor(maskColor: Int) {
        this.maskColor = covertColor(maskColor)
    }

    private fun covertColor(color: Int): Short4 {
        return Short4(
            (color shr 16 and 0xFF).toShort(),
            (color shr 8 and 0xFF).toShort(),
            (color and 0xFF).toShort(),
            (color shr 24 and 0xFF).toShort()
        )
    }

    override fun process(render: RenderScript, inAlc: Allocation, outAlc: Allocation) {
        val script = ScriptC_pixelTint(render)
        script._maskColor = this@TintBitmapChain.maskColor
        script.forEach_pixelTint(inAlc, outAlc)
    }
}