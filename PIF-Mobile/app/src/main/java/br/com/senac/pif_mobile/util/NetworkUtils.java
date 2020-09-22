package br.com.senac.pif_mobile.util;

import android.os.AsyncTask;

import org.intellij.lang.annotations.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    //um preparo para o Apocalipse das tabelas _teste:
    private static final String suffix = "_teste";

    // DADOS DO BANCO DE DADOS (DADO)
    public static final String DB_TABLE_CLIENTE = "cliente" + suffix;
    public static final String DB_TABLE_CONTATO = "contato" + suffix;
    public static final String DB_TABLE_OS = "os" + suffix;

    public static final String DB_COL_CONTATO_CPF = "cliente_colab_cpf_ou_cnpj";
    public static final String DB_COL_CONTATO_EMAIL = "cliente_colab_email";
    public static final String DB_COL_CONTATO_TEL1 = "cliente_colab_telefone_1";
    public static final String DB_COL_CONTATO_TEL2 = "cliente_colab_telefone_2";

    public static final String DB_COL_CLIENTE_ID = "cliente_id";
    public static final String DB_COL_CLIENTE_NOME = "cliente_nome_ou_razao";
    public static final String DB_COL_CLIENTE_SOBRENOME = "cliente_sobrenome_ou_nome_fantasia";
    public static final String DB_COL_CLIENTE_CIDADE = "cliente_cidade";
    public static final String DB_COL_CLIENTE_ESTADO = "cliente_uf";
    public static final String DB_COL_CLIENTE_BARRO = "cliente_bairro";
    public static final String DB_COL_CLIENTE_NUMERO = "cliente_lograd_num";
    public static final String DB_COL_CLIENTE_CEP = "cliente_cep";
    public static final String DB_COL_CLIENTE_CPF = "cliente_cpf_ou_cnpj";
    public static final String DB_COL_CLIENTE_RG = "cliente_rg_ou_ie";
    public static final String DB_COL_CLIENTE_LOGRADOURO = "cliente_lograd";
    public static final String DB_COL_CLIENTE_COMPLEMENTO = "cliente_lograd_comp";
    public static final String DB_COL_CLIENTE_SENHA = "cliente_pass";
    public static final String DB_COL_CLIENTE_NASCIMENTO = "cliente_nascimento";
    public static final String DB_COL_CLIENTE_JURIDICO = "cliente_pj";

    private static String domain = "https://pi.arttidev.com/";

    public static String urlizeGet(String table) {
        return domain + "get.php?table=" + table;
    }

    public static String urlizeGet(String table,String where, String equals) {
        return domain + "get.php?table=" + table + "&where=" + where + "&equals_where=" + equals;
        //que burricek..kkk.kkk.
    }

    public static String getJSON(String url) {
        return downloadTextFile(url);
    }

    private static String downloadTextFile(String url) {
        Downloader d = new Downloader(url);
        d.download();

        return d.getFileAsText();
    }

    static class Downloader extends AsyncTask<Void,Void,String> {
        private String url;
        private String file;

        public Downloader(String url) {
            this.url = url;
        }


        @Override protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override protected String doInBackground(Void... voids) {
            @Language("JSON") String file =
                    "{" +
                        "\"error\": \"Unknown Error\"" +
                    "}";
            try {
                URL https = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) https.openConnection();
                StringBuilder sb = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String s;
                while ((s = br.readLine()) != null) {
                    sb.append(s + "\n");
                }
                file = sb.toString().trim();
            } catch (IOException e) {
                e.printStackTrace();
                file =
                    "{" +
                        "\"error\": \"" + e + "\"" +
                    "}";
            }
            this.file = file;
            return file;
        }

        @Override protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        public void download() {
            execute();
        }

        public String getUrl() {
            return url;
        }

        public String getFileAsText() {
            return file;
        }
    }

    public static void runOnNetworkThread(Runnable r) {
        new Thread(r).start();
    }
}
