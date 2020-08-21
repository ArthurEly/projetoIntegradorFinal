package br.com.senac.pif_mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ActivityUtils {
    public static void startActivity(Activity act, Class next) {
        Intent i = new Intent(act,next);
        act.startActivity(i);
    }
}
