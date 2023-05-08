/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class CTPhieuNhapBUS {
    private ArrayList<CTPhieuNhapDTO> listCTPN = null;
    private CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
    String MaCN;
    
    public void docMaCN(String temp){
        this.MaCN = temp;
        ctpnDAO.docMaCN(MaCN);
    }
    public void docDanhSach(){
        this.listCTPN = ctpnDAO.getListCTPN();
    }
    public void docDanhSach3CN(){
        this.listCTPN = ctpnDAO.getListCTPN3CN();
    }
   
    public ArrayList<CTPhieuNhapDTO> getListCTPNtheoMaPN(String MaPN){
        ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
        for(CTPhieuNhapDTO ctpn : listCTPN){
            if(ctpn.getMaPN().equals(MaPN)){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
    
    public ArrayList<CTPhieuNhapDTO> getListCTPNtheoMaPN3CN(String MaPN){
        ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
        for(CTPhieuNhapDTO ctpn : listCTPN){
            if(ctpn.getMaPN().equals(MaPN)){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
    
    public void add(CTPhieuNhapDTO ctpn){
        docDanhSach();
        listCTPN.add(ctpn);
        ctpnDAO.insertCTPN(ctpn);
    }
}
