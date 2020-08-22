package br.com.senac.pif_mobile;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.Connection;

import pif.desktop.dao.Conexao;

public class LoginActivity extends Activity implements View.OnClickListener {
    TextView OPERATOR_SCREEN;
    Button LOGIN;
    Dialog loading;
    Connection c;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);

        OPERATOR_SCREEN = findViewById(R.id.OPERATOR_SCREEN);
        LOGIN = findViewById(R.id.LOGIN);

        OPERATOR_SCREEN.setOnClickListener(this);
        LOGIN.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.OPERATOR_SCREEN:
                break;
            case R.id.LOGIN:
                loading = new Dialog(this);
                loading.setContentView(R.layout.dialog_loading);
                loading.show();

                //cria um novo processo para se conectar,
                //se fizer direto o app vai travar
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Conexao x = new Conexao();
                        c = x.conectarAoBanco();
                    }
                });

                break;
        }
    }
}
