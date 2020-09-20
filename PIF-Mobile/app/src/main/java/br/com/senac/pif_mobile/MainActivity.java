package br.com.senac.pif_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import br.com.senac.pif_mobile.util.ActivityUtils;
import br.com.senac.pif_mobile.util.TimeUtils;

public class MainActivity extends AppCompatActivity {

    /**
     * Tela de splash do aplicativo, é só um efeito visual e pode ser pulado (dura 5 Segundos)
     *
     * @param savedInstanceState
     */
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Espera uns 5 segundos num processo especial apenas para esperar
         * (pois se esperar dentro do processo principal (o da UI) vai travar por 5 segundos)
         *
         * @see TimeUtils
         */
        TimeUtils.wait(next(),5000);
    }

    /**
     * processo a ser executado depois dos 5 segundos se passarem:
     * entra na tela de login
     *
     * @see ActivityUtils
     * @return
     */
    public Runnable next() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ActivityUtils.startActivity(self(),LoginActivity.class);
            }
        };

        return r;
    }

    /**
     * gambiarra para pegar esta activity (this) dentro da Runnable acima
     *
     * @return
     */
    public Activity self() {
        return this;
    }
}