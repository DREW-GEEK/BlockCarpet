package com.example.ixone.conversor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView etiqueta;
    private double cantidad;
    private String origen;
    private String destino;
    private Double resultado;
    private Double bytes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etiqueta = (TextView) findViewById(R.id.textView4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {   // Hay que asegurarse de que existe
            cantidad = extras.getDouble("CANTIDAD");
            origen=extras.getString("ORIGEN");
            destino=extras.getString("DESTINO");

            switch (origen.toUpperCase()) {
                case "BYTES":
                    bytes=cantidad;
                    break;
                case "KB":
                    bytes=cantidad*1024;
                    break;
                case "MB":
                    bytes = cantidad * 1024*1024;
                    break;
            }

            switch (destino.toUpperCase()) {
                case "BYTES":
                    resultado=bytes;
                    break;
                case "KB":
                    resultado=bytes/1024;
                    break;
                case "MB":
                    resultado = (bytes/ 1024)/1024;
                    break;
            }

            etiqueta.setText(cantidad + " " + origen + " son " + resultado+ " " +destino);

        }else{
            etiqueta.setText("ALGO HA IDO MAL...");

        }


    }

}
