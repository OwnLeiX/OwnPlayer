package own.lx.player.contract

import lx.own.frame.frame.mvp.BaseModel
import lx.own.frame.frame.mvp.BasePresenter
import lx.own.frame.frame.mvp.BaseView

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/16.
 */
interface LocalContract {
    interface IView : BaseView {
    }

    interface IModel : BaseModel<Any> {
    }

    abstract class IPresenter : BasePresenter<IModel, IView>() {

    }
}