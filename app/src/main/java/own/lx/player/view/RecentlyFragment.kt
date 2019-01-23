package own.lx.player.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lx.own.frame.frame.mvp.base.BaseFrameFragment
import own.lx.player.R
import own.lx.player.contract.RecentlyContract
import own.lx.player.entity.VideoFileEntity
import own.lx.player.model.RecentlyModel
import own.lx.player.presenter.RecentlyPresenter

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/23.
 */
class RecentlyFragment : BaseFrameFragment<RecentlyPresenter, RecentlyModel>(),
    RecentlyContract.IView {

    override fun onProvideContentView(inflater: LayoutInflater?, container: ViewGroup?): View {
        return inflater!!.inflate(R.layout.fragment_recently, container, false)
    }

    override fun onInitView(contentView: View?) {
    }

    override fun onInitListener() {
    }

    override fun onReceivedData(data: ArrayList<VideoFileEntity>?) {
    }

    override fun onReceivedError(errMsg: String) {
        showShortToast(errMsg)
    }
}