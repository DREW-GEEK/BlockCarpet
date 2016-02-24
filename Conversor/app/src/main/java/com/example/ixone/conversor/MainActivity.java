package com.example.ixone.conversor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private RadioButton rbBytes;
    private RadioButton rbKB;
    private RadioButton rbMB;
    private EditText ctCantidad;
    private Button btnCalcular;
    private Spinner sp;
    private double cantidad;
    private String origen;
    private String destino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        // creamos las variables correspondientes a cada control //

        sp = (Spinner) findViewById(R.id.spinner);
        rbBytes = (RadioButton) findViewById(R.id.radioButton);
        rbKB = (RadioButton) findViewById(R.id.radioButton2);
        rbMB =(RadioButton) findViewById(R.id.radioButton3);
        ctCantidad = (EditText) findViewById(R.id.editText);
        btnCalcular= (Button) findViewById(R.id.button);

        // ARRAY ADAPTER //

        final String[] origenes={"BYTES", "KB", "MB"};

        // Creamos el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, origenes);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Conectamos el adaptador al control
        sp.setAdapter(adaptador);

        // ------------------------------------------------------------------------------- //



        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Leemos los datos a pasar //

                // ORIGEN //
                origen= sp.getSelectedItem().toString();

                // CANTIDAD //
                cantidad=new Double(ctCantidad.getText().toString());

                // DESTINO //
                if (rbBytes.isChecked()){
                    destino="BYTES";
                } else if (rbKB.isChecked()) {
                    destino="KB";
                } else if (rbMB.isChecked()) {
                    destino="MB";
                }

                // Crear el Intent
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                // Cargar datos en el Intent
               i.putExtra("CANTIDAD", cantidad);
                i.putExtra("ORIGEN", origen);
                i.putExtra("DESTINO", destino);

                // Arrancar la actividad
                 startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
