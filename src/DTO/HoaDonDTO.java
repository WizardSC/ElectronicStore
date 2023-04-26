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
public class HoaDonDTO {
    private String MaHD;
    private Date NgayLap;
    private int TongTien;
    private String MaNV;
    private String MaKH;
    private String MaKM;

    public HoaDonDTO(String MaHD) {
        this.MaHD = MaHD;
    }

    public HoaDonDTO(String MaHD, Date NgayLap, int TongTien, String MaNV, String MaKH, String MaKM) {
        this.MaHD = MaHD;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaKM = MaKM;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
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

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }
    

    
    
    
}
