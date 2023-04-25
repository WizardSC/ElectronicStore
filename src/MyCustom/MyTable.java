/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCustom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class MyTable extends JTable {

    public MyTable() {
        super();
        setFocusable(false);
        setIntercellSpacing(new Dimension(0, 0));
        setRowHeight(30);
        setFillsViewportHeight(true);
        getTableHeader().setOpaque(false);
        getTableHeader().setBackground(new Color(185, 225, 196));
        getTableHeader().setForeground(Color.BLACK);
        setSelectionBackground(new Color(185, 225, 196));
        setSelectionForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 13));
        getTableHeader().setReorderingAllowed(false);
        setBorder(BorderFactory.createLineBorder(new Color(185, 225, 196), 2));

        Font font = new Font("Segoe UI", Font.BOLD, 15);
        JTableHeader header = getTableHeader();
        header.setFont(font);
        header.setBackground(new Color(185, 225, 196));
        Font contentFont = new Font("Segoe UI", Font.PLAIN, 14);
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(contentFont);
                return c;
            }
        });

    }
}
