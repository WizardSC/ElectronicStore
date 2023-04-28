/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class NhaCungCapBUS {
    private NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    ArrayList<NhaCungCapDTO> listNhaCungCap;
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        nccDAO.docMaCN(MaCN);
    }
    public void docDanhSach(){
        this.listNhaCungCap = nccDAO.getListNCC();
    }
    
    public ArrayList<NhaCungCapDTO> getListNhaCungCap(){
        return listNhaCungCap;
    }
}
