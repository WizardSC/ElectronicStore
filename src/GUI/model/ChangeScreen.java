/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import GUI.BanHangGUI;
import GUI.ChiNhanhGUI;
import GUI.GiaoDienGUI;
import GUI.KhachHangGUI;
import GUI.KhuyenMaiGUI;
import GUI.NhanVienGUI;
import GUI.SanPhamGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Phuc Toan
 */
public class ChangeScreen {

    private JPanel pnRoot;
    private String kindSelected = "";
    private ArrayList<DanhMuc> list = null;
    String MaCN;

    public ChangeScreen() {
    }

    public ChangeScreen(JPanel pnRoot) {
        this.pnRoot = pnRoot;
    }

    public void getMaCN(String temp) {
        this.MaCN = temp;

        System.out.println("ChangeScreen: " + MaCN);

    }

    public void setView(JPanel pnItem, JLabel lblItem) {

//        pnItem.setBackground(new Color(130,120,210));
//        lblItem.setBackground(new Color(130,120,210));
        pnRoot.removeAll();
        pnRoot.setLayout(new BorderLayout());
        pnRoot.add(new GiaoDienGUI("CN001"));
        pnRoot.validate();
        pnRoot.repaint();
    }

    public void setEvent(ArrayList<DanhMuc> list) {
        this.list = list;
        for (DanhMuc item : list) {
            item.getLbl().addMouseListener(new LabelEvent(item.getKind(), item.getPn(), item.getLbl()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel pnItem;
        private JLabel lblItem;

        public LabelEvent(String kind, JPanel pnItem, JLabel lblItem) {
            this.kind = kind;
            this.pnItem = pnItem;
            this.lblItem = lblItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "BanHang":
                    node = new BanHangGUI(MaCN);
                    break;

                case "NhanVien":
                    node = new NhanVienGUI(MaCN);
                    break;
                case "ChiNhanh":
                    node = new ChiNhanhGUI(MaCN);
                    break;
//                case "PhieuNhap":
//                    node = new ChiNhanhGUI(MaCN);
//                    break;
//                case "HoaDon":
//                    node = new ChiNhanhGUI(MaCN);
//                    break;
                case "SanPham":
                    node = new SanPhamGUI(MaCN);
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiGUI(MaCN);
                    break;
                case "KhachHang":
                    node = new KhachHangGUI(MaCN);
                    break;
                default:
                    break;
            }
            pnRoot.removeAll();
            pnRoot.setLayout(new BorderLayout());
            pnRoot.add(node);
            pnRoot.validate();
            pnRoot.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            pnItem.setBackground(new Color(153, 204, 255));
            lblItem.setBackground(new Color(153, 204, 255));

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pnItem.setBackground(new Color(153, 204, 255));
            lblItem.setBackground(new Color(153, 204, 255));
            lblItem.setForeground(new Color(0, 0, 0));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                pnItem.setBackground(new Color(128, 128, 128));
                lblItem.setBackground(new Color(128, 128, 128));
                lblItem.setForeground(new Color(255, 255, 255));
            } else {

            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMuc item : list) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getPn().setBackground(new Color(153, 204, 255));
                item.getLbl().setBackground(new Color(153, 204, 255));
                item.getLbl().setForeground(new Color(0, 0, 0)); // Thêm dòng này để đổi màu chữ thành đen
            } else {
                item.getPn().setBackground(new Color(128, 128, 128));
                item.getLbl().setBackground(new Color(128, 128, 128));
                item.getLbl().setForeground(new Color(255, 255, 255)); // Thêm dòng này để đổi màu chữ thành trắng
            }
        }
    }
}
