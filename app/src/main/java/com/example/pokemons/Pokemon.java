package com.example.pokemons;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private String nombre;
    private int peso;
    private int altura;
    private String image;
    private String DetailsURL;
    private String tipo;



    @Override
    public String toString() {
        return "com.example.pokemons.Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", image='" + image + '\'' +
                ", DetailsURL='" + DetailsURL + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailsURL() {
        return DetailsURL;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDetailsURL(String detailsURL) {
        DetailsURL = detailsURL;
    }
}
