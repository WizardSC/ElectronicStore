/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Phuc Toan
 */
public class Main {

    public static void main(String[] args) {
//        new ChiNhanhGUI("CN002").setVisible(true);
//        new GiaoDienGUI("CN001").setVisible(true);
        new DangNhapGUI().setVisible(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            UIManager.put("Button.foreground", Color.red);
        } catch (Exception e) {

        }
        
        
    }
}
