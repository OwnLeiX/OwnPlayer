package own.lx.player.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.view.Surface
import own.lx.ownplayer.OwnPlayer
import own.lx.ownplayer.protocol.IOwnPlayer
import own.lx.player.PlayerController

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/15.
 */
class PlayerService() : Service() {

    private var mIOwnPlayer: IOwnPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return object : PlayerController.Stub() {

            override fun setSurface(s: Surface) {
                mIOwnPlayer?.setSurface(s)
            }

            override fun prepare(uri: String) {
                mIOwnPlayer?.prepare(uri)
            }

            override fun start() {
                mIOwnPlayer?.start()
            }

            override fun stop() {
                mIOwnPlayer?.stop()
            }

            override fun resume() {
                mIOwnPlayer?.resume()
            }

            override fun pause() {
                mIOwnPlayer?.pause()
            }

            override fun seek(position: Long) {
                mIOwnPlayer?.seek(position)
            }

            override fun variableSpeed(speed: Float) {
                mIOwnPlayer?.variableSpeed(speed)
            }

            override fun volume(volume: Float) {
                mIOwnPlayer?.volume(volume)
            }

        }
    }

    override fun onUnbind(intent: Intent?): Boolean {
        mIOwnPlayer?.release()
        return false
    }

    override fun onCreate() {
        mIOwnPlayer = OwnPlayer.getPlayer(this)
    }

    override fun onDestroy() {
        mIOwnPlayer?.release()
        mIOwnPlayer = null
    }
}