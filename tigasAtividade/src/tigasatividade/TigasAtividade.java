/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tigasatividade;

import view.software;

/**
 *
 * @author aluno.lab
 */
public class TigasAtividade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        com.formdev.flatlaf.FlatLightLaf.setup();    // Claro
        //	com.formdev.flatlaf.FlatDarkLaf.setup();     // Escuro

        new software().setVisible(true);
    }
    
}
