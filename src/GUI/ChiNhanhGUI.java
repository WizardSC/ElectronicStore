/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiNhanhBUS;
import DTO.ChiNhanhDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class ChiNhanhGUI extends javax.swing.JPanel {

    private ChiNhanhBUS cnBUS = new ChiNhanhBUS();
    private String MaCN = "";
    public ChiNhanhGUI(String temp) {
        initComponents();
        this.MaCN = temp;
        loadData();
        
    }
    public void loadData() {
        cnBUS.docDanhSach(MaCN);
//        System.out.println("HamGUI" +MaCN);
        ArrayList<ChiNhanhDTO> dscn = cnBUS.getListChiNhanh();
        System.out.println(dscn.size());
        for (ChiNhanhDTO cn : dscn) {
            System.out.println(cn.getMaCN());
            System.out.println(cn.getTenCN());
            System.out.println(cn.getDiaChi());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
