package appewtc.masterung.customviewmaster;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by masterUNG on 4/1/2017 AD.
 */

public class CustomView extends View{

    private boolean isBlue = false;
    private boolean isDown = false;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context,
                      @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomView(Context context,
                      @Nullable AttributeSet attrs,
                      int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    public CustomView(Context context,
                      @Nullable AttributeSet attrs,
                      int defStyleAttr,
                      int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithAttrs(attrs, defStyleAttr, defStyleAttr);
    }

    private void init() {
    }

    private void initWithAttrs(AttributeSet attributeSet,
                               int defStyleAttr,
                               int defStyleRss) {
        TypedArray typedArray = getContext().getTheme()
                .obtainStyledAttributes(attributeSet,
                R.styleable.CustomView, defStyleAttr, defStyleRss);

        try {

            isBlue = typedArray.getBoolean(R.styleable.CustomView_isBlue, false);

        }finally {
            typedArray.recycle();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        //For isBlue
        if (isBlue) {
            paint.setColor(Color.BLUE);
        } else {
            paint.setColor(Color.RED);
        }

        //For isDown
        if (isDown) {
            paint.setColor(Color.MAGENTA);

            //Convent dp to px
            float vPx = conventDpToPx();
            paint.setStrokeWidth(vPx);

            canvas.drawLine(0, getMeasuredHeight(),
                    getMeasuredWidth(), 0, paint);

        }

        canvas.drawLine(0, 0,
                getMeasuredWidth(), getMeasuredHeight(),
                paint);

    }   // onDraw

    private float conventDpToPx() {
        float vPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                5,
                getContext().getResources().getDisplayMetrics());
        return vPx;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isDown = true;
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                isDown = false;
                invalidate();
                return true;
            case MotionEvent.ACTION_CANCEL:
                isDown = false;
                invalidate();
                return true;
        }

        return super.onTouchEvent(event);
    }   // onTouchEvent

}   // Main Class
