/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FormPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author P3E004-K
 */
public class PrincipalController implements ActionListener {
    
    FormPrincipal vista;
    
    public void iniciarEst(){
        vista.setTitle("Sistema Academico");
        vista.setSize(600, 400);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
