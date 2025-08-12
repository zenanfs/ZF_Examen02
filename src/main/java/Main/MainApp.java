/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Controlador.*;
import Vista.*;

/**
 *
 * @author P3E004-K
 */
public class MainApp {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            FormPrincipal vista = new FormPrincipal();
            PrincipalController ctrl = new PrincipalController(vista);
            ctrl.iniciarPrincipal();
        });
    }
}
