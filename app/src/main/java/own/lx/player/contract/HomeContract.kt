package own.lx.player.contract

import android.graphics.Bitmap
import lx.own.frame.frame.mvp.BaseModel
import lx.own.frame.frame.mvp.BasePresenter
import lx.own.frame.frame.mvp.BaseView
import own.lx.player.common.config.ModuleEnum
import own.lx.player.common.protocol.SingleParameterSubscriber

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
interface HomeContract {
    interface IView : BaseView {
        fun onModuleSwitched(module: ModuleEnum)
        fun onReceivedError(message: String)
    }

    interface IModel : BaseModel<Any>

    abstract class IPresenter : BasePresenter<IModel, IView>() {
        abstract fun switchModule(module: ModuleEnum)
        abstract fun processBitmap(bitmap: Bitmap?, s: SingleParameterSubscriber<Bitmap>)
        abstract fun floatingAction()
    }
}