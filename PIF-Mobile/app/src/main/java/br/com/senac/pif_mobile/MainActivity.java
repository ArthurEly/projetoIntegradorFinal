package br.com.senac.pif_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import br.com.senac.pif_mobile.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public Runnable next() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ActivityUtils.startActivity(self(),LoginActivity.class);
            }
        };

        return r;
    }

    public Activity self() {
        return this;
    }
}