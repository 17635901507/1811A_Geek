package com.example.geek.widget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleTouchHelperCallBack extends ItemTouchHelper.Callback {


    private TouchCallback callback;
    private boolean swipe = true;

    public SimpleTouchHelperCallBack(TouchCallback callback) {
        this.callback = callback;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        //允许上下拖拽
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //允许向左滑动
        int swipe = ItemTouchHelper.LEFT;
        //draw 拖拽的方向
        //swipe 滑动的方向
        return makeMovementFlags(drag,swipe);
    }

    //上下拖动item时回调，可以调用适配器的notifyItemMoved 方法来交换两个ViewHolder的位置
    //返回为true，表示被拖动的ViewHolder已经移动到了目的位置
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        callback.onMove(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        return false;
    }

    //当用户左右滑动item时达到删除条件就会调用，一般为一半，条目继续滑动删除，否则弹回
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        callback.onItemDelete(viewHolder.getAdapterPosition());
    }

    //支持长按拖动
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return swipe;
    }

    public void setSwipe(boolean swipe) {
        this.swipe = swipe;
    }
}
