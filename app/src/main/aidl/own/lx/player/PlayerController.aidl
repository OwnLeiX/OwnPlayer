// PlayerController.aidl
package own.lx.player;

// Declare any non-default types here with import statements
import android.view.Surface;

interface PlayerController {
    void setSurface(in Surface s);
    void prepare(String uri);
    void start();
    void stop();
    void resume();
    void pause();
    void seek(long position);
    void variableSpeed(float speed);
    void volume(float volume);
}
