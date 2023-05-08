/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Phuc Toan
 */
public class TaiKhoanDTO {
    private String TenDangNhap;
    private String MatKhau;
    private String MaNV;
    private boolean TinhTrang;
    private String MaCV;

    public TaiKhoanDTO(String TenDangNhap, String MatKhau, String MaNV, boolean TinhTrang, String MaCV) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.MaNV = MaNV;
        this.TinhTrang = TinhTrang;
        this.MaCV = MaCV;
    }

    public TaiKhoanDTO(String TenDangNhap, String MatKhau) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public TaiKhoanDTO(String TenDangNhap, boolean TinhTrang) {
        this.TenDangNhap = TenDangNhap;
        this.TinhTrang = TinhTrang;
    }

    
    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }
    
    
}
