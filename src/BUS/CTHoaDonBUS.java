/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class CTHoaDonBUS {
    private CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
    private String MaCN;
    private ArrayList<CTHoaDonDTO> listCTHD = null;
    public void docMaCN(String temp){
        this.MaCN = temp;
        cthdDAO.docMaCN(MaCN);
    }
    
    public void docDanhSach(){
        this.listCTHD = cthdDAO.getListCTHD();
    }
    public void docDanhSach3CN(){
        this.listCTHD = cthdDAO.getListCTHD3CN();
    }
    
    public ArrayList<CTHoaDonDTO> getListCTHD(String MaHD){
        ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
        for(CTHoaDonDTO cthd : listCTHD){
            if(cthd.getMaHD().equals(MaHD)){
                dscthd.add(cthd);
            }
        }
        return dscthd;
    }
    
    public ArrayList<CTHoaDonDTO> getListCTHD3CN(String MaHD){
        ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
        for(CTHoaDonDTO cthd : listCTHD){
            if(cthd.getMaHD().equals(MaHD)){
                dscthd.add(cthd);
            }
        }
        return dscthd;
    }
    
    
    public void add(CTHoaDonDTO cthd){
        docDanhSach();
        listCTHD.add(cthd);
        cthdDAO.insertCTHD(cthd);
    }
    
}
