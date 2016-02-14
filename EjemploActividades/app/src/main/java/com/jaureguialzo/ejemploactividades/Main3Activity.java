package com.jaureguialzo.ejemploactividades;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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

        // Recoger el dato que nos llega en el Intent
        int dato = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {   // Hay que asegurarse de que existe
            dato = extras.getInt("DATO");
        }

        // Mostramos el dato en el interfaz
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("El valor recibido es: "+dato);

    }

}
