package com.jaureguialzo.ejemplospinner;

/**
 * Created by widemos on 18/2/16.
 */
public class Libro {

    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
