/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CTPhieuNhapBUS;
import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DTO.CTPhieuNhapDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import DTO.SanPham_ChiNhanhDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Phuc Toan
 */
public class NhapHangGUI extends javax.swing.JPanel {

    private PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private SanPhamBUS spBUS = new SanPhamBUS();
    private CTPhieuNhapBUS ctpnBUS = new CTPhieuNhapBUS();
    ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
    DefaultComboBoxModel dcbmNhaCungCap;
    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmHangChoNhap;
    String MaCN;
    String TuKhoaTimKiem;
    int SoLuongTrongKho;
    boolean NhapHang = true;

    public NhapHangGUI(String temp) {

        initComponents();
        this.MaCN = temp;
        nccBUS.docMaCN(MaCN);
        spBUS.docMaCN(MaCN);
        pnBUS.docMaCN(MaCN);
        ctpnBUS.docMaCN(MaCN);
        dcbmNhaCungCap = (DefaultComboBoxModel) cbxNhaCungCap.getModel();
        dtmSanPham = (DefaultTableModel) tblDSSP.getModel();
        dtmHangChoNhap = (DefaultTableModel) tblHangChoNhap.getModel();
        TuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
        loadMaNCClenCBX();
        loadDataDSSP();
        loadMaPN3CN();
        txtMaNCC.setEnabled(false);
        txtMaPN.setEnabled(false);

        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(TuKhoaTimKiem);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(TuKhoaTimKiem);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(TuKhoaTimKiem);
            }
        });
    }

    public void search(String tk) {
        if (tk.equals("Mã SP")) {
            spBUS.docDanhSach();
            ArrayList<SanPham_ChiNhanhDTO> dssp = spBUS.searchMaSP(txtTimKiem.getText());
            showAllDSSP(dssp);
        }
        if (tk.equals("Tên SP")) {
            spBUS.docDanhSach();
            ArrayList<SanPham_ChiNhanhDTO> dssp = spBUS.searchTenSP(txtTimKiem.getText());
            showAllDSSP(dssp);
        }
    }

    public void loadMaNCClenCBX() {
        nccBUS.docDanhSach();
        ArrayList<NhaCungCapDTO> dsncc = nccBUS.getListNhaCungCap();
        dcbmNhaCungCap.removeAllElements();
        cbxNhaCungCap.addItem("Tất cả sản phẩm");
        for (int i = 0; i < dsncc.size(); i++) {
            cbxNhaCungCap.addItem(dsncc.get(i).getMaNCC());
        }

    }

    public void showAllDSSP(ArrayList<SanPham_ChiNhanhDTO> dssp) {
        dtmSanPham.setRowCount(0);

        for (int i = 0; i < dssp.size(); i++) {
            double DonGia = dssp.get(i).getDonGia();
            int DonGiaChia = (int) (DonGia / 1.05);
            if (dssp.get(i).getDonGia() == 0) {
                dtmSanPham.addRow(new String[]{
                    dssp.get(i).getMaSP(),
                    dssp.get(i).getTenSP(),
                    String.valueOf(dssp.get(i).getSoLuong()),
                    String.valueOf(dssp.get(i).getDonGia())
                });
            } else {
                dtmSanPham.addRow(new String[]{
                    dssp.get(i).getMaSP(),
                    dssp.get(i).getTenSP(),
                    String.valueOf(dssp.get(i).getSoLuong()),
                    String.valueOf(DonGiaChia)
                });

            }
        }
    }

    public void outModelHangChoNhap(ArrayList<CTPhieuNhapDTO> dsctpn) {
        dtmHangChoNhap.setRowCount(0);
        for (int i = 0; i < dsctpn.size(); i++) {
            dtmHangChoNhap.addRow(new String[]{
                dsctpn.get(i).getMaSP(),
                dsctpn.get(i).getTenSP(),
                String.valueOf(dsctpn.get(i).getSoLuong()),
                String.valueOf(dsctpn.get(i).getDonGia()),
                String.valueOf(dsctpn.get(i).getThanhTien())
            });
        }
    }

    public void loadDataDSSP() {
        spBUS.docDanhSach();
        ArrayList<SanPham_ChiNhanhDTO> dssp = spBUS.getListSanPham();
        showAllDSSP(dssp);
    }

    public void loadMaPN3CN() {
        pnBUS.docDanhSach3CN();
        ArrayList<PhieuNhapDTO> dspn = pnBUS.getListPhieuNhap3CN();
        if (dspn.isEmpty()) {
            txtMaPN.setText("PN001");
            return;
        }
        PhieuNhapDTO lastPN = dspn.get(dspn.size() - 1);
        String MaPN = lastPN.getMaPN();
        int sum = Integer.parseInt(MaPN.substring(3)) + 1;
        if (sum < 10) {
            txtMaPN.setText("PN00" + String.valueOf(sum));
        } else if (sum == 0) {
            txtMaPN.setText("PN001" + String.valueOf(sum));
        } else {
            txtMaPN.setText("PN0" + String.valueOf(sum));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSP = new MyCustom.MyTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JLabel();
        cbxNhaCungCap = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JSpinner();
        txtTimKiem = new javax.swing.JTextField();
        cbxTimKiem = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHangChoNhap = new MyCustom.MyTable();
        btnXoa = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();
        btnTaoPhieuNhap = new javax.swing.JLabel();
        txtNgayLap = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(255, 255, 240));

        jPanel2.setBackground(new java.awt.Color(255, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(0, 0, 0)), "DANH SÁCH SẢN PHẨM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Trong kho", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSSP.getTableHeader().setReorderingAllowed(false);
        tblDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSSP);
        if (tblDSSP.getColumnModel().getColumnCount() > 0) {
            tblDSSP.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSSP.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblDSSP.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblDSSP.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Mã SP");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Tên SP");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Đơn giá");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Số lượng");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThem.setText("THÊM VÀO GIỎ");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        cbxNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNhaCungCapActionPerformed(evt);
            }
        });

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SP", "Tên SP" }));
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(21, 21, 21))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(12, 12, 12)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(txtSoLuong))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTimKiem)
                        .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThem))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÀNG CHỜ NHẬP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tblHangChoNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHangChoNhap.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblHangChoNhap);
        if (tblHangChoNhap.getColumnModel().getColumnCount() > 0) {
            tblHangChoNhap.getColumnModel().getColumn(0).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblHangChoNhap.getColumnModel().getColumn(1).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblHangChoNhap.getColumnModel().getColumn(2).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(2).setPreferredWidth(25);
            tblHangChoNhap.getColumnModel().getColumn(3).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblHangChoNhap.getColumnModel().getColumn(4).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnXoa.setText("XÓA SẢN PHẨM");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN PHIẾU NHẬP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Mã PN");

        txtMaPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaPNMouseClicked(evt);
            }
        });
        txtMaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPNActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Mã NV");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Mã NCC");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Ngày lập");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Tổng tiền");

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnTaoPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTaoPhieuNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTaoPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnTaoPhieuNhap.setText("TẠO PHIẾU NHẬP");
        btnTaoPhieuNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoPhieuNhapMouseClicked(evt);
            }
        });

        txtNgayLap.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtTongTien))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoPhieuNhap)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        int k = tblDSSP.getSelectedRow();
        String MaSP = tblDSSP.getModel().getValueAt(k, 0).toString();

        txtMaSP.setText(MaSP);
        txtTenSP.setText(tblDSSP.getModel().getValueAt(k, 1).toString());
        txtDonGia.setText(tblDSSP.getModel().getValueAt(k, 3).toString());
        int DonGia = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 3).toString());
        if (DonGia == 0) {
            NhapHang = false;
        }
        spBUS.docDanhSach();
        ArrayList<SanPham_ChiNhanhDTO> dssp = spBUS.getListSanPham();
        for (SanPham_ChiNhanhDTO sp : dssp) {
            if (sp.getMaSP().equals(MaSP)) {
                SoLuongTrongKho = sp.getSoLuong();
            }
        }

