package own.lx.player.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import own.lx.player.R

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/23.
 */
class RecentlyHorizontalAdapter() :
    RecyclerView.Adapter<RecentlyHorizontalAdapter.InnerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): InnerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recently_horizontal, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 50
    }

    inner class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}