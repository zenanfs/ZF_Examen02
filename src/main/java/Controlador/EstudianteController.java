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

    public EstudianteController(GestionarEstudiantes modelo, FormEstudiantes vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getBtnAgregar().addActionListener(this);
        this.vista.getBtnMenu().addActionListener(this);
    }
    
    public void iniciarEst(){
        vista.setTitle("Gestion de Estudiantes");
        vista.setSize(600, 400);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        modelo.cargarEstudiante();
    }
    
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            agregarEstudiante();
        } else if (e.getSource() == vista.getBtnMenu()) {
            volverMenu();
        }
    }
    
}
