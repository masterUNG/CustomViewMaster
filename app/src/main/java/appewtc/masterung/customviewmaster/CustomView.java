package appewtc.masterung.customviewmaster;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by masterUNG on 4/1/2017 AD.
 */

public class CustomView extends View{

    private boolean isBlue = false;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithAttrs(attrs, defStyleAttr, defStyleAttr);
    }

    private void init() {
    }

    private void initWithAttrs(AttributeSet attributeSet,
                               int defStyleAttr,
                               int defStyleRss) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attributeSet,
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

        if (isBlue) {
            paint.setColor(Color.BLUE);
        } else {
            paint.setColor(Color.RED);
        }

        canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);

    }
}   // Main Class
