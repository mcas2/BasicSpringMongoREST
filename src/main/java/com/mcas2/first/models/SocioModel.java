package com.mcas2.first.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("socios")
public class SocioModel {
    @Id private String id;
    private Integer numeroSocio;
    private String nombre;
    private String apellidos;
    private ContactoModel contacto;
    private DireccionModel direccion;
    private String dni;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaAlta;

    public String getId() {
        return id;
    }

    public Integer getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(Integer numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public ContactoModel getContacto() {
        return contacto;
    }

    public void setContacto(ContactoModel contacto) {
        this.contacto = contacto;
    }

    public DireccionModel getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionModel direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
