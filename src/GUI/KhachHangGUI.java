/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import MyCustom.XuLyException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phuc Toan
 */
public class KhachHangGUI extends javax.swing.JPanel {

    String MaCN;
    private KhachHangBUS khBUS = new KhachHangBUS();
    DefaultTableModel dtmKhachHang;

    public KhachHangGUI(String temp) {

        initComponents();
        this.MaCN = temp;
        khBUS.docMaCN(temp);
        dtmKhachHang = (DefaultTableModel) tblDSKH.getModel();
        loadData();
        loadDataMaKH();
        txtMaKH.setEnabled(false);
    }

    public void showAllDSKH(ArrayList<KhachHangDTO> dskh) {
        dtmKhachHang.setRowCount(0);
        for (int i = 0; i < dskh.size(); i++) {
            dtmKhachHang.addRow(new String[]{
                dskh.get(i).getMaKH(),
                dskh.get(i).getHo(),
                dskh.get(i).getTen(),
                dskh.get(i).getNamSinh(),
                dskh.get(i).getGioiTinh(),
                dskh.get(i).getSoDT(),
                dskh.get(i).getDiaChi(),
                dskh.get(i).getIMG()
            });
        }
    }

    public void loadDataMaKH() {
        khBUS.docDanhSachMaKH();
        ArrayList<KhachHangDTO> dskh = khBUS.getListMaKH();
        KhachHangDTO lastMaKH = dskh.get(dskh.size() - 1);
        String MaKH = lastMaKH.getMaKH();

        int sum = Integer.parseInt(MaKH.substring(3)) + 1;
        if (sum >= 10) {
            txtMaKH.setText(String.valueOf("KH0" + sum));
        } else {
            txtMaKH.setText(String.valueOf("KH00" + sum));

        }
    }

    public void loadData() {
        khBUS.docDanhSach();
        ArrayList<KhachHangDTO> dskh = khBUS.getListKhachHang();
        showAllDSKH(dskh);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtNamSinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSKH = new MyCustom.MyTable();
        btnThem = new javax.swing.JLabel();
        btnSua = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(896, 744));
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN KHÁCH HÀNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã KH");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Họ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Năm sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số ĐT");

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtHo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtNamSinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Địa chỉ");

        txtSoDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGioiTinh.setText("Giới tính");

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(68, 68, 68)
                        .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(64, 64, 64)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioiTinh)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2))
                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblGioiTinh)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tblDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Họ", "Tên", "Năm sinh", "Giới tính", "Số ĐT", "Địa chỉ", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKH.getTableHeader().setReorderingAllowed(false);
        tblDSKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSKHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSKH);

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
        btnSua.setText("SỬA");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKHMouseClicked
        int k = tblDSKH.getSelectedRow();
        txtMaKH.setText(tblDSKH.getModel().getValueAt(k, 0).toString());
        txtHo.setText(tblDSKH.getModel().getValueAt(k, 1).toString());
        txtTen.setText(tblDSKH.getModel().getValueAt(k, 2).toString());
        txtNamSinh.setText(tblDSKH.getModel().getValueAt(k, 3).toString());
        cbxGioiTinh.setSelectedItem(tblDSKH.getModel().getValueAt(k, 4).toString());

        txtSoDT.setText(tblDSKH.getModel().getValueAt(k, 5).toString());
        txtDiaChi.setText(tblDSKH.getModel().getValueAt(k, 6).toString());

    }//GEN-LAST:event_tblDSKHMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaNV = txtMaKH.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String NamSinh = txtNamSinh.getText();
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String SoDT = txtSoDT.getText();
        String DiaChi = txtDiaChi.getText();
//        String MaCV = txtMaCV.getText();
        String IMG = null;
        KhachHangDTO kh = new KhachHangDTO(MaNV, Ho, Ten, NamSinh, GioiTinh, SoDT, DiaChi, IMG);
        khBUS.add(kh);
        loadData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        String MaKH = txtMaKH.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String NamSinh = txtNamSinh.getText();
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String SoDT = txtSoDT.getText();
        String DiaChi = txtDiaChi.getText();
        String IMG = null;
        KhachHangDTO kh = new KhachHangDTO(MaKH, Ho, Ten, NamSinh, GioiTinh, SoDT, DiaChi, IMG);
        khBUS.update(kh);
        loadData();
//
//        String IMG = null;
//        txtMaCN.setEnabled(false);
//        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NamSinh, GioiTinh, SoDT, DiaChi, MaCV, MaCN, IMG);
//        nvBUS.update(nv);
//        loadData();
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        String MaKH = txtMaKH.getText();
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khách hàng không?");
        if (result == JOptionPane.YES_OPTION){
            try{
                khBUS.delete(MaKH);
                loadData();
            } catch (XuLyException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
//        String MaNV = txtMaNV.getText();
//        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên không?");
//        if (result == JOptionPane.YES_OPTION) {
//            try {
//                nvBUS.delete(MaNV);
//                loadData();
//            } catch (XuLyException e) {
//                JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
//            } catch (Exception e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }//GEN-LAST:event_btnXoaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGioiTinh;
    private MyCustom.MyTable tblDSKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
