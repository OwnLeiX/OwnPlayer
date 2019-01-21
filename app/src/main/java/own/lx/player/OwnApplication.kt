package own.lx.player

import android.app.Application
import lx.own.frame.frame.base.BaseApplication

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
class OwnApplication : BaseApplication() {

    companion object {
        lateinit var instance: Application
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}