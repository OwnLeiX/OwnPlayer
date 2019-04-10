package own.lx.player.common.protocol

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/10.
 */
abstract class RecyclerViewInnerHolder<T> : RecyclerView.ViewHolder {
    constructor(view: View) : super(view) {
        bindView(view)
    }

    protected abstract fun bindView(view: View)

    abstract fun bindData(data: T, position: Int)
}