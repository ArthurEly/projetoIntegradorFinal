package br.com.senac.pif_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.senac.pif_mobile.util.Linux;
import br.com.senac.pif_mobile.util.NetworkUtils;

import static br.com.senac.pif_mobile.util.NetworkUtils.runOnNetworkThread;

public class OSListActivity extends AppCompatActivity {
    TextView WELCOME_TEXT;
    User usuario;
    LinearLayout OSView;
    String cpf

    public OSListActivity() {
        usuario = Global.USUARIO;

        if (usuario.getPersona().isOperator()) { //nome nada haver
            cpf = usuario.getPersona().getCnpj();
        } else {
            cpf = usuario.getPersona().getCpf();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oslist);

        WELCOME_TEXT = findViewById(R.id.WELCOME);
        OSView = findViewById(R.id.OS);

        WELCOME_TEXT.setText("Bem Vindo, " + usuario.getFullName());

        carregaOses();
    }

    public void carregaOses() {
        //Cria um loading:
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View v = getLayoutInflater().inflate(R.layout.dialog_loading,null);

                OSView.setGravity(Gravity.CENTER);
                OSView.removeAllViews();
                OSView.addView(v);
            }
        });

        //Enquanto isso...
        runOnNetworkThread(new Runnable() {
            @Override
            public void run() {
                String result = Linux/*Ah não*/.curl(null, NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_OS,NetworkUtils.DB_COL_CLIENTE_CPF,cpf));

                // @TODO: teste, apagar depois:
                System.out.println(result);


            }
        });
    }

    public void insertOS(OS os /*parecido com o User, que pena!*/) {
        // @TODO: PAREI AQUI
    }
}