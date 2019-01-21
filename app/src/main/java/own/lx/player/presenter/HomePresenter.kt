package own.lx.player.presenter

import android.annotation.SuppressLint
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import own.lx.player.common.config.ModuleEnum
import own.lx.player.contract.HomeContract

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
class HomePresenter : HomeContract.IPresenter() {

    private var mCurrentlyModule: ModuleEnum = ModuleEnum.Recently
    private val mMenuClickListener: View.OnClickListener = View.OnClickListener {
        if (it?.tag is ModuleEnum)
            switchModule(it.tag as ModuleEnum)
    }

    override fun onIViewCreated() {
        refreshModule()
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

    override fun provideMenuClickListener(): View.OnClickListener {
        return mMenuClickListener
    }

    private fun switchModule(module: ModuleEnum) {
        if (mCurrentlyModule != module) {
            mCurrentlyModule = module
            refreshModule()
        }
    }

    @SuppressLint("CheckResult")
    private fun refreshModule() {
        mView.onModuleSwitched(mCurrentlyModule)
        mView.onTimeConsumingTaskStarted()
        mModel.queryData(mCurrentlyModule)
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
                })

    }
}