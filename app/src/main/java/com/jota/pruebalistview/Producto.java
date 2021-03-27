package com.jota.pruebalistview;

public class Producto {
    private String Nombre;
    private int Valor;

    public Producto(String nombre, int valor) {
        this.Nombre = nombre;
        this.Valor = valor;
    }

    public Producto() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }
}