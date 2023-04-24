/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package GUI;

import javax.swing.UIManager;

/**
 *
 * @author Phuc Toan
 */
public class Main {

    public static void main(String[] args) {
//        new ChiNhanhGUI("CN002").setVisible(true);
        new GiaoDienGUI("CN002").setVisible(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}
