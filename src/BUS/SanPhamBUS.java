/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import DTO.SanPham_ChiNhanhDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class SanPhamBUS {
    private SanPhamDAO spDAO = new SanPhamDAO();
    private ArrayList<SanPham_ChiNhanhDTO> listSanPham = null;
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        spDAO.docMaCN(temp);
    }
    public void docDanhSach(){
        this.listSanPham = spDAO.getListSanPham();
    }
    
    public ArrayList<SanPham_ChiNhanhDTO> getListSanPham(){
        return listSanPham;
    }
}
