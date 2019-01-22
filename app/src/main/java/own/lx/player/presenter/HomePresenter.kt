package own.lx.player.presenter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import own.lx.player.common.config.ModuleEnum
import own.lx.player.common.tool.BitmapProcessor
import own.lx.player.common.tool.BlurBitmapChain
import own.lx.player.common.tool.TintBitmapChain
import own.lx.player.contract.HomeContract

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
@SuppressLint("CheckResult")
class HomePresenter : HomeContract.IPresenter() {

    private var mCurrentlyModule: ModuleEnum = ModuleEnum.Recently
    private val mMenuClickListener: View.OnClickListener = View.OnClickListener {
        if (it?.tag is ModuleEnum)
            switchModule(it.tag as ModuleEnum)
    }
    private var mBitmapProcessor: BitmapProcessor? = null

    override fun onInit(model: HomeContract.IModel?, view: HomeContract.IView?) {
        mBitmapProcessor = BitmapProcessor(mView.provideActivity())
        mBitmapProcessor?.addChain(BlurBitmapChain(20.0f))
        mBitmapProcessor?.addChain(TintBitmapChain(0x33000000))
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
        mBitmapProcessor?.destory()
    }

    override fun provideMenuClickListener(): View.OnClickListener {
        return mMenuClickListener
    }

    override fun processBitmap(bitmap: Bitmap?, function: (Bitmap) -> Unit) {
        Observable
            .fromCallable { mBitmapProcessor!!.process(bitmap!!) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { function(it!!) }
    }

    private fun switchModule(module: ModuleEnum) {
        if (mCurrentlyModule != module) {
            mCurrentlyModule = module
            refreshModule()
        }
    }

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
                }
            )
    }
}