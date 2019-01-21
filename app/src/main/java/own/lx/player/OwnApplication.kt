package own.lx.player

import android.app.Application
import lx.own.frame.frame.base.BaseApplication
import kotlin.properties.Delegates

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
class OwnApplication : BaseApplication() {

    companion object {
        var instance: Application by Delegates.notNull<Application>()
    }

    override fun onCreate() {
        super.onCreate()
        OwnApplication.instance = this
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}