package own.lx.ownplayer.exo

import android.content.Context
import android.net.Uri
import android.view.Surface
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.analytics.AnalyticsCollector
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import own.lx.ownplayer.protocol.IOwnPlayer


/**
 * <b>Media IOwnPlayer implements by ExoPlayer</b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/10.
 */
class IOwnPlayerExoImpl(private val mContext: Context) : IOwnPlayer {

    private val mPlayer: SimpleExoPlayer by lazy {
        ExoPlayerFactory.newSimpleInstance(
            this@IOwnPlayerExoImpl.mContext,
            DefaultRenderersFactory(mContext),
            DefaultTrackSelector(AdaptiveTrackSelection.Factory()),
            DefaultLoadControl(),
            /* drmSessionManager= */ null,
            AnalyticsCollector.Factory(),
            Util.getLooper()
        )
    }

    private val mIOwnPlayerListener: Player.EventListener

    init {
        mIOwnPlayerListener = object : Player.EventListener {
            override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {

            }

            override fun onSeekProcessed() {
            }

            override fun onTracksChanged(trackGroups: TrackGroupArray?, trackSelections: TrackSelectionArray?) {
            }

            override fun onPlayerError(error: ExoPlaybackException?) {
            }

            override fun onLoadingChanged(isLoading: Boolean) {
            }

            override fun onPositionDiscontinuity(reason: Int) {
            }

            override fun onRepeatModeChanged(repeatMode: Int) {
            }

            override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
            }

            override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                when (playbackState) {
                    Player.STATE_IDLE -> {
                    }
                    Player.STATE_BUFFERING -> {
                    }
                    Player.STATE_READY -> {
                    }
                    Player.STATE_ENDED -> {
                    }
                }
            }
        }
    }


    override fun init() {
    }

    override fun release() {
        mPlayer.release()
    }

    override fun prepare(uri: String) {
        if (mPlayer.playbackState != Player.STATE_IDLE)
            mPlayer.stop(true)
        // 测量播放带宽，如果不需要可以传null
        val bandwidthMeter: DefaultBandwidthMeter = DefaultBandwidthMeter()
        // 创建加载数据的工厂
        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            mContext,
            Util.getUserAgent(mContext, "yourApplicationName"), bandwidthMeter
        )
        // 创建解析数据的工厂
        val extractorsFactory: ExtractorsFactory = DefaultExtractorsFactory()
        // 传入Uri、加载数据的工厂、解析数据的工厂，就能创建出MediaSource
        val mediaSource: MediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
            .setExtractorsFactory(extractorsFactory)
            .createMediaSource(Uri.parse(uri))
        mPlayer.prepare(mediaSource, true, true)
    }

    override fun start() {
        mPlayer.addListener(object : Player.EventListener {

        })
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

    override fun setSurface(s: Surface) {
        mPlayer.setVideoSurface(s)
    }
}