package br.com.senac.pif_mobile;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.Connection;

import br.com.senac.pif_mobile.util.ActivityUtils;
import br.com.senac.pif_mobile.util.SQLUtils;
import pif.desktop.dao.Conexao;

public class LoginActivity extends Activity implements View.OnClickListener {
    TextView OPERATOR_SCREEN;
    Button LOGIN;
    EditText EMAIL;
    EditText PASSWORD;

    Dialog loading;
    Connection c;
    User usuario;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);
        ActivityUtils.requestPermission(this, Manifest.permission.INTERNET);

        OPERATOR_SCREEN = findViewById(R.id.OPERATOR_SCREEN);
        LOGIN = findViewById(R.id.LOGIN);
        EMAIL = findViewById(R.id.EMAIL);
        PASSWORD = findViewById(R.id.PASSWORD);

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
                        usuario = SQLUtils.getUser(c, EMAIL.getText().toString(), PASSWORD.getText().toString());

                        Toast.makeText(EMAIL.getContext(),usuario.getID(),Toast.LENGTH_LONG);
                    }
                });

                break;
        }
    }
}
