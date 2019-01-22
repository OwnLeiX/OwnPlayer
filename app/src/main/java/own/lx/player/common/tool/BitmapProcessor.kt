package own.lx.player.common.tool

import android.content.Context
import android.graphics.Bitmap
import android.support.v8.renderscript.Allocation
import android.support.v8.renderscript.RenderScript
import java.util.concurrent.LinkedBlockingQueue

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/22.
 */
class BitmapProcessor {
    private val mRenderScript: RenderScript
    private val mChains: LinkedBlockingQueue<Chain>

    constructor(c: Context) {
        mRenderScript = RenderScript.create(c)
        mChains = LinkedBlockingQueue()
    }

    fun addChain(c: Chain) {
        mChains.offer(c)
    }

    fun removeChain(c: Chain) {
        val iterator = mChains.iterator()
        while (iterator.hasNext()) {
            if (iterator.next() == c) {
                iterator.remove()
                break
            }
        }
    }

    fun clearChain() {
        mChains.clear()
    }

    fun destroy() {
        mChains.clear()
        mRenderScript.destroy()
    }

    fun process(src: Bitmap): Bitmap {
        if (src.isRecycled) return src
        val dst: Bitmap = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
        var inAlc = Allocation.createFromBitmap(mRenderScript, src)
        var inAlc2: Allocation = Allocation.createFromBitmap(mRenderScript, dst)
        var outAlc: Allocation? = null
        var chain: Chain
        val iterator = mChains.iterator()
        while (iterator.hasNext()) {
            chain = iterator.next()
            outAlc = inAlc2
            chain.process(mRenderScript, inAlc, outAlc)
            inAlc2 = inAlc
            inAlc = outAlc
        }
        outAlc?.copyTo(dst)
        return dst
    }

    interface Chain {
        fun process(render: RenderScript, inAlc: Allocation, outAlc: Allocation)
    }
}