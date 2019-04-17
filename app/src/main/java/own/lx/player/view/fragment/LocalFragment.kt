package own.lx.player.view.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.own.frame.frame.mvp.base.BaseFrameFragment
import own.lx.player.R
import own.lx.player.model.LocalModel
import own.lx.player.presenter.LocalPresenter
import own.lx.player.view.adapter.RecentlyVerticalAdapter

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/16.
 */
class LocalFragment : BaseFrameFragment<LocalPresenter, LocalModel>() {

    private val mRecyclerView: RecyclerView by lazy { mContentView.findViewById<RecyclerView>(R.id.localFragment_rv_recyclerView) }

    override fun onProvideContentView(inflater: LayoutInflater?, container: ViewGroup?): View {
        return inflater!!.inflate(R.layout.fragment_local, container, false)
    }

    override fun onInitView(contentView: View?) {
        mRecyclerView.layoutManager = LinearLayoutManager(mRecyclerView.context, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.adapter = RecentlyVerticalAdapter()
    }

    override fun onInitListener() {
    }
}