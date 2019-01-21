package own.lx.player.view

import android.support.design.widget.CollapsingToolbarLayout
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import lx.own.frame.frame.mvp.base.BaseFrameActivity
import own.lx.player.R
import own.lx.player.common.config.ModuleEnum
import own.lx.player.contract.HomeContract
import own.lx.player.entity.VideoFileEntity
import own.lx.player.model.HomeModel
import own.lx.player.presenter.HomePresenter

class HomeActivity : BaseFrameActivity<HomePresenter, HomeModel>(), HomeContract.IView {

    private val mTitleLayout: CollapsingToolbarLayout by lazy { findViewById<CollapsingToolbarLayout>(R.id.homeActivity_ctl_titleLayout) }
    private val mTitleBgImage: ImageView by lazy { findViewById<ImageView>(R.id.homeActivity_iv_titleBg) }
    private lateinit var mMenus: Array<View?>

    override fun onInitFuture() {
        setImmersedStatus(true)
    }

    override fun onInitView(root: View?) {
        val menu: LinearLayout = findViewById(R.id.homeActivity_ll_leftMenu)
        val modules = ModuleEnum.values()
        mMenus = Array<View?>(modules.size) { null }
        for (index in 0 until modules.size) {
            mMenus[index] = layoutInflater.inflate(R.layout.item_home_menu, menu, false)
            mMenus[index]?.tag = modules[index]
            mMenus[index]?.findViewById<TextView>(R.id.menu_tv)?.setText(modules[index].titleStringRes)
            mMenus[index]?.findViewById<ImageView>(R.id.menu_iv)?.setImageResource(modules[index].iconImgRes)
            mMenus[index]?.setOnClickListener(mPresenter.provideMenuClickListener())
            menu.addView(mMenus[index])
        }
    }

    override fun onInitListener() {
    }

    override fun onInitData(hasRestoreState: Boolean) {
    }

    override fun onProvideContentViewId(): Int {
        return R.layout.activity_home
    }

    override fun onModuleSwitched(module: ModuleEnum) {
        mTitleLayout.title = getString(module.titleStringRes)
        mTitleBgImage.setImageResource(module.backgroundImgRes)
    }

    override fun onReceivedData(data: ArrayList<VideoFileEntity>) {

    }

    override fun onReceivedError(message: String) {
        showShortToast(message)
    }
}
