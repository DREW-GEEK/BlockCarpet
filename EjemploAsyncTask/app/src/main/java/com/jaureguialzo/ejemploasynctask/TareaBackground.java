package com.jaureguialzo.ejemploasynctask;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by widemos on 18/2/16.
 */
public class TareaBackground extends AsyncTask<Void, Void, String> {

    // Tarea en segundo plano que recoge los datos usando HTTP

    // Recordar añadir el permiso de Internet en el Manifest del proyecto

    @Override
    protected String doInBackground(Void... params) {

        String utc = null;

        try {
            URL url = new URL("http://www.timeapi.org/utc/now");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setInstanceFollowRedirects(true);

            InputStream is = conn.getInputStream();

            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                utc = br.readLine();

                is.close();
                conn.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return utc;
    }

}
