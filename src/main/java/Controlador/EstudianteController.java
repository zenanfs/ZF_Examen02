/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author P3E004-K
 */
public class EstudianteController implements ActionListener{
    
    GestionarEstudiantes modelo;
    FormEstudiantes vista;
    FormPrincipal menuPrincipal;

    public EstudianteController(GestionarEstudiantes modelo, FormEstudiantes vista, FormPrincipal menuPrincipal) {
        this.modelo = modelo;
        this.vista = vista;
        this.menuPrincipal = menuPrincipal;
        this.vista.getBtnAgregar().addActionListener(this);
        this.vista.getBtnMenu().addActionListener(this);
        llenarComboMaterias();
        actualizarTabla();
    }
    
    private void llenarComboMaterias() {
        vista.getCmbAsignaturas().removeAllItems();
        vista.getCmbAsignaturas().addItem("EDO");
        vista.getCmbAsignaturas().addItem("Introduccion SI");
        vista.getCmbAsignaturas().addItem("Fundamentos CC");
        vista.getCmbAsignaturas().addItem("Programacion II");
        vista.getCmbAsignaturas().addItem("Arquitectura de Computadores");
    }
    
    private void actualizarTabla() {
        modelo.cargarEstudiante();
        String[] columnas = {"Nombre", "Apellido", "Num Unico", "Materia"};
        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        for (Estudiante e : modelo.obtenerEstudiante()) {
            String[] fila = { e.getNombre(), e.getApellido(), String.valueOf(e.getNumUnico()), e.getMateria() };
            tableModel.addRow(fila);
        }
        vista.getTablaEstudiantes().setModel(tableModel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            String nombre = vista.getTxtNombre().getText();
            String apellido = vista.getTxtApellido().getText();
            String numUnicoStr = vista.getTxtNumUnico().getText();
            String materia = (String) vista.getCmbAsignaturas().getSelectedItem();

            if (nombre.isEmpty() || apellido.isEmpty() || numUnicoStr.isEmpty() || materia == null) {
                javax.swing.JOptionPane.showMessageDialog(vista, "Llena por favor todos los campos");
                return;
            }
            int numUnico;
            try {
                numUnico = Integer.parseInt(numUnicoStr);
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(vista, "El numero unico debe ser un entero");
                return;
            }
            Estudiante estudiante = new Estudiante(nombre, apellido, numUnico, materia);
            modelo.agregarEstudiante(estudiante);
            actualizarTabla();
            vista.limpiarCampos();
            javax.swing.JOptionPane.showMessageDialog(vista, "Estudiante registrado");
        } else if (e.getSource() == vista.getBtnMenu()) {
            vista.setVisible(false);
            menuPrincipal.setVisible(true);
        }
    }
    
    public void iniciarEst(){
        vista.setTitle("Gestion de Estudiantes");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        actualizarTabla();
    }
    
    /*
    private void agregarEstudiante(){
        String nombre = vista.getTxtNombre().getText().trim();
        String apellido = vista.getTxtApellido().getText().trim();
        String numUnicoTxt = vista.getTxtNumUnico().getText().trim();
        JComboBox<String> materia = (JComboBox<String>) vista.getCmbAsignaturas().getSelectedItem();
        
        
        try{
           int numUnico = Integer.parseInt(numUnicoTxt);
           
           Estudiante estudiante = new Estudiante(nombre, apellido, numUnico, materia); //falta combobox
           modelo.agregarEstudiante(estudiante);
           JOptionPane.showMessageDialog(vista, "Se agrego al estudiante", "Exito", JOptionPane.INFORMATION_MESSAGE);
           limpiarCampos();
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(vista, "Pon un numero valido en el numero unico" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarEstudiante(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nombre, Apellido, NU., Asignatura"});
        
        for (Estudiante estudiante : modelo.obtenerEstudiante()){
            model.addRow(new Object[]{estudiante.getNombre(), estudiante.getApellido(), estudiante.getNumUnico(), estudiante.getMateria()});
        }
        
        vista.getTablaEstudiantes().setModel(model);
    }
    
    private void volverMenu(){
        
    }
    
    public void limpiarCampos(){
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtNumUnico().setText("");
    }

*/
    
}
