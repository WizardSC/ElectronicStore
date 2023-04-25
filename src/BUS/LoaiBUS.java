/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiDAO;
import DTO.LoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class LoaiBUS {
    private ArrayList<LoaiDTO> listLoai = null;
    private LoaiDAO loaiDAO = new LoaiDAO();
    String MaCN;
    
    public void docMaCN(String temp){
        this.MaCN = temp;
        loaiDAO.docMaCN(temp);
        System.out.println("Thu tu 2");
    }
    public void docDanhSach(){
        this.listLoai = loaiDAO.getListLoai();
    }
    
    public ArrayList<LoaiDTO> getListLoai(){
        return listLoai;
    }
}
