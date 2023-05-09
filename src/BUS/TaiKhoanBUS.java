/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class TaiKhoanBUS {

    private String MaCN;
    private ArrayList<TaiKhoanDTO> listTaiKhoan = null;
    private TaiKhoanDAO tkDAO = new TaiKhoanDAO();

    public void docMaCN(String temp) {
        this.MaCN = temp;
        tkDAO.docMaCN(MaCN);
    }

    public void docDanhSach() {
        this.listTaiKhoan = tkDAO.getListTaiKhoan();
    }

    public void docDanhSach3CN() {
        this.listTaiKhoan = tkDAO.getListTK3CN();
    }

    public ArrayList<TaiKhoanDTO> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public ArrayList<TaiKhoanDTO> getListTaiKhoan3CN() {
        return listTaiKhoan;
    }

    public void add(TaiKhoanDTO tk) {
        listTaiKhoan.add(tk);
        tkDAO.insertTaiKhoan(tk);
    }

    public void update(TaiKhoanDTO tk, boolean btn) {
        for (int i = 0; i < listTaiKhoan.size(); i++) {
            if (tk.getTenDangNhap().equals(listTaiKhoan.get(i).getTenDangNhap())) {
                if (btn == true) {
                    listTaiKhoan.set(i, tk);
                    tkDAO.updateMatKhauTK(tk);
                    return;
                } else {
                    tk.setMatKhau("111111");
                    listTaiKhoan.set(i, tk);
                    tkDAO.updateMatKhauTK(tk);
                    return;
                }

            }
        }
    }

    public void lock(TaiKhoanDTO tk) {
        for (int i = 0; i < listTaiKhoan.size(); i++) {
            if (tk.getTenDangNhap().equals(listTaiKhoan.get(i).getTenDangNhap())) {
                listTaiKhoan.set(i, tk);
                tkDAO.khoaTaiKhoan(tk);
                return;
            }
        }
    }

}
