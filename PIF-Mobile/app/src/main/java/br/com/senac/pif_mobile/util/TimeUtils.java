package br.com.senac.pif_mobile.util;

import android.os.Handler;

public class TimeUtils {
    public static void wait(Runnable function, int millis) {
        Handler h = new Handler();
        h.postDelayed(function,millis);
    }
}
