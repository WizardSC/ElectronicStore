/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiNhanhDAO;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class NhanVienBUS {
    private NhanVienDAO nvDAO = new NhanVienDAO();

    private ArrayList<NhanVienDTO> listNhanVien = null;
    String MaCN;
    public void docMaCN(String temp) {
        this.MaCN = temp;
        nvDAO.docMaCN(MaCN);

    }
    public void docDanhSach(){
        this.listNhanVien = nvDAO.getListNhanVien();
    }
    
    public ArrayList<NhanVienDTO> getListNhanVien(){
        return listNhanVien;
    }
}
