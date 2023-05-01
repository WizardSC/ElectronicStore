/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class PhieuNhapBUS {
    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    private ArrayList<PhieuNhapDTO> listPhieuNhap = null;
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        pnDAO.docMaCN(MaCN);
    }
    public void docDanhSach(){
        this.listPhieuNhap = pnDAO.getListPhieuNhap();
    }
    
    public void docDanhSach3CN(){    
        this.listPhieuNhap = pnDAO.getListPhieuNhap3CN();
    }
    public ArrayList<PhieuNhapDTO> getListPhieuNhap(){
        return listPhieuNhap;
    }
    
    public ArrayList<PhieuNhapDTO> getListPhieuNhap3CN(){
        return listPhieuNhap;
    }
}
