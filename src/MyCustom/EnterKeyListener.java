/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCustom;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Phuc Toan
 */
public class EnterKeyListener extends KeyAdapter {

    private JTextField nextField;
    private JButton buttonToClick;

    public EnterKeyListener(JTextField nextField) {
        this.nextField = nextField;
    }

    public EnterKeyListener(JButton buttonToClick) {
        this.buttonToClick = buttonToClick;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (nextField != null && e.getKeyCode() == KeyEvent.VK_ENTER) {
            nextField.requestFocus();
        } else if (buttonToClick != null && e.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonToClick.doClick();
        }
    }
}
