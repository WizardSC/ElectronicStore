/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class KhuyenMaiBUS {
    private KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    private ArrayList<KhuyenMaiDTO> listKhuyenMai = null;
    String MaCN;
    
    public void docMaCN(String temp){
        this.MaCN = temp;
        kmDAO.docMaCN(temp);
    }
    
    public void docDanhSach(){
        this.listKhuyenMai = kmDAO.getListKhuyenMai();
    }
    
    public ArrayList<KhuyenMaiDTO> getListKhuyenMai(){
        return listKhuyenMai;
    }
}
