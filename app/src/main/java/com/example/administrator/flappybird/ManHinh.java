package com.example.administrator.flappybird;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Administrator on 7/29/2017.
 */

public class ManHinh extends LinearLayout implements View.OnTouchListener{

    private static int groundHeight = 200;
    private boolean checkRun = true;
    private int checkTouch = 0;

    private int height, width, diem = 0;

    public static int getGroundHeight() {
        return groundHeight;
    }

    private OngNuoc on;
    private ConChim cc;
    private KiemTra kt;
    private ImageView img;

    public ManHinh(Context context) {
        super(context);
        on = new OngNuoc(context);
        cc = new ConChim(context);
        kt = new KiemTra(context);
        setOnTouchListener(this);
        setBackgroundResource(R.drawable.bg);

        height = getContext().getResources().getDisplayMetrics().heightPixels;
        width = getContext().getResources().getDisplayMetrics().widthPixels;

        img = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        img.setImageResource(R.drawable.tap);
        img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        img.setLayoutParams(layoutParams);
        addView(img);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Vẽ ống nước
        on.draw(canvas);

        // Vẽ chim
        cc.draw(canvas);

        // Vẽ điểm
        Paint paint = new Paint();
        paint.setColor(Color.TRANSPARENT);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        canvas.drawText(""+diem, getWidth()- 30, 30, paint);
    }

    Handler handler = new Handler();
    Runnable run = new Runnable() {
        public void run() {
            if(checkRun) {
                invalidate();
                on.diChuyenOng();
                cc.chamDat();
                if(kt.check()){
                    checkRun = false;
                }
                else{
                    diem = kt.tangDiem();
                    Log.d("DIEM",diem+"");
                }
                handler.postDelayed(this, 1);
            }
            else{

            }
        }
    };

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(checkTouch == 0){
            checkTouch = 1;
            img.setVisibility(GONE);
        }

        if(checkTouch == 1){
            run.run();
            checkTouch++;
        }

        cc.bayLen();
        return false;
    }
}
