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

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import br.com.senac.pif_mobile.util.ActivityUtils;
import br.com.senac.pif_mobile.util.Linux;
import br.com.senac.pif_mobile.util.NetworkUtils;
import br.com.senac.pif_mobile.util.TimeUtils;

public class LoginActivity extends Activity implements View.OnClickListener {
    TextView OPERATOR_SCREEN;
    Button LOGIN;
    EditText EMAIL;
    EditText PASSWORD;

    Dialog loading;
    Connection c;
    User usuario;
    boolean success = true;

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

                //tava muito grande:
                preparaLogin();


                break;
        }
    }

    public Activity self() {
        return this;
    }

    public void validalogin(String usuario, String senha,
                             String sqluser, String sqlpw) {
        if (usuario.equals(sqluser) && senha.equals(sqlpw)) {
            success = true;
        } else {
            success = false;
            falharLogin();
        }
    }

    /**
     * cria um novo processo para se conectar,
     * se fizer direto o app vai travar até a conexão ser estabelecida
     *
     * FATO INTERESSANTE: geralmente esses processos são chamados de
     * NETWORK_THREAD
     */
    public void preparaLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = "[]";
                String contactResult = "[]";

                //executa o comando curl do linux, presente em todos os androids
                result = Linux.curl(null,NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_CLIENTE));

                try {
                    JSONObject json = new JSONArray(result).getJSONObject(0); //pega o primeiro usuário da lista SQL (convertida pra JSON)

                    /**
                     *
                     * CAPTURA TODOS OS DADOS EM VARIÁVEIS:
                     *
                     */
                    int id = Integer.parseInt( // converte uma String pra int
                            json.getString(NetworkUtils.DB_COL_CLIENTE_ID) //pega o valor do id (que é uma String no JSON)
                    );
                    String nome = json.getString(NetworkUtils.DB_COL_CLIENTE_NOME);
                    String sbrnome = json.getString(NetworkUtils.DB_COL_CLIENTE_SOBRENOME);
                    String cidade = json.getString(NetworkUtils.DB_COL_CLIENTE_CIDADE);
                    String estado = json.getString(NetworkUtils.DB_COL_CLIENTE_ESTADO);
                    String bairro = json.getString(NetworkUtils.DB_COL_CLIENTE_BARRO);
                    int numero = Integer.parseInt( // converte uma String pra int
                            json.getString(NetworkUtils.DB_COL_CLIENTE_NUMERO) //pega o valor do numero da casa (que é uma String no JSON)
                    );
                    String cep = json.getString(NetworkUtils.DB_COL_CLIENTE_CEP);
                    String logradouro = json.getString(NetworkUtils.DB_COL_CLIENTE_LOGRADOURO);
                    String coplemento = json.getString(NetworkUtils.DB_COL_CLIENTE_COMPLEMENTO);
                    Date capitãoNASCIMENTO = new Date();
                    capitãoNASCIMENTO.setYear(TimeUtils.getYearBySQL(json.getString(NetworkUtils.DB_COL_CLIENTE_NASCIMENTO))); // anus
                    capitãoNASCIMENTO.setMonth(TimeUtils.getMonthBySQL(json.getString(NetworkUtils.DB_COL_CLIENTE_NASCIMENTO))); // mes
                    capitãoNASCIMENTO.setDate(TimeUtils.getDayBySQL(json.getString(NetworkUtils.DB_COL_CLIENTE_NASCIMENTO))); //dia
                    String senha = json.getString(NetworkUtils.DB_COL_CLIENTE_SENHA);
                    String CebolaPoucoFrita = json.getString(NetworkUtils.DB_COL_CLIENTE_CPF);
                    //nao seria DB_..._CLIENTE_CPF? da outra tabela? AAAAAAAAAAAkkkkkkkk
                    boolean isPJ = false;

                    if (json.getString(NetworkUtils.DB_COL_CLIENTE_JURIDICO).equals("1") /*SE cliente_pj for 1 (true)*/) {
                        isPJ = true;
                    } else {
                        isPJ = false;
                    }

                    User.PersonaType persona = new User.PersonaType(isPJ,CebolaPoucoFrita);

                    /**
                     * pega os contatos pelo CPF com uma Segunda conexão com a NET
                     */
                    contactResult = Linux.curl(null,NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_CONTATO,NetworkUtils.DB_COL_CLIENTE_CPF,CebolaPoucoFrita));// pera ai, vamos ler direitinho
                    JSONArray js = new JSONArray(contactResult);

                    ArrayList<User.Contact> contacts = new ArrayList<User.Contact>();

                    for (int XXX = 0; XXX < (js.length()); XXX++) {
                        JSONObject contatoJSON = js.getJSONObject(XXX); //aqui o erro

                        //pega os valores
                        String EMAIL = contatoJSON.getString(NetworkUtils.DB_COL_CONTATO_EMAIL);
                        String CELL1 = contatoJSON.getString(NetworkUtils.DB_COL_CONTATO_TEL1);
                        String CELL2 = contatoJSON.getString(NetworkUtils.DB_COL_CONTATO_TEL2);


                        User.Contact contact = null;

                        //checa se existe um CELL2:
                        if (CELL2.equals("NULL") || CELL2.equals("0") /*SUPORTEI OS DOIS*/)  {
                            contact = new User.Contact(EMAIL,CELL1,null);
                        } else {
                            contact = new User.Contact(EMAIL,CELL1,CELL2);
                        }

                        contacts.add(contact);
                    }

                    usuario = new User(
                            id,
                            nome,
                            sbrnome,
                            contacts,
                            new User.Location(cidade,estado, logradouro, numero,cep,bairro,coplemento),
                            capitãoNASCIMENTO,
                            senha,
                            persona
                    );

                    //salva o usuário na "RAM" (zuado falar isso)
                    Global.USUARIO = usuario;

                    /**
                     * MENTIRA:
                     * O PRIMEIRO CONTATO É O PRINCIPAL
                     */
                   // validalogin(EMAIL.getText().toString(),PASSWORD.getText().toString(),usuario.getContact(0).getEmail(), senha);
                } catch (JSONException e) {
                    System.err.println("Erro de JSON!");
                    e.printStackTrace();
                }

                final String finalResult = result;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        usuario.printUser(self());

                        if (success) {
                            ActivityUtils.startActivity(self(),OSListActivity.class);

                        } else {

                        }
                    }
                });
            }
        }).start();
    }

    private void falharLogin() {
        loading.dismiss();
        Toast.makeText(this,"O Email ou senha estão incorretos!",Toast.LENGTH_LONG).show();
    }
}
