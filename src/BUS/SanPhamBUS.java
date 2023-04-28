/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import DTO.SanPham_ChiNhanhDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class SanPhamBUS {
    private SanPhamDAO spDAO = new SanPhamDAO();
    private ArrayList<SanPham_ChiNhanhDTO> listSanPham = null;
    private ArrayList<SanPhamDTO> listMaSP = null;
    
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        spDAO.docMaCN(temp);
    }
    public void docDanhSach(){
        this.listSanPham = spDAO.getListSanPham();
    }
    public void docDanhSachMaSP(){
        this.listMaSP = spDAO.getListMaSP();
    }
    public ArrayList<SanPham_ChiNhanhDTO> getListSanPham(){
        return listSanPham;
    }
    public ArrayList<SanPhamDTO> getListMaSP(){
        return listMaSP;
    }
    public void add(SanPham_ChiNhanhDTO sp){
        listSanPham.add(sp);
        spDAO.insertSanPham(sp);
    }
    public void update(SanPham_ChiNhanhDTO sp){
        for(int i=0;i<listSanPham.size();i++){
            if(listSanPham.get(i).getMaSP().equals(sp.getMaSP())){
                listSanPham.set(i,sp);
                spDAO.updateSanPham(sp);
                return;
            }
        }
    }
}
