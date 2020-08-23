package br.com.senac.pif_mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class ActivityUtils {
    public static void startActivity(Activity act, Class next) {
        Intent i = new Intent(act,next);
        act.startActivity(i);
    }

    public static void requestPermission(Activity act, String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            act.requestPermissions(new String[]{permission}, 1);
        } else {
            System.out.println("não é necessário pedir permissão em Androids anteriores a 5.0");
        }
    }

    public static void requestPermission(Activity act, String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            act.requestPermissions(permissions, 1);
        } else {
            System.out.println("não é necessário pedir permissões em Androids anteriores a 5.0");
        }
    }
}
