package own.lx.player

import android.support.design.widget.CollapsingToolbarLayout
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import lx.own.frame.frame.base.BaseActivity

class HomeActivity : BaseActivity() {

    private lateinit var mCurrentlyModule: ModuleEnum
    private val mTitleLayout: CollapsingToolbarLayout by lazy { findViewById<CollapsingToolbarLayout>(R.id.homeActivity_ctl_titleLayout) }
    private val mTitleBgImage: ImageView by lazy { findViewById<ImageView>(R.id.homeActivity_iv_titleBg) }
    private lateinit var mMenus: Array<View?>

    override fun onInitFuture() {
        setImmersedStatus(true)
        mCurrentlyModule = ModuleEnum.Recently
    }

    override fun onInitView(root: View?) {
        mTitleLayout.title = getString(mCurrentlyModule.titleStringRes)
        mTitleBgImage.setImageResource(mCurrentlyModule.backgroundImgRes)
        val menu: LinearLayout = findViewById(R.id.homeActivity_ll_leftMenu)
        val modules = ModuleEnum.values()
        val menuClickListener = MenuClickListener()
        mMenus = Array<View?>(modules.size) { null }
        for (index in 0 until modules.size) {
            mMenus[index] = layoutInflater.inflate(R.layout.item_home_menu, menu, false)
            mMenus[index]?.tag = modules[index]
            mMenus[index]?.findViewById<TextView>(R.id.menu_tv)?.setText(modules[index].titleStringRes)
            mMenus[index]?.findViewById<ImageView>(R.id.menu_iv)?.setImageResource(modules[index].iconImgRes)
            mMenus[index]?.setOnClickListener(menuClickListener)
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

    private fun onSwitchModuleClicked(module: ModuleEnum): Unit {
        if (mCurrentlyModule != module) {

        }
    }

    private inner class MenuClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (v?.tag is ModuleEnum)
                onSwitchModuleClicked(v.tag as ModuleEnum)
        }

    }
}
