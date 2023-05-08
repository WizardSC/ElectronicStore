/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import MyCustom.MyTable;
import MyCustom.XuLyException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phuc Toan
 */
public class NhanVienGUI extends javax.swing.JPanel {

    DefaultTableModel dtmNhanVien;
    private NhanVienBUS nvBUS = new NhanVienBUS();

    String MaCN;
    String tuKhoaTimKiem;
    String chonChiNhanh;
    boolean clickedOnce = false;
    boolean search;
    public NhanVienGUI(String temp) {
        initComponents();

        dtmNhanVien = (DefaultTableModel) tblDSNV.getModel();

        this.MaCN = temp;
        nvBUS.docMaCN(temp);

        loadData();
        loadDataMaNV();

        txtMaNV.setEnabled(false);
        txtMaCN.setText(MaCN);
        txtMaCN.setEnabled(false);
        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
        chonChiNhanh = cbxChonChiNhanh.getSelectedItem().toString();
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
               search(tuKhoaTimKiem,chonChiNhanh); 
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(tuKhoaTimKiem,chonChiNhanh); 
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(tuKhoaTimKiem,chonChiNhanh); 
            }
            
        });
        

    }
    public void search(String tk, String cn){
        if(tk.equals("Mã NV") && cn.equals("Hiện tại")){
            search = true;
            ArrayList<NhanVienDTO> dsnv = nvBUS.searchMaNV(txtTimKiem.getText(), search);
            showAllDSNV(dsnv);
        }
        if(tk.equals("Mã NV") && cn.equals("Toàn cục")){
            search = false;
            ArrayList<NhanVienDTO> dsnv = nvBUS.searchMaNV(txtTimKiem.getText(), search);
            showAllDSNV(dsnv);
        }
    }
    public void showAllDSNV(ArrayList<NhanVienDTO> dsnv) {
        dtmNhanVien.setRowCount(0);
        for (int i = 0; i < dsnv.size(); i++) {
            dtmNhanVien.addRow(new String[]{
                dsnv.get(i).getMaNV(),
                dsnv.get(i).getHo(),
                dsnv.get(i).getTen(),
                String.valueOf(dsnv.get(i).getNamSinh()),
                dsnv.get(i).getGioiTinh(),
                dsnv.get(i).getSoDT(),
                dsnv.get(i).getDiaChi(),
                dsnv.get(i).getMaCV(),
                dsnv.get(i).getMaCN(),
                dsnv.get(i).getIMG()
            });
        }
    }

    public void loadData1() {
        nvBUS.docDanhSachNV3chinhanh();
        ArrayList<NhanVienDTO> dsnv1 = nvBUS.getListNhanVien();
        showAllDSNV(dsnv1);

    }

    public void loadData() {
        nvBUS.docDanhSach();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
        showAllDSNV(dsnv);
    }

    //Hiển thị mã NV mới nhất trong 3 chi nhánh CN001, CN002, CN003
    public void loadDataMaNV() {
        nvBUS.docDanhSachNVMaTuTang();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNVMaTuTang();
        int sum = 0;

        if (dsnv.isEmpty()) {
            txtMaNV.setText(String.valueOf("NV001"));
        }
        for (int i = 0; i < dsnv.size(); i++) {
            sum = Integer.parseInt(dsnv.get(i).getMaNV().substring(3)) + 1;
            if (sum < 10) {
                txtMaNV.setText(String.valueOf("NV00" + sum));
            } else {
                txtMaNV.setText(String.valueOf("NV0" + sum));
            }
        }
        sum = 0;
    }

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
        txtMaNV = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtNamSinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtMaCV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnChonChucVu = new javax.swing.JButton();
        lblGioiTinh = new javax.swing.JLabel();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        txtMaCN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnChonChucVu1 = new javax.swing.JButton();
        btnReset = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSNV = new MyCustom.MyTable();
        btnThem = new javax.swing.JLabel();
        btnSua = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnChuyenCN = new javax.swing.JLabel();
        btnXuatExcel = new javax.swing.JLabel();
        btnNhapExcel = new javax.swing.JLabel();
        cbxChonChiNhanh = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JLabel();
        cbxTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTuoiBD = new javax.swing.JTextField();
        txtTuoiKT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(896, 744));
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN NHÂN VIÊN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã NV");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Họ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Năm sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số ĐT");

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtHo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtNamSinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mã CV");

        txtSoDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtMaCV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btnChonChucVu.setText("jButton1");
        btnChonChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonChucVuActionPerformed(evt);
            }
        });

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGioiTinh.setText("Giới tính");

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtMaCN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mã CN");

        btnChonChucVu1.setText("jButton1");
        btnChonChucVu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonChucVu1ActionPerformed(evt);
            }
        });

        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circular.png"))); // NOI18N
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioiTinh)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaCN, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btnChonChucVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnChonChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblGioiTinh)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(btnChonChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaCN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChonChucVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ", "Tên", "Năm sinh", "Giới tính", "Số ĐT", "Địa chỉ", "Mã CV", "Mã CN", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV.getTableHeader().setReorderingAllowed(false);
        tblDSNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSNV);
        if (tblDSNV.getColumnModel().getColumnCount() > 0) {
            tblDSNV.getColumnModel().getColumn(0).setResizable(false);
            tblDSNV.getColumnModel().getColumn(1).setResizable(false);
            tblDSNV.getColumnModel().getColumn(2).setResizable(false);
            tblDSNV.getColumnModel().getColumn(3).setResizable(false);
            tblDSNV.getColumnModel().getColumn(4).setResizable(false);
            tblDSNV.getColumnModel().getColumn(5).setResizable(false);
            tblDSNV.getColumnModel().getColumn(6).setResizable(false);
            tblDSNV.getColumnModel().getColumn(7).setResizable(false);
            tblDSNV.getColumnModel().getColumn(8).setResizable(false);
            tblDSNV.getColumnModel().getColumn(9).setResizable(false);
        }

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

        btnChuyenCN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnChuyenCN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChuyenCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system-update.png"))); // NOI18N
        btnChuyenCN.setText("CHUYỂN CN");
        btnChuyenCN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChuyenCNMouseClicked(evt);
            }
        });

        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/xls.png"))); // NOI18N
        btnXuatExcel.setText("XUẤT EXCEL");

        btnNhapExcel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/import.png"))); // NOI18N
        btnNhapExcel.setText("NHẬP EXCEL");

        cbxChonChiNhanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiện tại", "Toàn cục" }));
        cbxChonChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChonChiNhanhActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search1.png"))); // NOI18N
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Họ", "Tên", "Giới tính" }));
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tuổi");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Từ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Đến");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnNhapExcel)
                                            .addComponent(btnXuatExcel)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(btnChuyenCN, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTuoiBD, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTuoiKT, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxChonChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa)
                        .addGap(26, 26, 26)
                        .addComponent(btnChuyenCN)
                        .addGap(27, 27, 27)
                        .addComponent(btnNhapExcel)
                        .addGap(24, 24, 24)
                        .addComponent(btnXuatExcel)
                        .addGap(10, 10, 10))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cbxChonChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addComponent(txtTuoiKT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTuoiBD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTimKiem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVMouseClicked
        txtMaCN.setEnabled(true);
        int k = tblDSNV.getSelectedRow();
        txtMaNV.setText(tblDSNV.getModel().getValueAt(k, 0).toString());
        txtHo.setText(tblDSNV.getModel().getValueAt(k, 1).toString());
        txtTen.setText(tblDSNV.getModel().getValueAt(k, 2).toString());
        txtNamSinh.setText(tblDSNV.getModel().getValueAt(k, 3).toString());
        cbxGioiTinh.setSelectedItem(tblDSNV.getModel().getValueAt(k, 4).toString());

        txtSoDT.setText(tblDSNV.getModel().getValueAt(k, 5).toString());
        txtDiaChi.setText(tblDSNV.getModel().getValueAt(k, 6).toString());
        txtMaCV.setText(tblDSNV.getModel().getValueAt(k, 7).toString());
        txtMaCN.setText(tblDSNV.getModel().getValueAt(k, 8).toString());

    }//GEN-LAST:event_tblDSNVMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaNV = txtMaNV.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        int NamSinh = Integer.parseInt(txtNamSinh.getText());
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String SoDT = txtSoDT.getText();
        String DiaChi = txtDiaChi.getText();
        String MaCV = txtMaCV.getText();
        String IMG = null;
        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NamSinh, GioiTinh, SoDT, DiaChi, MaCV, MaCN, IMG);
        nvBUS.add(nv);
        loadData();

    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        String MaNV = txtMaNV.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        int NamSinh = Integer.parseInt(txtNamSinh.getText());
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String SoDT = txtSoDT.getText();
        String DiaChi = txtDiaChi.getText();
        String MaCV = txtMaCV.getText();
        
        String IMG = null;
        txtMaCN.setEnabled(false);
        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NamSinh, GioiTinh, SoDT, DiaChi, MaCV, MaCN, IMG);
        nvBUS.update(nv);
        loadData();
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        String MaNV = txtMaNV.getText();
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên không?");
        if (result == JOptionPane.YES_OPTION) {
            try {
                nvBUS.delete(MaNV);
                loadData();
            } catch (XuLyException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnChonChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonChucVuActionPerformed
        SChucVuGUI scv = new SChucVuGUI(MaCN);
        scv.setVisible(true);
        String MaCV = scv.getMaCV();
        System.out.println(MaCV);
        txtMaCV.setText(MaCV);
    }//GEN-LAST:event_btnChonChucVuActionPerformed

    private void cbxChonChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChonChiNhanhActionPerformed
        chonChiNhanh = cbxChonChiNhanh.getSelectedItem().toString();
        if (cbxChonChiNhanh.getSelectedItem().toString().equals("Hiện tại")) {
            loadData();
        } else if (cbxChonChiNhanh.getSelectedItem().toString().equals("Toàn cục")) {

            nvBUS.docDanhSachNV3chinhanh();
            ArrayList<NhanVienDTO> dsnv1 = nvBUS.getListNhanVien();
            showAllDSNV(dsnv1);
        }
    }//GEN-LAST:event_cbxChonChiNhanhActionPerformed

    private void btnChonChucVu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonChucVu1ActionPerformed
        
        SChiNhanhGUI scn = new SChiNhanhGUI(MaCN);
        scn.setVisible(true);
        txtMaCN.setText(scn.getMaCN());
    }//GEN-LAST:event_btnChonChucVu1ActionPerformed

    private void btnChuyenCNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChuyenCNMouseClicked
        String MaNV = txtMaNV.getText();
        
        String MaCN1 = txtMaCN.getText();
        
        NhanVienDTO nv = new NhanVienDTO(MaNV,MaCN1);
        nvBUS.updateChiNhanh(nv);
        
        loadData();
    }//GEN-LAST:event_btnChuyenCNMouseClicked

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
    }//GEN-LAST:event_cbxTimKiemActionPerformed

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txtMaNV.setText("");
        txtHo.setText("");
        txtTen.setText("");
        txtSoDT.setText("");
        txtNamSinh.setText("");
        txtDiaChi.setText("");
        txtMaCV.setText("");
        txtMaCN.setText("");
        loadData();
        
        
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int TuoiBD = Integer.parseInt(txtTuoiBD.getText());
        int TuoiKT = Integer.parseInt(txtTuoiKT.getText());
        if(cbxChonChiNhanh.getSelectedItem().toString().equals("Hiện tại")){
            search = true;
            ArrayList<NhanVienDTO> dsnv = nvBUS.searchTuoi(TuoiBD, TuoiKT, search);
            showAllDSNV(dsnv);
            
        } else {
            search = false;
            ArrayList<NhanVienDTO> dsnv = nvBUS.searchTuoi(TuoiBD, TuoiKT, search);
            showAllDSNV(dsnv);
            
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonChucVu;
    private javax.swing.JButton btnChonChucVu1;
    private javax.swing.JLabel btnChuyenCN;
    private javax.swing.JLabel btnNhapExcel;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JLabel btnXuatExcel;
    private javax.swing.JComboBox<String> cbxChonChiNhanh;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGioiTinh;
    private MyCustom.MyTable tblDSNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaCN;
    private javax.swing.JTextField txtMaCV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTuoiBD;
    private javax.swing.JTextField txtTuoiKT;
    // End of variables declaration//GEN-END:variables
}
