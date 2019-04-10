package own.lx.ownplayer.exo

import android.content.Context
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.analytics.AnalyticsCollector
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.util.Util
import own.lx.ownplayer.protocol.OwnPlayer


/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/10.
 */
class OwnPlayerExoImpl(private val mContext: Context) : OwnPlayer {

    private val mPlayer: SimpleExoPlayer by lazy {
        ExoPlayerFactory.newSimpleInstance(
            this@OwnPlayerExoImpl.mContext,
            DefaultRenderersFactory(mContext),
            DefaultTrackSelector(AdaptiveTrackSelection.Factory()),
            DefaultLoadControl(),
            /* drmSessionManager= */ null,
            AnalyticsCollector.Factory(),
            Util.getLooper()
        )
    }


    override fun init() {
    }

    override fun release() {
        mPlayer.release()
    }

    override fun prepare() {
//        mPlayer.prepare()
    }

    override fun start() {
    }

    override fun stop() {
        mPlayer.stop(true)
    }

    override fun resume() {
    }

    override fun pause() {
        mPlayer.stop(false)
    }

    override fun seek(position: Long) {
        mPlayer.seekTo(position)
    }

    override fun variableSpeed(speed: Float) {

    }

    override fun volume(volume: Float) {
        mPlayer.volume = volume
    }
}