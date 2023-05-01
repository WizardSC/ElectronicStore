/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Phuc Toan
 */
public class PhieuNhapDTO {
    private String MaPN;
    private Date NgayLap;
    private int TongTien;
    private String MaNV;
    private String MaNCC;

    public PhieuNhapDTO(String MaPN, Date NgayLap, int TongTien, String MaNV, String MaNCC) {
        this.MaPN = MaPN;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
        this.MaNV = MaNV;
        this.MaNCC = MaNCC;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }
    
    
}
