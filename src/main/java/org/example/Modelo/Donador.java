package org.example.Modelo;

public class Donador {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String categoria;
    private int anioGraduacion;
    private double montoDonado;

    public Donador() {
        this.montoDonado = 0;
        this.anioGraduacion = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAnioGraduacion() {
        return anioGraduacion;
    }

    public void setAnioGraduacion(int anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }

    public double getMontoDonado() {
        return montoDonado;
    }

    public void setMontoDonado(double montoDonado) {
        this.montoDonado = montoDonado;
    }
}
