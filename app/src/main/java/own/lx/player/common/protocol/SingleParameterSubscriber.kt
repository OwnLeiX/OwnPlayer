package own.lx.player.common.protocol

/**
 * <b> </b><br/>
 *
 * @author Lei.X
 * Created on 2019/4/10.
 */
interface SingleParameterSubscriber<T> {
    fun onNext(item: T)
}