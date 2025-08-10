/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;
import java.util.*;

/**
 *
 * @author P3E004-K
 */
public class GestionarAsignaturas {
    
    ArrayList<Asignaturas> asignaturas = new ArrayList<>();
    
    private static final String ARCHIVO_ASIG = "datos_asignaturas.csv";
    
    public void cargarAsignatura(){
        asignaturas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASIG))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if (datos.length == 4){
                    String nameAsignatura = datos[0];
                    int creditos = Integer.parseInt(datos[1]);
                    int semestre = Integer.parseInt(datos[2]);
                    
                    asignaturas.add(new Asignaturas(nameAsignatura, creditos, semestre));
                }
            }
        } catch(IOException e){
            System.out.println("Error al cargar la asignatura" + e.getMessage());
        }
    }
    
    public void guardarAsignatura(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ASIG, true))){
            for (Asignaturas asignatura : asignaturas){
                String linea = asignatura.getNameAsignatura() + "," +
                        asignatura.getCreditos() + "," +
                        asignatura.getSemestre();
                bw.write(linea);
                bw.newLine();
            }
        } catch(IOException e){
            System.err.println("Error al guardar la asignatura" + e.getMessage());
        } 
    }
    
    public void agregarAsignatura(Asignaturas asignatura){
        asignaturas.add(asignatura);
        guardarAsignatura();
    }
    
    public List<Asignaturas> obtenerAsignatura(){
        return asignaturas;
    }
    
}
