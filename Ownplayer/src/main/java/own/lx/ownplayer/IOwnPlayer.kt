package own.lx.ownplayer

import android.view.Surface

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/10.
 */
interface IOwnPlayer {
    fun init()
    fun release()
    fun prepare(uri: String)
    fun start()
    fun stop()
    fun resume()
    fun pause()
    fun seek(position: Long)
    fun variableSpeed(speed: Float)
    fun volume(volume: Float)
    fun setSurface(s: Surface)
}