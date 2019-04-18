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
enum class ModuleEnum(
    val backgroundImgRes: Int,
    val iconImgRes: Int,
    val titleStringRes: Int,
    val fragmentClazz: KClass<out Fragment>,
    val hasFloatingButton: Boolean,
    val floatingButtonDrawableRes: Int
) {
    History(
        -1,
        R.drawable.calendar_icon,
        R.string.history,
        RecentlyFragment::class,
        false,
        -1
    ),
    Local(
        -1,
        R.drawable.disk_icon,
        R.string.local,
        LocalFragment::class,
        true,
        R.drawable.add_icon
    ),
    Network(
        -1,
        R.drawable.network_icon,
        R.string.network,
        RecentlyFragment::class,
        false,
        -1
    ),
    Favorites(
        -1,
        R.drawable.heart_icon,
        R.string.favorites,
        RecentlyFragment::class,
        false,
        -1
    ),
    Analytics(
        -1,
        R.drawable.analytics_icon,
        R.string.analytics,
        RecentlyFragment::class,
        false,
        -1
    ),
    Search(
        -1,
        R.drawable.search_icon,
        R.string.search,
        RecentlyFragment::class,
        false,
        -1
    );
}