package com.jaureguialzo.ejemplospinner;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // http://developer.android.com/intl/es/guide/topics/ui/controls/spinner.html

        // XML
        // ----------------------------------------------------------------------------------------

        // Creamos el adaptador partiendo de un archivo de recursos
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this
                ,R.array.planets_array
                , android.R.layout.simple_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Conectamos el adaptador al control
        Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
        sp1.setAdapter(adapter1);

        // Evento del Spinner
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, "Has seleccionado el "+position, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // ArrayAdapter
        // ----------------------------------------------------------------------------------------

        // Array de String que contiene los datos
        String[] dias = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

        // Creamos el adaptador partiendo del array
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dias);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Conectamos el adaptador al control
        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        sp2.setAdapter(adapter2);

        // Lazy Adapter
        // ----------------------------------------------------------------------------------------

        // Tenemos una colección de objetos a mostrar
        List<Libro> libros = new ArrayList<>();

        // Tres objetos de prueba
        libros.add(new Libro("El Señor de los Anillos","J.R.R. Tolkien"));
        libros.add(new Libro("The Martian","Andy Weir"));
        libros.add(new Libro("Getting Things Done","David Allen"));

        // Creamos un adaptador con carga diferida o "perezosa"
        LazyAdapter adaptador = new LazyAdapter(this, libros);

        // Conectamos el adaptador al control
        Spinner sp3 = (Spinner) findViewById(R.id.spinner3);
        sp3.setAdapter(adaptador);
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
