package com.example.Exam.Model;

public class Habitacion {
    private Integer id;
    private Integer numero;
    private String tipo;
    private Double precio;
    private Boolean disponible;


    public Habitacion() {
    }


    public Habitacion(Integer id, Integer numero, String tipo, Double precio, Boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}