package br.com.senac.pif_mobile.util;

import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Linux {
    public static String curl(@Nullable String[] params, String url) {
        try {
            if (params == null) {
                params = new String[] {
                        ""
                };
            }
            String args = TextUtils.join(" ", params);
            String fullcommand = "";
            fullcommand = "curl " + args + " " + url + "";
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(fullcommand);
            System.out.println("Run: " + fullcommand);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String response = null;
            String output = "";
            for (int x = 0; (response = stdInput.readLine()) != null; x++) {
                output += response + "\n";
            }
            p.waitFor();
            return output;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public static String wget(@Nullable String[] params, String url) {
        try {
            String args = TextUtils.join(" ", params);
            String fullcommand = "";
            fullcommand = "wget " + args + " \"" + url + "\"";
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(fullcommand);
            System.out.println("Run: " + fullcommand);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String response = null;
            String output = "";
            for (int x = 0; (response = stdInput.readLine()) != null; x++) {
                output += response + "\n";
            }
            p.waitFor();
            return output;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return ex.getMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
}
