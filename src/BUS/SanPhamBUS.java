/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import DTO.SanPham_ChiNhanhDTO;
import MyCustom.XuLyException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
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
    
    public void delete(String MaSP) throws XuLyException{
        for(SanPhamDTO sp : listSanPham){
            if(sp.getMaSP().equals(MaSP)){
                try {
                    listSanPham.remove(sp);
                    spDAO.deleteSanPham(MaSP);
                } catch (SQLServerException e){
                    throw new XuLyException("Không thể xóa sản phẩm vì đã có dữ liệu liên quan đến sản phẩm này trong CSDL ");    
                    
                } catch (Exception e){
                    e.printStackTrace();
                }
                return;
            }
        }
    }
    
    public void updateGiaBan(SanPhamDTO sp){
        docDanhSachMaSP();
        for(int i=0;i<listMaSP.size();i++){
            if(listMaSP.get(i).getMaSP().equals(sp.getMaSP())){
                listMaSP.set(i,sp);
                spDAO.updateGiaBan(sp);
                return;
            }
        }
    }
    
    public ArrayList<SanPham_ChiNhanhDTO> searchMaSP(String tk){
        ArrayList<SanPham_ChiNhanhDTO> dssp = new ArrayList<>();
        tk = tk.toLowerCase();
        for(SanPham_ChiNhanhDTO sp : listSanPham){
            if(sp.getMaSP().toLowerCase().contains(tk)){
                dssp.add(sp);
            }
        }
        return dssp;
    }
    
    public ArrayList<SanPham_ChiNhanhDTO> searchTenSP(String tk){
        ArrayList<SanPham_ChiNhanhDTO> dssp = new ArrayList<>();
        tk = tk.toLowerCase();
        for(SanPham_ChiNhanhDTO sp : listSanPham){
            if(sp.getTenSP().toLowerCase().contains(tk)){
                dssp.add(sp);
            }
        }
        return dssp;
    }
    
    public ArrayList<SanPham_ChiNhanhDTO> searchDonGia(int GiaBD, int GiaKT){
        ArrayList<SanPham_ChiNhanhDTO> dssp = new ArrayList<>();
        for(SanPham_ChiNhanhDTO sp : listSanPham){
            int DonGia = sp.getDonGia();
            if(GiaBD <= DonGia && DonGia <= GiaKT){
                dssp.add(sp);
            }
        }
        return dssp;
    }
    public void capNhatSLNhapHang(String MaSP, int SoLuongNhap, int SoLuongTrongKho){
        spDAO.capNhatSLNhapHang(MaSP, SoLuongNhap, SoLuongTrongKho);
    }
    
    public void capNhatSLBanHang(String MaSP, int SoLuongBan, int SoLuongTrongKho){
        spDAO.capNhatSLBanHang(MaSP, SoLuongBan, SoLuongTrongKho);
    }
    public void capNhatSLXoaSPGioHang(String MaSP, int SoLuongXoa, int SoLuongTrongKho){
        spDAO.capNhatSLXoaSPGioHang(MaSP, SoLuongXoa, SoLuongTrongKho);
    }
    
    public void capNhatSPXoaSPHangChoNhap(String MaSP, int SoLuongNhap, int SoLuongTrongKho){
        spDAO.capNhatSLXoaSPHangChoNhap(MaSP, SoLuongNhap, SoLuongTrongKho);
    }
}
