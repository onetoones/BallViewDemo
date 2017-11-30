package chenshuai.bwie.com.ballviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 陈帅 on 2017/11/30.
 */

public class BallView extends View {

    private int typedArrayInteger;
    private float cx=100;
    private float cy=100;
    private float aa;
    private float aFloat;

    public BallView(Context context) {
        this(context,null);
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BallView);
        aFloat = typedArray.getDimension(R.styleable.BallView_ballsize, 70);
        Log.i("123333312",""+aFloat);
        //对自定义属性对象做回收资源逻辑的处理
        typedArray.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // ）	用canvas将屏幕设为白色
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();

        paint.setAntiAlias(true);
        //2）	设置画笔颜色为红色
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
//

        canvas.drawCircle(cx,cy,aFloat,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                cx = event.getX();
                cy = event.getY();
                Log.i("","按下时：x坐标:"+event.getRawX()+"   "+"按下时：y坐标:"+event.getRawY());
                break;
            case MotionEvent.ACTION_MOVE:
                cx = event.getX();
                cy = event.getY();
                Log.i("","移动时：x坐标:"+event.getRawX()+"   "+"移动时：y坐标:"+event.getRawY());

                break;
            case MotionEvent.ACTION_UP:
                cx = event.getX();
                cy = event.getY();
                Log.i("","抬起时：x坐标:"+event.getRawX()+"   "+"抬起时：y坐标:"+event.getRawY());
                break;

        }
        invalidate();
        return true;
    }
}
