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
    public void docDanhSach(String temp) {
        this.MaCN = temp;
        this.listChiNhanh = cnDAO.getListChiNhanh(MaCN);
        
//        System.out.println("Ham BUS" +MaCN);
    }

   

    public ArrayList<ChiNhanhDTO> getListChiNhanh() {
        return listChiNhanh;
    }
}
