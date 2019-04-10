package own.lx.player.view.activity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import lx.own.frame.frame.mvp.base.BaseFrameActivity
import own.lx.player.R
import own.lx.player.common.config.ModuleEnum
import own.lx.player.common.protocol.SingleParameterSubscriber
import own.lx.player.contract.HomeContract
import own.lx.player.model.HomeModel
import own.lx.player.presenter.HomePresenter
import own.lx.player.view.adapter.HomeLeftMenuAdapter

class HomeActivity : BaseFrameActivity<HomePresenter, HomeModel>(), HomeContract.IView {

    private val mDrawer: DrawerLayout by lazy { findViewById<DrawerLayout>(R.id.homeActivity_dl_drawer) }
    private val mTitleRoot: AppBarLayout by lazy { findViewById<AppBarLayout>(R.id.homeActivity_abl_titleRoot) }
    private val mTitleLayout: CollapsingToolbarLayout by lazy { findViewById<CollapsingToolbarLayout>(R.id.homeActivity_ctl_titleLayout) }
    private val mTitleBgImage: ImageView by lazy { findViewById<ImageView>(R.id.homeActivity_iv_titleBg) }
    private val mMenuBgImage: ImageView by lazy { findViewById<ImageView>(R.id.homeActivity_iv_menuBg) }
    private val mViewPager: ViewPager by lazy { findViewById<ViewPager>(R.id.homeActivity_vp_content) }
    private var mCurrentlyFragment: Fragment? = null

    override fun onInitFuture() {
        setImmersedStatus(true)
    }

    override fun onInitView(root: View?) {
        val menu: RecyclerView = findViewById(R.id.homeActivity_rv_leftMenu)
        menu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val modules = ModuleEnum.values()
        val adapter = HomeLeftMenuAdapter()
        adapter.refreshDAta(modules)
        //Capturing Expression, do not use lambda.
        adapter.subscribe(
            object : HomeLeftMenuAdapter.MenuSelectedSubscriber {
                override fun onNext(item: ModuleEnum) {
                    mPresenter.switchModule(item)
                }
            })
        menu.adapter = adapter
    }

    override fun onInitListener() {
    }

    override fun onInitData(hasRestoreState: Boolean) {
        //Capturing Expression, do not use lambda.
        mPresenter.processBitmap(
            (mMenuBgImage.drawable as BitmapDrawable).bitmap,
            object : SingleParameterSubscriber<Bitmap> {
                override fun onNext(item: Bitmap) {
                    mMenuBgImage.setImageBitmap(item)
                }
            }
        )
    }

    override fun onProvideContentViewId(): Int {
        return R.layout.activity_home
    }

    override fun onModuleSwitched(module: ModuleEnum) {
        mDrawer.closeDrawers()
        mTitleLayout.title = getString(module.titleStringRes)
        mTitleBgImage.setImageResource(module.backgroundImgRes)
        mCurrentlyFragment = module.fragmentClazz.java.newInstance()
        if (mViewPager.adapter == null) {
            mViewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
                override fun getItem(p0: Int): Fragment {
                    return ModuleEnum.values()[p0].fragmentClazz.java.newInstance()
                }

                override fun getCount(): Int {
                    return ModuleEnum.values().size
                }
            }
        } else {
            mViewPager.setCurrentItem(module.ordinal, true)
        }
        mTitleRoot.setExpanded(true, true)
    }

    override fun onReceivedError(message: String) {
        showShortToast(message)
    }
}
