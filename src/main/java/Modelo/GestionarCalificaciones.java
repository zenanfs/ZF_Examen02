/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */

public class GestionarCalificaciones {
    
    private List<Calificaciones> listaCalificaciones;
    
    private final String ARCHIVO_CAL = "datos_calificaciones.csv";

    public GestionarCalificaciones() {
        listaCalificaciones = new ArrayList<>();
        cargarCalificaciones();
    }

    // Agregar una calificación nueva
    public void agregarCalificacion(Calificaciones calificacion) {
        listaCalificaciones.add(calificacion);
        guardarCalificaciones();
    }

    // Obtener todas las calificaciones
    public List<Calificaciones> obtenerCalificaciones() {
        return listaCalificaciones;
    }

    // Cargar calificaciones desde archivo
    public void cargarCalificaciones() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CAL))) {
            Object obj = ois.readObject();
            listaCalificaciones = (ArrayList<Calificaciones>) obj;
        } catch (IOException | ClassNotFoundException e) {
            // Si no existe el archivo o hay error, lista vacía
            listaCalificaciones = new ArrayList<>();
        }
    }

    // Guardar calificaciones en archivo
    public void guardarCalificaciones() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CAL))) {
            oos.writeObject(listaCalificaciones);
        } catch (IOException e) {
            // Manejo simple de error
        }
    }

    // Eliminar todas las calificaciones (opcional)
    public void limpiarCalificaciones() {
        listaCalificaciones.clear();
        guardarCalificaciones();
    }
}