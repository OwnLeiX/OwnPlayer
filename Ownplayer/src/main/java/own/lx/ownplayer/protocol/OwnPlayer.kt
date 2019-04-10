package own.lx.ownplayer.protocol

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/10.
 */
interface OwnPlayer {
    fun init()
    fun release()
    fun prepare()
    fun start()
    fun stop()
    fun resume()
    fun pause()
    fun seek(position: Long)
    fun variableSpeed(speed: Float)
    fun volume(volume: Float)
}