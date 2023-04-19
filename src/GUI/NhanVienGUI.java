/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiNhanhBUS;
import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;

/**
 *
 * @author Phuc Toan
 */
public class NhanVienGUI extends javax.swing.JPanel {
   
    private NhanVienBUS nvBUS = new NhanVienBUS();
    String MaCN;
    public NhanVienGUI(String temp) {
        initComponents();
        this.MaCN = temp;
        nvBUS.docMaCN(temp);
        init(); 
        loadData();
    }
    public void init(){
        tblDSNV.setFocusable(false);
        tblDSNV.setIntercellSpacing(new Dimension(0, 0));
        tblDSNV.setRowHeight(25);
        tblDSNV.setFillsViewportHeight(true);
        tblDSNV.getTableHeader().setOpaque(false);
        tblDSNV.getTableHeader().setBackground(new Color(185,225,196));
        tblDSNV.getTableHeader().setForeground(Color.BLACK);
        tblDSNV.setSelectionBackground(new Color(185,225,196));
        
        tblDSNV.setSelectionForeground(Color.BLACK);
        tblDSNV.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSNV.getTableHeader().setReorderingAllowed(false);
        tblDSNV.setBorder(BorderFactory.createLineBorder(new Color(185,225,196), 2));
    }
    
    public void loadData(){
        nvBUS.docDanhSach();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
        for(NhanVienDTO nv : dsnv){
            System.out.println(nv.getMaNV());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(896, 744));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ NV", "Title 3", "Title 4"
            }
        ));
        tblDSNV.getTableHeader().setResizingAllowed(false);
        tblDSNV.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDSNV);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDSNV;
    // End of variables declaration//GEN-END:variables
}
