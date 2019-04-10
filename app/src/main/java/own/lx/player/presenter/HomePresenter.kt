package own.lx.player.presenter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import own.lx.player.common.config.ModuleEnum
import own.lx.player.common.protocol.SingleParameterSubscriber
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

    private var mCurrentlyModule: ModuleEnum = ModuleEnum.History
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
        mBitmapProcessor?.destroy()
    }

    override fun switchModule(module: ModuleEnum) {
        if (mCurrentlyModule != module) {
            mCurrentlyModule = module
            refreshModule()
        }
    }

    override fun processBitmap(bitmap: Bitmap?, s: SingleParameterSubscriber<Bitmap>) {
        Observable
            .fromCallable { mBitmapProcessor!!.process(bitmap!!) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { s.onNext(it!!) }
    }

    private fun refreshModule() {
        mView.onModuleSwitched(mCurrentlyModule)
    }
}