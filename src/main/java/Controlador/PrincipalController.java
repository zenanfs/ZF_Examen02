/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author P3E004-K
 */
public class PrincipalController implements ActionListener {
    
    FormPrincipal vista;

    public PrincipalController(FormPrincipal vista) {
        this.vista = vista;
        this.vista.getBtnEstudiantes().addActionListener(this);
        this.vista.getBtnCalificaciones().addActionListener(this);
        this.vista.getBtnAsignaturas().addActionListener(this);
    }
    
    public void iniciarPrincipal(){
        vista.setTitle("Sistema Academico");
        vista.setSize(600, 400);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnEstudiantes()) {
            GestionarEstudiantes modelo = new GestionarEstudiantes();
            FormEstudiantes form = new FormEstudiantes();
            EstudianteController ctrl = new EstudianteController(modelo, form, vista);
            vista.setVisible(false);
            ctrl.iniciarEst();
        } else if (e.getSource() == vista.getBtnAsignaturas()) {
            GestionarAsignaturas modelo = new GestionarAsignaturas();
            FormAsignaturas form = new FormAsignaturas();
            AsignaturasController ctrl = new AsignaturasController(modelo, form, vista);
            vista.setVisible(false);
            ctrl.iniciarAsig();
        } else if (e.getSource() == vista.getBtnCalificaciones()) {
            FormCalificaciones form = new FormCalificaciones();
            CalificacionesController ctrl = new CalificacionesController(form, vista);
            vista.setVisible(false);
            ctrl.iniciarCalif();
        }
    }
    
}
