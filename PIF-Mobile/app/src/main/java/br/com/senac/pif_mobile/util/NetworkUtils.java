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
    public static void getJSON(String url) {

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
}