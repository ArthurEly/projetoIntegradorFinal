package br.com.senac.pif_mobile.util;

import android.os.Handler;

public class TimeUtils {
    public static void wait(Runnable function, int millis) {
        Handler h = new Handler();
        h.postDelayed(function,millis);
    }

    public static int getYearBySQL(String SQL) {
        //eu ia fazer de outro jeito:
        String[] sqldividido = SQL.split("-");
        // divide em 3; ANO = 0, MÊS = 1 e DIA = 2

        return Integer.parseInt(sqldividido[0]);
    }

    public static int getMonthBySQL(String SQL) {
        //eu ia fazer de outro jeito:
        String[] sqldividido = SQL.split("-");
        // divide em 3; ANO = 0, MÊS = 1 e DIA = 2

        return Integer.parseInt(sqldividido[1]);
    }

    public static int getDayBySQL(String SQL) {
        //eu ia fazer de outro jeito:
        String[] sqldividido = SQL.split("-");
        // divide em 3; ANO = 0, MÊS = 1 e DIA = 2

        return Integer.parseInt(sqldividido[2]);
    }

    //done
}
