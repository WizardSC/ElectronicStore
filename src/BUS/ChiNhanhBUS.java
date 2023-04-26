/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiNhanhDAO;
import DTO.ChiNhanhDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class ChiNhanhBUS {

    private ArrayList<ChiNhanhDTO> listChiNhanh = null;
    private ChiNhanhDAO cnDAO = new ChiNhanhDAO();
    private String MaCN = "";

    public void docDanhSach() {
        this.listChiNhanh = cnDAO.getListChiNhanh();
    }

    public void docMaCN(String temp) {
        this.MaCN = temp;
        cnDAO.docMaCN(MaCN);

    }
    
    public void docDanhSach3CN(){
        this.listChiNhanh = cnDAO.getList3ChiNhanh();
    }
    public ArrayList<ChiNhanhDTO> getListChiNhanh() {
        return listChiNhanh;
    }
    
    public ArrayList<ChiNhanhDTO> getList3ChiNhanh(){
        this.listChiNhanh = cnDAO.getList3ChiNhanh();
        return listChiNhanh;
    }
}
