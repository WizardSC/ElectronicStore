/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChucVuDAO;
import DTO.ChucVuDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class ChucVuBUS {
    private ChucVuDAO cvDAO = new ChucVuDAO();
    private ArrayList<ChucVuDTO> listChucVu = null;
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        cvDAO.docMaCN(temp);
    }
    public void docDanhSach(){
        this.listChucVu = cvDAO.getListChucVu();
    }
    
    public ArrayList<ChucVuDTO> getListChucVu(){
        return listChucVu;
    }
}
