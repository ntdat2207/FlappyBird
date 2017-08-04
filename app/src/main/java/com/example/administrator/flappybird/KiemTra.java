package com.example.administrator.flappybird;

import android.content.Context;
import android.util.Log;

/**
 * Created by Administrator on 8/2/2017.
 */

public class KiemTra {
    private Context context;
    private int diem = 0;
    private boolean flagDiem , flagDiem2;

    public KiemTra(Context context) {
        this.context = context;
    }

    public boolean check() {
        boolean check = false;
        if (ConChim.getHeight() + ConChim.getBirdH() >= context.getResources().getDisplayMetrics().heightPixels - ManHinh.getGroundHeight()) {
            check = true;
        }
        if (((ConChim.getBirdW() + 50 >= OngNuoc.getX() - 65) && (ConChim.getBirdW() + 50) <= OngNuoc.getX()) && ((ConChim.getHeight() + ConChim.getBirdH() >= OngNuoc.getOngTrenH1() + OngNuoc.getKhoangCachTrenDuoi()) || ConChim.getHeight() <= OngNuoc.getOngTrenH1())) {
            check = true;
        }
        if (((ConChim.getBirdW() + 50 >= OngNuoc.getX2() - 65) && (ConChim.getBirdW() + 50) <= OngNuoc.getX2()) && ((ConChim.getHeight() + ConChim.getBirdH() >= OngNuoc.getOngTrenH2() + OngNuoc.getKhoangCachTrenDuoi()) || ConChim.getHeight() <= OngNuoc.getOngTrenH2())) {
            check = true;
        }
        return check;
    }

    public int tangDiem() {
        // Chim nam trogn ong nuoc thi gan flagDiem = true
        if (ConChim.getX() >= OngNuoc.getX() - 65 && ConChim.getX() <= OngNuoc.getX()) {
            flagDiem = true;
        }
        if (ConChim.getX() >= OngNuoc.getX2() - 65 && ConChim.getX() <= OngNuoc.getX2()) {
            flagDiem2 = true;
        }
        // Chim di qua ong nuoc thi tang diem len 1
        if (flagDiem && ConChim.getX() > OngNuoc.getX() || flagDiem2 && ConChim.getX() > OngNuoc.getX2()) {
            diem++;
            flagDiem = false;
            flagDiem2 = false;
        }
        return diem;
    }
}
