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
public class GestionarEstudiantes {
    
    ArrayList<Estudiante> estudiantes = new ArrayList<>();
    
    private static final String ARCHIVO_EST = "datos_estudiantes.csv";
    
    public void cargarEstudiante(){
        estudiantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_EST))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if (datos.length == 4){
                    String nombre = datos[0];
                    String apellido = datos[1];
                    int numUnico = Integer.parseInt(datos[2]);
                    String materia = datos[3];
                    
                    estudiantes.add(new Estudiante(nombre, apellido, numUnico, materia));
                }
            }
        } catch(IOException e){
            System.out.println("Error al cargar al estudiante" + e.getMessage());
        }
    }
    
    public void guardarEstudiante(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_EST, true))){
            for (Estudiante estudiante : estudiantes){
                String linea = estudiante.getNombre() + "," +
                        estudiante.getApellido() + "," +
                        estudiante.getNumUnico() + "," +
                        estudiante.getMateria();
                bw.write(linea);
                bw.newLine();
            }
        } catch(IOException e){
            System.err.println("Error al guardar al estudiante" + e.getMessage());
        } 
    }
    
    
    
    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
        guardarEstudiante();
    }
    
    public List<Estudiante> obtenerEstudiante(){
        return estudiantes;
    }
    
    public Estudiante buscarEstudiantePorNumUnico(int numUnico) {
    for (Estudiante estudiante : estudiantes) {
        if (estudiante.getNumUnico() == numUnico) {
            return estudiante;
        }
    }
    return null;
}
    
}
