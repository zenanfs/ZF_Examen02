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
public class Asignaturas {
    
    private String nameAsignatura;
    private int creditos;
    private JComboBox<String> semestre;

    public Asignaturas(String nameAsignatura, int creditos, JComboBox<String> semestre) {
        this.nameAsignatura = nameAsignatura;
        this.creditos = creditos;
        this.semestre = semestre;
    }

    public String getNameAsignatura() {
        return nameAsignatura;
    }

    public void setNameAsignatura(String nameAsignatura) {
        this.nameAsignatura = nameAsignatura;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public JComboBox<String> getSemestre() {
        return semestre;
    }

    public void setSemestre(JComboBox<String> semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Asignaturas{" + "nameAsignatura=" + nameAsignatura + ", creditos=" + creditos + ", semestre=" + semestre + '}';
    }

    
    
}
