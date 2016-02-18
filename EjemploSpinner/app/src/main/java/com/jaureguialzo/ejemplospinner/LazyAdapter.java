package com.jaureguialzo.ejemplospinner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by widemos on 18/2/16.
 *
 * Adaptador "lazy" para Spinner o ListView.
 * Genera cada fila bajo demanda.
 *
 */
public class LazyAdapter extends BaseAdapter {

    private LayoutInflater inflater = null; // Objeto para expandir el XML del layout a objetos
    private List<Libro> libros = null;  // Estructura con los datos

    public LazyAdapter(Activity activity, List<Libro> libros) {
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.libros = libros;
    }

    // Implementación de los métodos del interfaz requeridos

    @Override
    public int getCount() {
        return libros.size();   // Número de filas a crear
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Crear una fila
        View vi = inflater.inflate(R.layout.fila, null);

        // Obtener las referencias a los controles
        TextView titulo = (TextView) vi.findViewById(R.id.titulo);
        TextView autor = (TextView) vi.findViewById(R.id.autor);

        // Rellenar los datos
        Libro libro = libros.get(position);

        titulo.setText(libro.getTitulo());
        autor.setText(libro.getAutor());

        // Devolver la fila generada y rellenada
        return vi;
    }

}