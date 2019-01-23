package own.lx.player.contract

import android.graphics.Bitmap
import android.view.View
import lx.own.frame.frame.mvp.BaseModel
import lx.own.frame.frame.mvp.BasePresenter
import lx.own.frame.frame.mvp.BaseView
import own.lx.player.common.config.ModuleEnum

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

    interface IModel : BaseModel<Any> {
    }

    abstract class IPresenter : BasePresenter<IModel, IView>() {
        abstract fun provideMenuClickListener(): View.OnClickListener
        abstract fun processBitmap(bitmap: Bitmap?, function: (Bitmap) -> Unit)
    }
}