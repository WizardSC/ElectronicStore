/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiNhanhDAO;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class NhanVienBUS {
    private NhanVienDAO nvDAO = new NhanVienDAO();

    private ArrayList<NhanVienDTO> listNhanVien = null;
    String MaCN;
    public void docMaCN(String temp) {
        this.MaCN = temp;
        nvDAO.docMaCN(MaCN);

    }
    public void docDanhSach(){
        this.listNhanVien = nvDAO.getListNhanVien();
    }
    public void docDanhSachNVMaTuTang(){
        this.listNhanVien = nvDAO.getListNVMaTuTang();
    }
    public ArrayList<NhanVienDTO> getListNhanVien(){
        return listNhanVien;
    }
    public ArrayList<NhanVienDTO> getListNVMaTuTang(){
        return listNhanVien;
    }
    
    public void add(NhanVienDTO nv){
        listNhanVien.add(nv);
        nvDAO.insertNhanVien(nv);
    }
    
    public void update(NhanVienDTO nv){
       
        for(int i=0;i<listNhanVien.size();i++){
            
            if(listNhanVien.get(i).getMaNV().equals(nv.getMaNV())){
                listNhanVien.set(i,nv);
               
                
                nvDAO.updateNhanVien(nv);
                return;
            }
        }
    }
}
