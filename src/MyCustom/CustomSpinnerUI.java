/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCustom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;

/**
 *
 * @author Phuc Toan
 */
public class CustomSpinnerUI extends BasicSpinnerUI {
    protected Component createPreviousButton() {
        JButton button = new JButton();
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(UIManager.getColor("Spinner.arrowButtonBackground"));
        button.setForeground(Color.RED);
        button.setBorder(BorderFactory.createLineBorder(UIManager.getColor("Spinner.arrowButtonBorder")));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(20, 20));
        button.setName("Spinner.previousButton");
//        button.setIcon(new ImageIcon(getClass().getResource("/resources/images/arrow_left.png")));
        return button;
    }

    protected Component createNextButton() {
        JButton button = new JButton();
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(UIManager.getColor("Spinner.arrowButtonBackground"));
        button.setForeground(Color.RED);
        button.setBorder(BorderFactory.createLineBorder(UIManager.getColor("Spinner.arrowButtonBorder")));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(20, 20));
        button.setName("Spinner.nextButton");
//        button.setIcon(new ImageIcon(getClass().getResource("/resources/images/arrow_right.png")));
        return button;
    }
}
