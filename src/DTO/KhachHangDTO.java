/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Phuc Toan
 */
public class KhachHangDTO {
    private String MaKH;
    private String Ho;
    private String Ten;
    private String NamSinh;
    private String GioiTinh;
    private String SoDT;
    private String DiaChi;
    private String IMG;

    public KhachHangDTO(String MaKH) {
        this.MaKH = MaKH;
    }

    public KhachHangDTO(String MaKH, String Ho, String Ten, String NamSinh, String GioiTinh, String SoDT, String DiaChi, String IMG) {
        this.MaKH = MaKH;
        this.Ho = Ho;
        this.Ten = Ten;
        this.NamSinh = NamSinh;
        this.GioiTinh = GioiTinh;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.IMG = IMG;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
    
}
