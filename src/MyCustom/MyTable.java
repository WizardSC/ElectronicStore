/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCustom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class MyTable extends JTable {

    public MyTable() {
        super();
        setFocusable(false);
        setIntercellSpacing(new Dimension(0, 0));
        setRowHeight(25);
        setFillsViewportHeight(true);
        getTableHeader().setOpaque(false);
        getTableHeader().setBackground(new Color(185, 225, 196));
        getTableHeader().setForeground(Color.BLACK);
        setSelectionBackground(new Color(185, 225, 196));
        setSelectionForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 13));
        getTableHeader().setReorderingAllowed(false);
        setBorder(BorderFactory.createLineBorder(new Color(185, 225, 196), 2));
        
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        JTableHeader header = getTableHeader();
        header.setFont(font);
        header.setBackground(new Color(185, 225, 196));
    }
}
