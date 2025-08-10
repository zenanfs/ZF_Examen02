/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zf_examen02;

import Controlador.*;
import Vista.*;

/**
 *
 * @author P3E004-K
 */
public class ZF_Examen02 {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormPrincipal menu = new FormPrincipal();
                PrincipalController controller = new PrincipalController(menu);
                controller.iniciarPrincipal();
            }
        });
    }
}
