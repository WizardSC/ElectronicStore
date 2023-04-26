/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Phuc Toan
 */
public class NhanVienDTO {
    private String MaNV;
    private String Ho;
    private String Ten;
    private int NamSinh;
    private String GioiTinh;
    private String SoDT;
    private String DiaChi;
    private String MaCV;
    private String MaCN;
    private String IMG;

    public NhanVienDTO(String MaNV) {
        this.MaNV = MaNV;
    }

    public NhanVienDTO(String MaNV, String Ho, String Ten, int NamSinh, String GioiTinh, String SoDT, String DiaChi, String MaCV, String MaCN, String IMG) {
        this.MaNV = MaNV;
        this.Ho = Ho;
        this.Ten = Ten;
        this.NamSinh = NamSinh;
        this.GioiTinh = GioiTinh;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.MaCV = MaCV;
        this.MaCN = MaCN;
        this.IMG = IMG;
    }

    public NhanVienDTO(String MaNV, String MaCN) {
        this.MaNV = MaNV;
        this.MaCN = MaCN;
    }

    

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

   

    public NhanVienDTO() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
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

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String MaCN) {
        this.MaCN = MaCN;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
    
    
}
