package own.lx.player.model

import io.reactivex.Observable
import own.lx.player.common.dao.HistoriesDAO
import own.lx.player.contract.RecentlyContract
import own.lx.player.entity.VideoFileEntity

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/23.
 */
class RecentlyModel : RecentlyContract.IModel {
    override fun setCallback(t: Any?) {}

    override fun queryRecentlyVideos(): Observable<ArrayList<VideoFileEntity>> {
        return Observable.fromCallable {
            HistoriesDAO().queryRecently(10)
        }
    }
}