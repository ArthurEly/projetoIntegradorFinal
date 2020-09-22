package br.com.senac.pif_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import br.com.senac.pif_mobile.util.Linux;
import br.com.senac.pif_mobile.util.NetworkUtils;
import br.com.senac.pif_mobile.util.TimeUtils;

import static br.com.senac.pif_mobile.util.NetworkUtils.runOnNetworkThread;

public class OSListActivity extends AppCompatActivity {
    TextView WELCOME_TEXT;
    User usuario;
    LinearLayout OSView;
    String cpf;

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
        //Cria um loading (no processo da UI):
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View v = getLayoutInflater().inflate(R.layout.dialog_loading,null);

                OSView.setGravity(Gravity.CENTER);
                OSView.removeAllViews();
                OSView.addView(v);
            }
        });

        //Enquanto isso (no processo da INTERNET)...
        runOnNetworkThread(new Runnable() {
            @Override
            public void run() {
                String result = Linux/*Ah não*/.curl(null, NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_OS,NetworkUtils.DB_COL_CLIENTE_CPF,cpf));

                // @TODO: teste, apagar depois:
                System.out.println(result);

                try {
                    JSONArray json = new JSONArray(result);

                    OSView.removeAllViews();
                    for (int XXX = 0; XXX < json.length(); XXX++) {
                        JSONObject js = json.getJSONObject(XXX);

                        int num = Integer.parseInt(js.getString(NetworkUtils.DB_COL_OS_NUMERO));
                        String placa = js.getString(NetworkUtils.DB_COL_VEICULO_PLACA);
                        OS.SITUACAO sit = OS.getSituation(js.getString(NetworkUtils.DB_COL_VEICULO_SITUACAO));

                        // @TODO: PAREI AQUI:
                        Date entrada = new Date();
                        entrada.setDate(TimeUtils.getDayBySQL(js.getString(NetworkUtils.DB_COL_OS_ENTRADA)));
                        entrada.setMonth(TimeUtils.getMonthBySQL(js.getString(NetworkUtils.DB_COL_OS_ENTRADA)));
                        entrada.setYear(TimeUtils.getYearBySQL(js.getString(NetworkUtils.DB_COL_OS_ENTRADA)));
                        Date previsão = new Date();
                        previsão.setDate(TimeUtils.getDayBySQL(js.getString(NetworkUtils.DB_COL_OS_PREVISAO)));
                        previsão.setMonth(TimeUtils.getMonthBySQL(js.getString(NetworkUtils.DB_COL_OS_PREVISAO)));
                        previsão.setYear(TimeUtils.getYearBySQL(js.getString(NetworkUtils.DB_COL_OS_PREVISAO)));
                        Date saida = new Date();
                        saida.setDate(TimeUtils.getDayBySQL(js.getString(NetworkUtils.DB_COL_OS_SAIDA)));
                        saida.setMonth(TimeUtils.getMonthBySQL(js.getString(NetworkUtils.DB_COL_OS_SAIDA)));
                        saida.setYear(TimeUtils.getYearBySQL(js.getString(NetworkUtils.DB_COL_OS_SAIDA)));
                        String colaborador = js.getString(NetworkUtils.DB_COL_OS_COLABORADOR);

                        OS os = new OS(num,placa,sit,entrada,previsão,saida,colaborador);
                        insertOS(os);
                    }
                } catch (JSONException e) {
                    Log.e("NetworkThread", "ERRO DO JSON DENOVO", e);
                }
            }
        });
    }

    public void insertOS(OS os /*parecido com o User, que pena!*/) {
        View v = getLayoutInflater().inflate(R.layout.widget_os,null);
        ((TextView) v.findViewById(R.id.OS_ID)).setText(os.getNum());

        OSView.addView(v);
    }
}