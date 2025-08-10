/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author P3E004-K
 */
public class CalificacionesController implements ActionListener {
    
    FormCalificaciones vista;
    FormPrincipal menuPrincipal;

    public CalificacionesController(FormCalificaciones vista, FormPrincipal menuPrincipal) {
        this.modelo = modelo;
        this.vista = vista;
        this.menuPrincipal = menuPrincipal;

        this.vista.getBtnMenu().addActionListener(this);
        actualizarTabla();
    }

    public void iniciarCalif() {
        vista.setTitle("Gestión de Calificaciones");
        vista.setSize(600, 400);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnMenu()) {
            vista.setVisible(false);
            menuPrincipal.setVisible(true);
        }
    }
    
}
