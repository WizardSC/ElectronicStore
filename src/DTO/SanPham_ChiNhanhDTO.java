/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Phuc Toan
 */
public class SanPham_ChiNhanhDTO extends SanPhamDTO{
    private String MaCN;
    private int SoLuong;

    public SanPham_ChiNhanhDTO(String MaSP, String TenSP, String DonViTinh, int SoLuong, int DonGia, String MaLoai, String MaNSX, String MaNCC, String IMG, String MaCN) {
        super(MaSP, TenSP, DonViTinh, DonGia, MaLoai, MaNSX, MaNCC, IMG);
        this.SoLuong = SoLuong;
        this.MaCN = MaCN;
    }

    public SanPham_ChiNhanhDTO(String MaSP) {
        super(MaSP);
    }

     
    public void setMaCN(String MaCN) {
        this.MaCN = MaCN;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaCN() {
        return MaCN;
    }

    public int getSoLuong() {
        return SoLuong;
    }
    
    
}
