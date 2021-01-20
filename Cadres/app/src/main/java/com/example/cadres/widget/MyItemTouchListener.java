package com.example.cadres.widget;

import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemTouchListener implements RecyclerView.OnItemTouchListener {

    boolean canTouch;

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        return canTouch;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public void setCanTouch(boolean canTouch) {
        this.canTouch = canTouch;
    }
}
