package own.lx.ownplayer

import android.content.Context
import own.lx.ownplayer.exo.IOwnPlayerExoImpl
import own.lx.ownplayer.protocol.IOwnPlayer

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/15.
 */
class OwnPlayer {
    companion object {
        fun getPlayer(c: Context): IOwnPlayer {
            return IOwnPlayerExoImpl(c)
        }
    }
}