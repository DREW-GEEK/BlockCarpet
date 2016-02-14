package com.jaureguialzo.ejemplocontroles;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        // TextView - Etiquetas

        // Obtener referencias a los controles del Layout
        TextView tv1 = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView3);

        // Modificar el texto de las etiquetas
        tv1.setText("Hola");
        tv2.setText("¿Qué tal?");
        tv3.setText("¯\\_(ツ)_/¯");    // https://textfac.es/

        // Button - Botones

        Button bt1 = (Button) findViewById(R.id.button);
        bt1.setText("¡Púlsame!");

        // Añadir un manejador de evento para el OnClick()
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "¡Gracias!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setText("¡A mi también!");
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "(ᵔᴥᵔ)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // RadioButton - Selección
        // Si se agrupan en un RadioGroup en el layout, se vuelven excluyentes entre sí

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb1.setText("Rojo");
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb2.setText("Verde");
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb3.setText("Azul");

        // Cambiar el valor de la propiedad checked (seleccionado)
        rb1.setChecked(false);
        rb2.setChecked(true);
        rb3.setChecked(false);

        // CheckBox - Selección múltiple

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb1.setText("Blanco");
        cb1.setChecked(true);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb2.setText("Negro");
        cb2.setChecked(false);

        // EditText - Cuadros de texto

        EditText et1 = (EditText) findViewById(R.id.editText);
        EditText et2 = (EditText) findViewById(R.id.editText2);

        // Switch - Interruptor de dos estados

        Switch sw1 = (Switch) findViewById(R.id.switch1);

        // Evento que se ejecuta al cambiar el estado del interruptor
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked ) {
                    Snackbar.make(buttonView, "\\ (•◡•) /", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    Snackbar.make(buttonView, "ಠ╭╮ಠ", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
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
