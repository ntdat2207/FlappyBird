package com.example.administrator.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

/**
 * Created by Administrator on 8/2/2017.
 */

public class ConChim {
    private static int  height
            , birdW = 45
            , birdH = 37
            , x = 50;

    public static int getX() {
        return x;
    }

    public static int getBirdW() {
        return birdW;
    }

    public static int getBirdH() {
        return birdH;
    }

    public static int getHeight() {
        return height;
    }

    private Context context;

    public ConChim(Context context) {
        this.context = context;
        height = (context.getResources().getDisplayMetrics().heightPixels - 150)/2;
    }

    public void draw(Canvas canvas){
        Bitmap bmConChim = BitmapFactory.decodeResource(context.getResources(),R.drawable.bird);
        Bitmap scaleConChim = Bitmap.createScaledBitmap(bmConChim,birdW,birdH,true);
        canvas.drawBitmap(scaleConChim,x,height,null);
    }

    public void chamDat(){
        height+=5;
    }

    public void bayLen(){
        height-=50;
    }
}
