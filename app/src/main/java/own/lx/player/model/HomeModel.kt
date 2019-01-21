package own.lx.player.model

import io.reactivex.Observable
import own.lx.player.common.config.ModuleEnum
import own.lx.player.common.dao.HistoriesDAO
import own.lx.player.contract.HomeContract
import own.lx.player.entity.VideoFileEntity

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
class HomeModel : HomeContract.IModel {

    override fun setCallback(t: HomeContract.IModel.HomeModelCallback?) {

    }

    override fun queryData(module: ModuleEnum): Observable<ArrayList<VideoFileEntity>> {
        return Observable.fromCallable {
            when (module) {
                ModuleEnum.Recently -> {
                    HistoriesDAO().queryRecently(5)
                }
                ModuleEnum.History -> {
                    HistoriesDAO().queryHistories()
                }
                else -> {
                    ArrayList()
                }
            }
        }
    }
}