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
public class AsignaturasController implements ActionListener {
    
    GestionarAsignaturas modelo;
    FormAsignaturas vista;
    FormPrincipal menuPrincipal;
    

    public AsignaturasController(GestionarAsignaturas modelo, FormAsignaturas vista, FormPrincipal menuPrincipal) {
        this.modelo = modelo;
        this.vista = vista;
        this.menuPrincipal = menuPrincipal;
        this.vista.getBtnAgregar().addActionListener(this);
        this.vista.getBtnMenu().addActionListener(this);
        llenarComboSemestre();
    }
    
    private void llenarComboSemestre() {
        vista.getCmbSemestre().removeAllItems();
        for(int i=1; i<=9; i++) {
            vista.getCmbSemestre().addItem(String.valueOf(i));
        }
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
        if (e.getSource() == vista.getBtnAgregar()) {
            String nombre = vista.getTxtNameAsignatura().getText();
            String creditosStr = vista.getTxtCreditos().getText();
            String semestreStr = (String) vista.getCmbSemestre().getSelectedItem();

            if (nombre.isEmpty() || creditosStr.isEmpty() || semestreStr == null) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.");
                return;
            }
            int creditos, semestre;
            try {
                creditos = Integer.parseInt(creditosStr);
                semestre = Integer.parseInt(semestreStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Créditos y semestre deben ser números.");
                return;
            }
            Asignaturas asignatura = new Asignaturas(nombre, creditos, semestre);
            modelo.agregarAsignatura(asignatura);
            vista.limpiarCampos();
            JOptionPane.showMessageDialog(vista, "¡Asignatura agregada!");
        } else if (e.getSource() == vista.getBtnMenu()) {
            vista.setVisible(false);
            menuPrincipal.setVisible(true);
        }
    }
    
}