//        int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 2).toString());
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 0, 100, 1);
        txtSoLuong.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(false);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaPN = txtMaPN.getText();
        String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        int SoLuong = Integer.parseInt(txtSoLuong.getValue().toString());
        int DonGia = Integer.parseInt(txtDonGia.getText());
        int ThanhTien = SoLuong * DonGia;
        SanPhamDTO sp = new SanPhamDTO(MaSP, DonGia);

        spBUS.capNhatSLNhapHang(MaSP, SoLuong, SoLuongTrongKho);
        spBUS.docDanhSach();
        boolean flag = true;

        for (CTPhieuNhapDTO ctpn : dsctpn) {
            if (ctpn.getMaSP().equals(MaSP)) {
                int SLCu = ctpn.getSoLuong();
                ctpn.setSoLuong(SLCu + SoLuong);
                int SLMoi = ctpn.getSoLuong();
                ctpn.setThanhTien(SLMoi * DonGia);
                flag = false;
                break;
            }
        }
        if (flag) {
            dsctpn.add(new CTPhieuNhapDTO(MaPN, MaSP, TenSP, SoLuong, DonGia, ThanhTien));
        }
        outModelHangChoNhap(dsctpn);
        int TongTien = 0;
        for (CTPhieuNhapDTO ctpn : dsctpn) {
            TongTien = TongTien + ctpn.getThanhTien();
            txtTongTien.setText(String.valueOf(TongTien));
        }
        if (NhapHang == false) {
            spBUS.updateGiaBan(sp);
            return;
        }
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtSoLuong.setValue(0);
        txtDonGia.setText("");

    }//GEN-LAST:event_btnThemMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        int k = tblHangChoNhap.getSelectedRow();
        String MaSP = tblHangChoNhap.getModel().getValueAt(k, 0).toString();
        int SoLuongNhap = Integer.parseInt(tblHangChoNhap.getModel().getValueAt(k, 2).toString());
        spBUS.docDanhSach();
        ArrayList<SanPham_ChiNhanhDTO> dssp = spBUS.getListSanPham();
        for (SanPham_ChiNhanhDTO sp : dssp) {
            if (sp.getMaSP().equals(MaSP)) {
                SoLuongTrongKho = sp.getSoLuong();
                System.out.println(SoLuongTrongKho);
            }
        }
        spBUS.capNhatSPXoaSPHangChoNhap(MaSP, SoLuongNhap, SoLuongTrongKho);
        dsctpn.remove(k);
        dtmHangChoNhap.removeRow(k);
        if (dsctpn.size() == 0) {
            loadDataDSSP();
        }

    }//GEN-LAST:event_btnXoaMouseClicked

    private void txtMaPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaPNMouseClicked
