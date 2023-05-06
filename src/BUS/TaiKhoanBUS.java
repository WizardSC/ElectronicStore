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
    public void docMaCN(String temp){
        this.MaCN = temp;
        tkDAO.docMaCN(MaCN);
    }
    
    public void docDanhSach(){
        this.listTaiKhoan = tkDAO.getListTaiKhoan();
    }
    
    public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        return listTaiKhoan;
    }
    
    public void add(TaiKhoanDTO tk){
        listTaiKhoan.add(tk);
        tkDAO.insertTaiKhoan(tk);
    }
}
