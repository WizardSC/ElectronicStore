/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phuc Toan
 */
public class TaiKhoanGUI extends javax.swing.JPanel {

    String MaCN;
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    DefaultComboBoxModel dcbmMaNV;
    DefaultTableModel dtmTaiKhoan;
    boolean TinhTrang;
    public TaiKhoanGUI(String temp) {
        initComponents();
        this.MaCN = temp;
        nvBUS.docMaCN(MaCN);
        tkBUS.docMaCN(MaCN);
        dcbmMaNV = (DefaultComboBoxModel) cbxMaNV.getModel();
        dtmTaiKhoan = (DefaultTableModel) tblDSTK.getModel();
        loadDataMaNV();
        loadDataTK();
    }

    public void showAllMaNV(ArrayList<NhanVienDTO> dsnv) {
        cbxMaNV.removeAllItems();
        for (int i = 0; i < dsnv.size(); i++) {
            cbxMaNV.addItem(dsnv.get(i).getMaNV());
        }
    }

    public void showAllDSTK(ArrayList<TaiKhoanDTO> dstk) {
        dtmTaiKhoan.setRowCount(0);
        for (int i = 0; i < dstk.size(); i++) {
            dtmTaiKhoan.addRow(new String[]{
                dstk.get(i).getMaNV(),
                dstk.get(i).getTenDangNhap(),
                dstk.get(i).getMatKhau(),
                String.valueOf(dstk.get(i).isTinhTrang()),
                dstk.get(i).getMaCV()
            });
        }
    }

    public void loadDataTK() {
        tkBUS.docDanhSach();
        ArrayList<TaiKhoanDTO> dstk = tkBUS.getListTaiKhoan();
        showAllDSTK(dstk);
    }

    public void loadDataMaNV() {
        nvBUS.docMaNV();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListMaNV();
        showAllMaNV(dsnv);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        btnThem = new javax.swing.JLabel();
        btnSua = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        cbxMaNV = new javax.swing.JComboBox<>();
        cbxChonChucVu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMaCV = new javax.swing.JTextField();
        cbxTinhTrang = new javax.swing.JComboBox<>();
        btnKhoa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSTK = new MyCustom.MyTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(896, 744));
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN CHỨC VỤ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã NV");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập");

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system-update.png"))); // NOI18N
        btnSua.setText("SỬA MK");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tình trạng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cbxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxChonChucVu.setText("...");
        cbxChonChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChonChucVuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã CV");

        txtMaCV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cbxTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false" }));

        btnKhoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKhoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system-update.png"))); // NOI18N
        btnKhoa.setText("KHÓA TK");
        btnKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxTinhTrang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxChonChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhau)
                            .addComponent(txtTenDangNhap)
                            .addComponent(cbxMaNV, 0, 200, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSua)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(cbxTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnKhoa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbxChonChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa))))
                .addGap(60, 75, Short.MAX_VALUE))
        );

        tblDSTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Mật khẩu", "Tình trạng", "Mã CV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSTK.getTableHeader().setReorderingAllowed(false);
        tblDSTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSTKMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSTK);
        if (tblDSTK.getColumnModel().getColumnCount() > 0) {
            tblDSTK.getColumnModel().getColumn(0).setResizable(false);
            tblDSTK.getColumnModel().getColumn(1).setResizable(false);
            tblDSTK.getColumnModel().getColumn(2).setResizable(false);
            tblDSTK.getColumnModel().getColumn(3).setResizable(false);
            tblDSTK.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked

        String MaNV = cbxMaNV.getSelectedItem().toString().toUpperCase();
        System.out.println(MaNV);
        String MatKhau = txtMatKhau.getText();
        String MaCV = txtMaCV.getText();
        boolean TinhTrang = Boolean.parseBoolean(cbxTinhTrang.getSelectedItem().toString());
        String TenDangNhap = txtTenDangNhap.getText();
        TaiKhoanDTO tk = new TaiKhoanDTO(TenDangNhap, MatKhau, MaNV, TinhTrang, MaCV);
        tkBUS.add(tk);
        loadDataTK();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        String TenDangNhap = txtTenDangNhap.getText();
        String MatKhau = txtMatKhau.getText();
        TaiKhoanDTO tk = new TaiKhoanDTO(TenDangNhap, MatKhau);
        tkBUS.update(tk);
        loadDataTK();
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
//        String MaCV = txtMaCV.getText();
//        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa chức vụ không?");
//        if (result == JOptionPane.YES_OPTION){
//            try {
//                cvBUS.delete(MaCV);
//                loadDataDSCV();
//            } catch (XuLyException e){
//                JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
//            } catch (Exception e){
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa chức vụ", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            }
//        }

    }//GEN-LAST:event_btnXoaMouseClicked

    private void tblDSTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSTKMouseClicked
        int k = tblDSTK.getSelectedRow();
        String MaNV = tblDSTK.getModel().getValueAt(k, 0).toString();
        cbxMaNV.addItem(MaNV);
        cbxMaNV.setSelectedItem(MaNV);
        cbxMaNV.setEnabled(false);
        txtTenDangNhap.setEnabled(false);

        txtTenDangNhap.setText(tblDSTK.getModel().getValueAt(k, 1).toString());
        txtMatKhau.setText(tblDSTK.getModel().getValueAt(k, 2).toString());
        if (txtMatKhau.getText().equals("111111")) {
            btnSua.setText("RESET MK");
        } else {
            btnSua.setText("SỬA MK");
        }
        String TT = tblDSTK.getModel().getValueAt(k, 3).toString();
        cbxTinhTrang.setSelectedItem(TT);
        cbxTinhTrang.setEnabled(false);
        if(cbxTinhTrang.getSelectedItem().toString().equals("true")){
            btnKhoa.setText("KHÓA TK");
            TinhTrang = false;
        }else{
            btnKhoa.setText("MỞ KHÓA TK");
            TinhTrang = true;
        }
        txtMaCV.setText(tblDSTK.getModel().getValueAt(k, 4).toString());

    }//GEN-LAST:event_tblDSTKMouseClicked

    private void cbxChonChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChonChucVuActionPerformed
        SChucVuGUI scv = new SChucVuGUI(MaCN);
        scv.setVisible(true);
        txtMaCV.setText(scv.getMaCV());
    }//GEN-LAST:event_cbxChonChucVuActionPerformed

    private void btnKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhoaMouseClicked
        String TenDangNhap = txtTenDangNhap.getText();
//        boolean TinhTrang = Boolean.parseBoolean(cbxTinhTrang.getSelectedItem().toString());
        TaiKhoanDTO tk = new TaiKhoanDTO(TenDangNhap, TinhTrang);
        tkBUS.lock(tk);
        loadDataTK();
    }//GEN-LAST:event_btnKhoaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnKhoa;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JButton cbxChonChucVu;
    private javax.swing.JComboBox<String> cbxMaNV;
    private javax.swing.JComboBox<String> cbxTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private MyCustom.MyTable tblDSTK;
    private javax.swing.JTextField txtMaCV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
