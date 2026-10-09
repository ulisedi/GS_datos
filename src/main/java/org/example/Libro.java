package org.example;
import java.io.Serializable;

public class Libro implements Serializable {

    private int codigo;
    private String titulo;
    private String autor;
    private boolean prestado;

    public Libro(int codigo, String titulo, String autor, boolean prestado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = prestado;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor +
                "\nPrestado: " + (prestado ? "Sí" : "No");
    }
}