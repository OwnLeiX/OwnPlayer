package own.lx.player.contract

import io.reactivex.Observable
import lx.own.frame.frame.mvp.BaseModel
import lx.own.frame.frame.mvp.BasePresenter
import lx.own.frame.frame.mvp.BaseView
import own.lx.player.entity.VideoFileEntity

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/23.
 */
interface RecentlyContract {
    interface IView : BaseView {
        fun onReceivedData(data: ArrayList<VideoFileEntity>?)
        fun onReceivedError(errMsg: String)
    }

    interface IModel : BaseModel<Any> {
        fun queryRecentlyVideos(): Observable<ArrayList<VideoFileEntity>>
    }

    abstract class IPresenter : BasePresenter<IModel, IView>() {

    }
}