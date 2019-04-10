package own.lx.player.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import lx.own.frame.frame.base.BaseOnClickListener
import own.lx.player.R
import own.lx.player.common.config.ModuleEnum
import own.lx.player.common.protocol.RecyclerViewInnerHolder
import own.lx.player.common.protocol.SingleParameterSubscriber

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/10.
 */
class HomeLeftMenuAdapter : RecyclerView.Adapter<HomeLeftMenuAdapter.InnerHolder>() {

    private var data: Array<ModuleEnum>? = null
    private val clickListener: BaseOnClickListener
    private var subscriber: SingleParameterSubscriber<ModuleEnum>? = null

    init {
        clickListener = object : BaseOnClickListener() {
            override fun onValidClick(v: View?) {
                val tag = v?.tag
                if (tag is ModuleEnum) {
                    subscriber?.onNext(tag)
                }
            }
        }
    }

    fun refreshDAta(data: Array<ModuleEnum>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun subscribe(s: SingleParameterSubscriber<ModuleEnum>) {
        subscriber = s
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): InnerHolder {
        return InnerHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_home_menu, p0, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(p0: InnerHolder, p1: Int) {
        p0.bindData(data!![p1], p1)
    }


    inner class InnerHolder(itemView: View) : RecyclerViewInnerHolder<ModuleEnum>(itemView) {

        private var iv: ImageView? = null
        private var tv: TextView? = null

        override fun bindView(view: View) {
            iv = view.findViewById(R.id.menu_iv)
            tv = view.findViewById(R.id.menu_tv)
            view.setOnClickListener(clickListener)
        }

        override fun bindData(data: ModuleEnum, position: Int) {
            iv?.setImageResource(data.iconImgRes)
            tv?.setText(data.titleStringRes)
            itemView.tag = data
        }
    }
}