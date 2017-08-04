package com.example.administrator.flappybird;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.Random;

/**
 * Created by Administrator on 8/2/2017.
 */

public class OngNuoc {
    private static int ongTrenH1, ongDuoiH1, ongTrenH2, ongDuoiH2;
    private static final int ongRong = 65;
    private static final int khoangCachTrenDuoi = 150;
    private Context context;
    private static int width,height,x,x2;
    boolean flag = true, flag2 = true;

    public static int getKhoangCachTrenDuoi() {
        return khoangCachTrenDuoi;
    }

    public OngNuoc(Context context) {
        this.context = context;
        width = context.getResources().getDisplayMetrics().widthPixels;
        height = context.getResources().getDisplayMetrics().heightPixels;
        x = width;
        x2 = width + width / 2;
    }

    public static int getX() {
        return x;
    }

    public static int getX2() {
        return x2;
    }

    public static int getOngTrenH1() {
        return ongTrenH1;
    }

    public static int getOngDuoiH1() {
        return ongDuoiH1;
    }

    public static int getOngTrenH2() {
        return ongTrenH2;
    }

    public static int getOngDuoiH2() {
        return ongDuoiH2;
    }

    private void randomHeight(){
        Random rd = new Random();
        if(flag) {
            ongTrenH1 = rd.nextInt(100) + height/2 - ManHinh.getGroundHeight();
            ongDuoiH1 = height - ongTrenH1 - khoangCachTrenDuoi - ManHinh.getGroundHeight();
            Log.d("WWW",ongDuoiH1+" "+ongTrenH1);
            flag = false;
        }
        if(flag2){
            ongTrenH2 = rd.nextInt(150) + 200;
            ongDuoiH2 = height - ongTrenH2 - khoangCachTrenDuoi - ManHinh.getGroundHeight();
            flag2 = false;
        }
    }

    public void draw(Canvas canvas){
        randomHeight();

        // Ống nước trên
        Bitmap bmOngTren = BitmapFactory.decodeResource(context.getResources(),R.drawable.ongnuoctren);
        Bitmap scaleOngTren = Bitmap.createScaledBitmap(bmOngTren,ongRong,ongTrenH1,true);
        canvas.drawBitmap(scaleOngTren,x-ongRong,0,null);

        Bitmap bmOngTren2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.ongnuoctren);
        Bitmap scaleOngTren2 = Bitmap.createScaledBitmap(bmOngTren2,ongRong,ongTrenH2,true);
        canvas.drawBitmap(scaleOngTren2,x2-ongRong,0,null);

        // Ống nước dưới:
        Bitmap bmOngDuoi = BitmapFactory.decodeResource(context.getResources(),R.drawable.ongnuocduoi);
        Bitmap scaleOngDuoi = Bitmap.createScaledBitmap(bmOngDuoi,ongRong,ongDuoiH1,true);
        canvas.drawBitmap(scaleOngDuoi,x-ongRong,ongTrenH1 + khoangCachTrenDuoi,null);

        Bitmap bmOngDuoi2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.ongnuocduoi);
        Bitmap scaleOngDuoi2 = Bitmap.createScaledBitmap(bmOngDuoi2,ongRong,ongDuoiH2,true);
        canvas.drawBitmap(scaleOngDuoi2,x2-ongRong,ongTrenH2 + khoangCachTrenDuoi,null);
    }

    public void diChuyenOng(){
        x-=5;
        x2-=5;
        lapLai();
    }

    private void lapLai() {
        if(x <= 0 ){
            x = width;
            flag = true;
        }
        if(x2 <= 0){
            x2 = width;
            flag2 = true;
        }
    }

}
