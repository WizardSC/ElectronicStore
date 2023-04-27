/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class HoaDonBUS {
    private HoaDonDAO hdDAO = new HoaDonDAO();
    private ArrayList<HoaDonDTO> listHoaDon = null;
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        hdDAO.docMaCN(MaCN);
    }
    
    public void docDanhSachMaHD(){
        this.listHoaDon = hdDAO.getListMaHDTuTang();
    }
    public void docDanhSach(){
        this.listHoaDon = hdDAO.getListHoaDon();
    }
    
    public void docDanhSach3CN(){
        this.listHoaDon = hdDAO.getListHoaDon3CN();
    }
    
    public ArrayList<HoaDonDTO> getListHoaDon3CN(){
        return listHoaDon;
    }
    
    public ArrayList<HoaDonDTO> getListMaHDTuTang(){
        return listHoaDon; 
    }
    
    
    public ArrayList<HoaDonDTO> getListHoaDon(){
        return listHoaDon;
        
    }
    
}
