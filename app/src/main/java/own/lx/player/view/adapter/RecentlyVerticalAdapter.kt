package own.lx.player.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import own.lx.player.R
import own.lx.player.common.protocol.RecyclerViewInnerHolder
import own.lx.player.entity.VideoFileEntity

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/23.
 */
class RecentlyVerticalAdapter : RecyclerView.Adapter<RecentlyVerticalAdapter.InnerHolder>() {

    private var mData: MutableList<VideoFileEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): InnerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recently_horizontal, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        holder.bindData(mData!![position], position)
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    fun refreshData(data: MutableList<VideoFileEntity>?): Unit {
        mData = data
        notifyDataSetChanged()
    }

    fun appendData(data: VideoFileEntity): Unit {
        if (mData == null)
            mData = ArrayList()
        mData?.add(data)
    }

    inner class InnerHolder(itemView: View) : RecyclerViewInnerHolder<VideoFileEntity>(itemView) {
        override fun bindView(view: View) {

        }

        override fun bindData(data: VideoFileEntity, position: Int) {
        }
    }
}