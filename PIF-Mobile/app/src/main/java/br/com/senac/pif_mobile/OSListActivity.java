package br.com.senac.pif_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
    LinearLayout OSView,LoadView;
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
        LoadView = findViewById(R.id.LOADING);
        OSView = findViewById(R.id.OS);

        WELCOME_TEXT.setText("Bem Vindo, " + usuario.getFullName());

        carregaOses();
    }

    public void carregaOses() {
        final View loading = getLayoutInflater().inflate(R.layout.dialog_loading,null);

        //Cria um loading (no processo da UI):
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LoadView.removeAllViews();
                LoadView.addView(loading);
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
                    try {
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
                            if (js.getString(NetworkUtils.DB_COL_OS_SAIDA).equals("")) {

                            } else {
                                saida.setDate(TimeUtils.getDayBySQL(js.getString(NetworkUtils.DB_COL_OS_SAIDA)));
                                saida.setMonth(TimeUtils.getMonthBySQL(js.getString(NetworkUtils.DB_COL_OS_SAIDA)));
                                saida.setYear(TimeUtils.getYearBySQL(js.getString(NetworkUtils.DB_COL_OS_SAIDA)));
                            }
                            String colaborador = js.getString(NetworkUtils.DB_COL_OS_COLABORADOR);

                            OS os = new OS(num, placa, sit, entrada, previsão, saida, colaborador);
                            Car car = getCar(placa);
                            Parecer parecer = new Parecer(os.getNum());
                            Oramento orca = new Oramento(os.getNum());

                            insertOS(os,car,parecer,orca); //oscar

                        }
                    } finally {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LoadView.setVisibility(View.GONE);
                                OSView.setVisibility(View.VISIBLE);

                                if (!(OSView.getChildCount() < 1)) {
                                    OSView.removeViewAt(OSView.getChildCount() - 1);
                                }
                            }
                        });
                    }
                } catch (JSONException e) {
                    Log.e("NetworkThread", "ERRO DO JSON DENOVO", e);
                }
            }
        });
    }

    /**
     * Insere as oses
     * @param os
     * @param car
     * @param parecer_escolar
     */
    public void insertOS(final OS os, final Car car, final Parecer parecer_escolar, final Oramento orca) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View v = getLayoutInflater().inflate(R.layout.widget_os,null);
                ProgressBar protesto = v.findViewById(R.id.OS_PROGRESS);
                int progresso = OS.getSituationPercentage(os.getSituacao());

                Log.i("PROTESTADOR", "progresso: " + progresso);

                //seta os valores:
                ((TextView) v.findViewById(R.id.OS_NUM)).setText("Numero da OS: " + os.getNum());
                ((TextView) v.findViewById(R.id.OS_NUM_STATUS)).setText("Status: " + os.getSituacao().name().replace("_", " "));
                ((TextView) v.findViewById(R.id.OS_SIGN)).setText(car.getSign());
                ((TextView) v.findViewById(R.id.OS_CAR)).setText(car.getFullName());


                if (progresso < 0) {
                    ((TextView) v.findViewById(R.id.OS_NUM_PERCENT)).setText("INDETERMINADO");
                    protesto.setIndeterminate(true);
                } else {
                    ((TextView) v.findViewById(R.id.OS_NUM_PERCENT)).setText(progresso + "%");
                    protesto.setProgress(progresso);
                }
                OSView.addView(v);

                View margem = new View(self());
                ViewGroup.LayoutParams tamanho = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);

                margem.setLayoutParams(tamanho);
                margem.setBackgroundColor(0xFFFFFFFF);
                OSView.addView(margem);

                //cada os pode ter mais de um parecer, então chamaremos a função para inserir os pareceres:
                insertParecer(parecer_escolar,(LinearLayout) v.findViewById(R.id.PARECER_ESCOLAR));
                //insere as orcas
                insertOrca(orca,(LinearLayout) v.findViewById(R.id.ORCA));
            }
        });
    }

    /**
     * Insere os Pareceres
     * @param parecer
     * @param l
     */
    public void insertParecer(Parecer parecer,LinearLayout l) {
        System.out.println("tamanho do baguio: "+(parecer.lista.toArray().length) + "cm");
        for (int x = 0; x < (parecer.lista.toArray().length);x++) {
            Parecer.Informações info = parecer.lista.get(x);

            Date data = info.getDate();
            String dadosData = data.getDate() + "/" + data.getMonth() + "/" + data.getYear() + " às " + data.getHours() + ":" + data.getMinutes() + ":" + data.getSeconds();

            System.out.println("parecer de numero: " + x + "\n" +
                    dadosData);

            View vdd = getLayoutInflater().inflate(R.layout.widget_parecer, null);

            //seta os valores:
            ((TextView) vdd.findViewById(R.id.GUGU_DATA)).setText(dadosData); //data do parecer
            ((TextView) vdd.findViewById(R.id.LADRAO)).setText(info.getMechanique()); // nome do mecanico
            ((TextView) vdd.findViewById(R.id.JUSTIFICATIVA)).setText(info.getDescription()); //descrição

            l.addView(vdd);

            View margem = new View(this);
            ViewGroup.LayoutParams tamanho = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);

            margem.setLayoutParams(tamanho);
            margem.setBackgroundColor(0xFFFFFFFF);
            l.addView(margem);
        }
        //será q é pq na os 37 nao tem nenhum parecer?? faz sentido

        if (!(l.getChildCount() < 1)) {
            l.removeViewAt(l.getChildCount() - 1);
        }
    }

    /**
     * Insere o orçamento
     */
    public void insertOrca(Oramento orca, LinearLayout l) {
        int colour = 0x333333;
        double total = 0.00;

        for (int x = 0; x < orca.lista.toArray().length;x++) {
            Oramento.Informações i = orca.getInfo(x);
            View v = getLayoutInflater().inflate(R.layout.widget_orca,null);
            v.setBackgroundColor(colour);
            String data = i.getDate().getDate() + "/" + i.getDate().getMonth() + "/" + i.getDate().getYear();
            String hora = i.getDate().getHours() + ":" + i.getDate().getMinutes() + ":" + i.getDate().getSeconds();

            if (colour == 0x333333) {
                colour = 0x555555;
            } else {
                colour = 0x333333;
            }

            ((TextView) v.findViewById(R.id.PRODUCT)).setText(i.getName());
            ((TextView) v.findViewById(R.id.PRICE)).setText(i.getPrice() + "");
            ((TextView) v.findViewById(R.id.DATA)).setText(data);
            ((TextView) v.findViewById(R.id.HORA)).setText(hora);
            ((TextView) v.findViewById(R.id.MSG)).setText(i.getDescription());


            l.addView(v);


            View margem = new View(this);
            ViewGroup.LayoutParams tamanho = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);

            margem.setLayoutParams(tamanho);
            margem.setBackgroundColor(0xFFFFFFFF);
            l.addView(margem);
        }
    }

    public Car getCar(String sign) throws JSONException {
        String json = Linux/*DENOVO NÃO!*/.curl(null,NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_VEICULO,NetworkUtils.DB_COL_VEICULO_PLACA,sign));
        JSONObject js = new JSONArray(json).getJSONObject(0);

        return new Car(
                sign,
                js.getString(NetworkUtils.DB_COL_VEICULO_TIPO),
                js.getString(NetworkUtils.DB_COL_VEICULO_FAB),
                js.getString(NetworkUtils.DB_COL_VEICULO_MODELO),
                js.getString(NetworkUtils.DB_COL_VEICULO_COR),
                Integer.parseInt(js.getString(NetworkUtils.DB_COL_VEICULO_ANO)),
                js.getString(NetworkUtils.DB_COL_VEICULO_ACESSORIOS),
                js.getString(NetworkUtils.DB_COL_VEICULO_OBS),
                js.getString(NetworkUtils.DB_COL_VEICULO_DEFEITO),
                OS.getSituation(js.getString(NetworkUtils.DB_COL_VEICULO_SITUACAO)));
    }

    public Activity self() {
        return this;
    }
}