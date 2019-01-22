package own.lx.player.contract

import android.graphics.Bitmap
import android.view.View
import io.reactivex.Observable
import lx.own.frame.frame.mvp.BaseModel
import lx.own.frame.frame.mvp.BasePresenter
import lx.own.frame.frame.mvp.BaseView
import own.lx.player.common.config.ModuleEnum
import own.lx.player.entity.VideoFileEntity

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
interface HomeContract {
    interface IView : BaseView {
        fun onModuleSwitched(module: ModuleEnum)
        fun onReceivedData(data: ArrayList<VideoFileEntity>)
        fun onReceivedError(message: String)
    }

    interface IModel : BaseModel<IModel.HomeModelCallback> {
        fun queryData(module: ModuleEnum): Observable<ArrayList<VideoFileEntity>>

        interface HomeModelCallback {
        }
    }

    abstract class IPresenter : BasePresenter<IModel, IView>() {
        abstract fun provideMenuClickListener(): View.OnClickListener
        abstract fun processBitmap(bitmap: Bitmap?, function: (Bitmap) -> Unit)
    }
}