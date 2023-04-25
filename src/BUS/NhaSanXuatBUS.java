/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuatDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class NhaSanXuatBUS {
    private NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
    private ArrayList<NhaSanXuatDTO> listNhaSanXuat = null;
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        nsxDAO.docMaCN(temp);
    }
    
    public void docDanhSach(){
        this.listNhaSanXuat = nsxDAO.getListNSX();
    }
    public ArrayList<NhaSanXuatDTO> getListNSX(){
        return listNhaSanXuat;
    }
}
