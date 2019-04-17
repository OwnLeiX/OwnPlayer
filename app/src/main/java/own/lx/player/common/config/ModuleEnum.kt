package own.lx.player.common.config

import android.support.v4.app.Fragment
import own.lx.player.R
import own.lx.player.view.fragment.LocalFragment
import own.lx.player.view.fragment.RecentlyFragment
import kotlin.reflect.KClass

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
enum class ModuleEnum {
    History(
        -1,
        R.drawable.calendar_icon,
        R.string.history,
        RecentlyFragment::class
    ),
    Local(
        -1,
        R.drawable.disk_icon,
        R.string.local,
        LocalFragment::class
    ),
    Network(
        -1,
        R.drawable.network_icon,
        R.string.network,
        RecentlyFragment::class
    ),
    Favorites(
        -1,
        R.drawable.heart_icon,
        R.string.favorites,
        RecentlyFragment::class
    ),
    Analytics(
        -1,
        R.drawable.analytics_icon,
        R.string.analytics,
        RecentlyFragment::class
    ),
    Search(
        -1,
        R.drawable.search_icon,
        R.string.search,
        RecentlyFragment::class
    );

    val backgroundImgRes: Int
    val iconImgRes: Int
    val titleStringRes: Int
    val fragmentClazz: KClass<out Fragment>

    private constructor(backgroundImgRes: Int, iconImgRes: Int, titleStringRes: Int, clazz: KClass<out Fragment>) {
        this.backgroundImgRes = backgroundImgRes
        this.iconImgRes = iconImgRes
        this.titleStringRes = titleStringRes
        this.fragmentClazz = clazz
    }
}