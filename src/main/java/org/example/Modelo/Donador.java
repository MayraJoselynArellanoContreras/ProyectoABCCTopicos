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

    public boolean validarNombre() {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validarDireccion() {
        if (direccion == null || direccion.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validarTelefono() {
        if (telefono == null || telefono.length() < 10) {
            return false;
        }
        for (int i = 0; i < telefono.length(); i++) {
            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean validarCorreo() {
        if (correo == null || !correo.contains("@")) {
            return false;
        }
        return true;
    }

    public boolean validarAnio() {
        if (anioGraduacion == 0) {
            return true;
        }
        if (anioGraduacion >= 1950 && anioGraduacion <= 2030) {
            return true;
        }
        return false;
    }

    public boolean esValido() {
        return validarNombre() && validarDireccion() &&
                validarTelefono() && validarCorreo() && validarAnio();
    }

    public String obtenerErrores() {
        String errores = "";
        if (!validarNombre()) errores += "• Nombre no puede estar vacío\n";
        if (!validarDireccion()) errores += "• Dirección no puede estar vacía\n";
        if (!validarTelefono()) errores += "• Teléfono debe tener al menos 10 dígitos\n";
        if (!validarCorreo()) errores += "• Correo debe contener @\n";
        if (!validarAnio()) errores += "• Año debe estar entre 1950 y 2030\n";
        return errores;
    }
}
