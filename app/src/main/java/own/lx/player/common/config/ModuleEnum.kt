package own.lx.player.common.config

import own.lx.player.R

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/21.
 */
enum class ModuleEnum {
    Recently(
        R.drawable.exo_icon_fastforward,
        R.drawable.exo_notification_small_icon,
        R.string.recently
    ),
    History(
        R.drawable.exo_icon_fastforward,
        R.drawable.exo_notification_small_icon,
        R.string.history
    ),
    Local(
        R.drawable.exo_icon_fastforward,
        R.drawable.exo_notification_small_icon,
        R.string.local
    );

    val backgroundImgRes: Int
    val iconImgRes: Int
    val titleStringRes: Int

    private constructor(backgroundImgRes: Int, iconImgRes: Int, titleStringRes: Int) {
        this.backgroundImgRes = backgroundImgRes
        this.iconImgRes = iconImgRes
        this.titleStringRes = titleStringRes
    }
}