package com.example028;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {
    private Paint red, green, blue;
    private Rect square;
    private boolean touches[];
    private float touchx[];
    private float touchy[];
    private int first;
    private boolean touch;


    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CustomView(Context context, AttributeSet attributeSet, int defaultStyle) {
        super(context, attributeSet, defaultStyle);
        init();
    }

    private void init() {
        red = new Paint(Paint.ANTI_ALIAS_FLAG);
        green = new Paint(Paint.ANTI_ALIAS_FLAG);
        blue = new Paint(Paint.ANTI_ALIAS_FLAG);

        red.setColor(0xFFFF0000);
        green.setColor(0xFF00FF00);
        blue.setColor(0xFF00FF);

        touches = new boolean[16];
        touchx = new float[16];
        touchy = new float[16];

        touchx[0] = 200;
        touchy[0] = 200;

        square = new Rect(-100, -100, 100, 100);

        touch = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0; i < 16; i++) {
            if(touches[i]) {
                canvas.save();
                canvas.translate(touchx[i], touchy[i]);
                if(first == i) canvas.drawRect(square, red);
                else canvas.drawRect(square, green);
                canvas.restore();
            }
        }

        if(!touch) {
            canvas.save();
            canvas.translate(touchx[first], touchy[first]);
            canvas.drawRect(square, blue);
            canvas.restore();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {

        if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            int pointer_id = event.getPointerId(event.getActionIndex());
            touches[pointer_id] = true;
            touchx[pointer_id] = event.getX();
            touchy[pointer_id] = event.getY();
            touch = true;
            first = pointer_id;
            invalidate();
            return true;
        } else if(event.getActionMasked() == MotionEvent.ACTION_MOVE) {
            int pointer_id = event.getPointerId(event.getActionIndex());
            for(int i = 0; i < 16; i++) {
                int pointer_index = event.findPointerIndex(pointer_id);
                if(pointer_index != -1) {
                    touchx[i] = event.getX(pointer_index);
                    touchy[i] = event.getX(pointer_index);
                }
            }
            invalidate();
            return true;
        } else if(event.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN) {
            int pointer_id = event.getPointerId(event.getActionIndex());
            touches[pointer_id] = true;
            touchx[pointer_id] = event.getX(pointer_id);
            touchy[pointer_id] = event.getY(pointer_id);
            invalidate();
            return true;
        } else if(event.getActionMasked() == MotionEvent.ACTION_POINTER_UP) {
            int pointer_id = event.getPointerId(event.getActionIndex());
            touches[pointer_id] = false;
            if(pointer_id == first) {
                for(int i = 0; i < 16; i++) {
                    if(touches[i]) {
                        first = i;
                        break;
                    }
                }
            }
            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }

}
