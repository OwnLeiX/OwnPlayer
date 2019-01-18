package own.lx.player

import android.view.View
import lx.own.frame.frame.base.BaseActivity

class HomeActivity : BaseActivity() {

    override fun onInitFuture() {
        setImmersedStatus(true)
    }

    override fun onInitView(root: View?) {
    }

    override fun onInitListener() {
    }

    override fun onInitData(hasRestoreState: Boolean) {
    }

    override fun onProvideContentViewId(): Int {
        return R.layout.activity_home
    }


}