//        hdBUS.docDanhSachMaHD();
//        ArrayList<HoaDonDTO> dshd = hdBUS.getListMaHDTuTang();
//        HoaDonDTO lastHoaDon = dshd.get(dshd.size()-1);
//        String MaHD = lastHoaDon.getMaHD();
//        int sum = Integer.parseInt(MaHD.substring(3)) + 1;
//        System.out.println(sum);
//        if( sum < 10){
//            txtMaHD.setText(String.valueOf("HD00" + sum));
//        } else {
//            txtMaHD.setText(String.valueOf("HD0" + sum));
//        }
//        txtMaHD.setEnabled(false);
    }//GEN-LAST:event_txtMaPNMouseClicked

    private void txtMaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPNActionPerformed

    }//GEN-LAST:event_txtMaPNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SNhanVienGUI snv = new SNhanVienGUI(MaCN);
        snv.setVisible(true);
        String MaNV = snv.getMaNV();
        txtMaNV.setText(MaNV);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTaoPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoPhieuNhapMouseClicked
        String MaPN = txtMaPN.getText();
        String MaNV = txtMaNV.getText();
        String MaNCC = txtMaNCC.getText();
        int TongTien = Integer.parseInt(txtTongTien.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String NgayLap = sdf.format(txtNgayLap.getDate());

        try {
            Date NgayLap1 = sdf.parse(NgayLap);
            PhieuNhapDTO pn = new PhieuNhapDTO(MaPN, NgayLap1, TongTien, MaNV, MaNCC);
            pnBUS.add(pn);
        } catch (ParseException ex) {
            Logger.getLogger(NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (CTPhieuNhapDTO ctpn : dsctpn) {

            ctpnBUS.add(ctpn);
        }
        JOptionPane.showMessageDialog(this, "In phiếu nhập thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
        dtmHangChoNhap.setRowCount(0);
        dsctpn.clear();
        loadDataDSSP();
        loadMaPN3CN();
        txtMaNV.setText("");
        txtMaNCC.setText("");
        txtTongTien.setText("");
        txtNgayLap.setDate(null);

    }//GEN-LAST:event_btnTaoPhieuNhapMouseClicked

    private void cbxNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNhaCungCapActionPerformed
        String MaNCC = (String) cbxNhaCungCap.getSelectedItem();
        if (String.valueOf(MaNCC).equals("Tất cả sản phẩm")) {
            loadDataDSSP();
        } else {
            txtMaNCC.setText(MaNCC);
            spBUS.docDanhSach();
            ArrayList<SanPham_ChiNhanhDTO> dssp = spBUS.getListSanPham();
            dtmSanPham.setRowCount(0);
            for (int i = 0; i < dssp.size(); i++) {
                String MaNCC1 = dssp.get(i).getMaNCC();
                if (String.valueOf(MaNCC).equals(MaNCC1)) {
                    dtmSanPham.addRow(new String[]{
                        dssp.get(i).getMaSP(),
                        dssp.get(i).getTenSP(),
                        String.valueOf(dssp.get(i).getSoLuong()),
                        String.valueOf(dssp.get(i).getDonGia())
                    });
                }
            }

        }
        
        txtTimKiem.setText("");
//

//            }
//        }
//        }

    }//GEN-LAST:event_cbxNhaCungCapActionPerformed

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        TuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
    }//GEN-LAST:event_cbxTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnTaoPhieuNhap;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JComboBox<String> cbxNhaCungCap;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private MyCustom.MyTable tblDSSP;
    private MyCustom.MyTable tblHangChoNhap;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaSP;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
