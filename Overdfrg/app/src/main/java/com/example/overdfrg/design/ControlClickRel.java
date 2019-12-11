package com.example.overdfrg.design;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;


public class ControlClickRel extends RelativeLayout {
    public ControlClickRel(Context context) {
        super(context);
    }

    public ControlClickRel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
