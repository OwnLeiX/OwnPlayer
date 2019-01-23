package own.lx.player.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/23.
 */
class RecentlyVerticalAdapter : RecyclerView.Adapter<RecentlyVerticalAdapter.InnerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): InnerHolder {
        var textView = TextView(parent.context)
        textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200)
        return InnerHolder(textView)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        (holder.itemView as TextView).text = "this is position $position ."
    }

    override fun getItemCount(): Int {
        return 50
    }

    inner class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}