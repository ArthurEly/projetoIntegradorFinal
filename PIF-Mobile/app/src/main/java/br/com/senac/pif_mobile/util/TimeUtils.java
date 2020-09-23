package br.com.senac.pif_mobile.util;

import android.os.Handler;

public class TimeUtils {
    public static void wait(Runnable function, int millis) {
        Handler h = new Handler();
        h.postDelayed(function,millis);
    }

    public static int getYearBySQL(String SQL) {
        //eu ia fazer de outro jeito:
        //bota um if
        //if menor que tanto, divide só a data
        //se for maior divide a data e a hora blz

        //formato de data: 0123-45-67 (10 caracteres)
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
        if (sqldividido[2].contains(" ") /*Separador de horas*/) {
            String[] sqldivididodividido = sqldividido[2].split(" ");
            return Integer.parseInt(sqldivididodividido[0]);
        } else {
            return Integer.parseInt(sqldividido[2]);
        }
    }

    public static int getHoursBySQL(String SQL) {
        //eu ia fazer de outro jeito:
        String[] sqldividido = SQL.split("-");
        // divide em 3; ANO = 0, MÊS = 1 e DIA = 2
        if (sqldividido[2].contains(" ") /*Separador de horas*/) {
            String[] dia = sqldividido[2].split(" ");
            String[] tempo = dia[1 /*Só no chute*/].split(":");
            /**
             * tempo[0] = Hora
             * tempo[1] = Minuto
             * tempo[2] = Segundo
             */
            return Integer.parseInt(tempo[0]);
        } else {
            return 00;
        }
    }

    public static int getMinutesBySQL(String SQL) {
        //eu ia fazer de outro jeito:
        String[] sqldividido = SQL.split("-");
        // divide em 3; ANO = 0, MÊS = 1 e DIA = 2
        if (sqldividido[2].contains(" ") /*Separador de horas*/) {
            String[] dia = sqldividido[2].split(" ");
            String[] tempo = dia[1 /*Só no chute*/].split(":");
            /**
             * tempo[0] = Hora
             * tempo[1] = Minuto
             * tempo[2] = Segundo
             */
            return Integer.parseInt(tempo[1]);
        } else {
            return 00;
        }
    }

    public static int getSecondsBySQL(String SQL) {
        //eu ia fazer de outro jeito:
        String[] sqldividido = SQL.split("-");
        // divide em 3; ANO = 0, MÊS = 1 e DIA = 2
        if (sqldividido[2].contains(" ") /*Separador de horas*/) {
            String[] dia = sqldividido[2].split(" ");
            String[] tempo = dia[1 /*Só no chute*/].split(":");
            /**
             * tempo[0] = Hora
             * tempo[1] = Minuto
             * tempo[2] = Segundo
             */
            return Integer.parseInt(tempo[2]);
        } else {
            return 00;
        }
    }

    //done
}
