package br.com.senac.pif_mobile;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;

import br.com.senac.pif_mobile.util.ActivityUtils;
import br.com.senac.pif_mobile.util.Linux;
import br.com.senac.pif_mobile.util.NetworkUtils;

public class LoginActivity extends Activity implements View.OnClickListener {
    TextView OPERATOR_SCREEN;
    Button LOGIN;
    EditText EMAIL;
    EditText PASSWORD;

    Dialog loading;
    Connection c;
    User usuario;

    /**
     * Tela de login do usuário
     *
     * @param savedInstanceState
     */
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);

        /**
         * caso o app ainda não tenha permissão de internet, o app vai pedir essa permissão
         *
         * isto acontece apenas em androids mais novos.
         *
         * @see ActivityUtils para saber mais sobre o novo sistema de permissões
         */
        ActivityUtils.requestPermission(this, Manifest.permission.INTERNET);

        //seta as variaveis
        OPERATOR_SCREEN = findViewById(R.id.OPERATOR_SCREEN);
        LOGIN = findViewById(R.id.LOGIN);
        EMAIL = findViewById(R.id.EMAIL);
        PASSWORD = findViewById(R.id.PASSWORD);

        //seta operações de click
        OPERATOR_SCREEN.setOnClickListener(this);
        LOGIN.setOnClickListener(this);
    }

    /**
     * função global de onClick
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //hiperlink "Sou um Operador". mas acho que irei remover
            case R.id.OPERATOR_SCREEN:
                break;
            // botão de login
            case R.id.LOGIN:
                //cria uma tela de carregando
                loading = new Dialog(this);
                loading.setContentView(R.layout.dialog_loading);
                loading.show();

                /**
                 * cria um novo processo para se conectar,
                 * se fizer direto o app vai travar até a conexão ser estabelecida
                 *
                 * FATO INTERESSANTE: geralmente esses processos são chamados de
                 * NETWORK_THREAD
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String result = "NULL";

                        //executa o comando curl do linux, presente em todos os androids
                        result = Linux.curl(null,NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_CLIENTE));

                        final String finalResult = result;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(EMAIL.getContext(),finalResult,Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();

                break;
        }
    }
}
