/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JComboBox;

/**
 *
 * @author P3E004-K
 */
public class Estudiante {
    
    private String nombre;
    private String apellido;
    private int numUnico;
    private String materia;

    public Estudiante(String nombre, String apellido, int numUnico, String materia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numUnico = numUnico;
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumUnico() {
        return numUnico;
    }

    public void setNumUnico(int numUnico) {
        this.numUnico = numUnico;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + ", numUnico=" + numUnico + ", materia=" + materia + '}';
    }
    
}
