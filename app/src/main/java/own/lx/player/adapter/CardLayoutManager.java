package own.lx.player.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * <b> </b><br/>
 *
 * @author LeiXun
 * Created on 2019/1/28.
 */
public class CardLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }

    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(dx, recycler, state);
    }
}
