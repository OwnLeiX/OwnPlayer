package own.lx.player.common.config

import android.support.v4.app.Fragment
import own.lx.player.R
import own.lx.player.view.RecentlyFragment
import kotlin.reflect.KClass

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
enum class ModuleEnum {
    Recently(
        R.drawable.menu_bg,
        R.drawable.default_head,
        R.string.recently,
        RecentlyFragment::class
    ),
    History(
        R.drawable.menu_bg,
        R.drawable.default_head,
        R.string.history,
        RecentlyFragment::class
    ),
    Local(
        R.drawable.menu_bg,
        R.drawable.default_head,
        R.string.local,
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