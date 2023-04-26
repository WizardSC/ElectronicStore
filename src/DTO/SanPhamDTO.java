/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Phuc Toan
 */
public class SanPhamDTO {
    private String MaSP;
    private String TenSP;
    private String DonViTinh;
    private int DonGia;
    private String MaLoai;
    private String MaNSX;
    private String MaNCC;
    private String IMG;

    public SanPhamDTO(String MaSP, String TenSP, String DonViTinh, int DonGia, String MaLoai, String MaNSX, String MaNCC, String IMG) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DonViTinh = DonViTinh;
        this.DonGia = DonGia;
        this.MaLoai = MaLoai;
        this.MaNSX = MaNSX;
        this.MaNCC = MaNCC;
        this.IMG = IMG;
    }

    public SanPhamDTO(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
    
    
}
