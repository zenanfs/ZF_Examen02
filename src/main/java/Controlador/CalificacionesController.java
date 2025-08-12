/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author P3E004-K
 */
public class CalificacionesController implements ActionListener {
    
    GestionarCalificaciones modelo;
    GestionarEstudiantes modeloEstudiantes;
    FormCalificaciones vista;
    FormPrincipal menuPrincipal;

    public CalificacionesController(GestionarCalificaciones modelo, GestionarEstudiantes modeloEst, FormCalificaciones vista, FormPrincipal menuPrincipal) {
        this.modelo = modelo;
        this.modeloEstudiantes = modeloEst;
        this.vista = vista;
        this.menuPrincipal = menuPrincipal;

        this.vista.getBtnAgregarCalificacion().addActionListener(this);
        this.vista.getBtnMenu().addActionListener(this);

        llenarComboAsignaturas();
        actualizarTabla();
    }

    private void llenarComboAsignaturas() {
        vista.getCmbAsignaturas().removeAllItems();
        vista.getCmbAsignaturas().addItem("EDO");
        vista.getCmbAsignaturas().addItem("Introduccion SI");
        vista.getCmbAsignaturas().addItem("Fundamentos CC");
        vista.getCmbAsignaturas().addItem("Programacion II");
        vista.getCmbAsignaturas().addItem("Arquitectura de Computadores");
    }

    private void actualizarTabla() {
        String[] columnas = {"NU.", "Materia", "Nota1", "Nota2", "Recuperacion", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        for (Calificaciones calificacion : modelo.obtenerCalificaciones()) {
            Object[] fila = {
                calificacion.getNumUnico(), calificacion.getMateria(),
                calificacion.getNota1(), calificacion.getNota2(),
                calificacion.getNota3(),calificacion.getEstado()
            };
            model.addRow(fila);
        }
        vista.getTablaCalificaciones().setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregarCalificacion()) {
            try {
                int numUnico = Integer.parseInt(vista.getTxtNumUnico().getText());
                String materia = (String) vista.getCmbAsignaturas().getSelectedItem();
                double nota1 = Double.parseDouble(vista.getTxtNotaUno().getText());
                double nota2 = Double.parseDouble(vista.getTxtNotaDos().getText());
                double nota3 = 0;
                if (!vista.getTxtNotaTres().getText().trim().isEmpty()) {
                    nota3 = Double.parseDouble(vista.getTxtNotaTres().getText());
                }

                Estudiante est = modeloEstudiantes.buscarEstudiantePorNumUnico(numUnico);
                if (est == null) {
                    JOptionPane.showMessageDialog(vista, "Estudiante no encontrado");
                    return;
                }

                double sumaNotas = nota1 + nota2;
                String mensaje = "";
                if (sumaNotas >= 28) {
                    nota3 = 0;
                    mensaje = "Estudiante exonerado";
                } else if (sumaNotas >= 18 && sumaNotas < 28) {
                    if (nota3 == 0) {
                        JOptionPane.showMessageDialog(vista, "Ingrese nota de recuperacion");
                        return;
                    }
                    mensaje = (nota3 > 14) ? "Aprobado" : "Reprobado";
                } else {
                    nota3 = 0;
                    mensaje = "Reprobado, no puede acceder a reucperacion";
                }

                Calificaciones calificacion = new Calificaciones(numUnico, materia, nota1, nota2, nota3);
                modelo.agregarCalificacion(calificacion);
                actualizarTabla();
                vista.limpiarCampos();
                JOptionPane.showMessageDialog(vista, mensaje + " Estado final: " + calificacion.getEstado());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese todos los datos correctamente");
            }
        } else if (e.getSource() == vista.getBtnMenu()) {
            vista.setVisible(false);
            menuPrincipal.setVisible(true);
        }
    }
    
    public void iniciarCalif(){
        vista.setTitle("Gestion de Calificaciones");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        actualizarTabla();
    }
    
}
