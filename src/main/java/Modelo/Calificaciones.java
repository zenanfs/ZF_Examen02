/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Calificaciones {
    
    private int numUnico;
    private String materia;
    private double nota1;
    private double nota2;
    private double nota3;
    private String estado;

    public Calificaciones(int numUnico, String materia, double nota1, double nota2, double nota3) {
        this.numUnico = numUnico;
        this.materia = materia;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.estado = calcularEstado();
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

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String calcularEstado() {
        double sumaNotas = nota1 + nota2;
        if (sumaNotas >= 28) {
            return "Exonerado";
        } else if (sumaNotas >= 18) {
            if (nota3 > 24) {
                return "Aprobado";
            } else {
                return "Reprobado";
            }
        } else {
            return "Reprobado";
        }
    }
    
}
