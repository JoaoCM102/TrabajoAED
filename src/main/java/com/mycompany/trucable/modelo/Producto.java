/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trucable.modelo;

import java.util.ArrayList;

/**
 *
 * @author 2damb
 */
public class Producto {
    int id;
    String nombre;
    String descripcion;
    ArrayList<String> demanda;
    boolean disponible;

    public Producto(int id, String nombre, ArrayList<String> demanda, String descripcion, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.demanda = demanda;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getDemanda() {
        return demanda;
    }

    public void setDemanda(ArrayList<String> demanda) {
        this.demanda = demanda;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
