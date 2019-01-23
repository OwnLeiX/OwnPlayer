package own.lx.player.presenter

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import own.lx.player.contract.RecentlyContract

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/23.
 */
@SuppressLint("CheckResult")
class RecentlyPresenter : RecentlyContract.IPresenter() {

    override fun onInit(model: RecentlyContract.IModel?, view: RecentlyContract.IView?) {
        super.onInit(model, view)
    }

    override fun onIViewCreated() {
        queryData()
    }

    override fun onIViewStarted() {
    }

    override fun onIViewResumed() {
    }

    override fun onIViewPaused() {
    }

    override fun onIViewStopped() {
    }

    override fun onIViewDestroyed() {
    }


    private fun queryData() {
        mModel.queryRecentlyVideos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    mView.onReceivedData(it)
                },
                {
                    mView.onReceivedError(it.message ?: "")
                },
                {
                    mView.onTimeConsumingTaskFinished()
                }
            )
    }
}