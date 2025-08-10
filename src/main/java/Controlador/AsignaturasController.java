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

/**
 *
 * @author P3E004-K
 */
public class AsignaturasController implements ActionListener {
    
    GestionarAsignaturas modelo;
    FormAsignaturas vista;

    public AsignaturasController(GestionarAsignaturas modelo, FormAsignaturas vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getBtnAgregar().addActionListener(this);
        this.vista.getBtnMenu().addActionListener(this);
    }
    
    public void iniciarAsig(){
        vista.setTitle("Gestion de Asignaturas");
        vista.setSize(600, 400);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        modelo.cargarAsignatura();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
