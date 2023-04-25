/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Phuc Toan
 */
public class KhuyenMaiDTO {
    private String MaKM;
    private String TenKM;
    private int PhanTramKM;
    private int DieuKien;
    private Date NgayBD;
    private Date NgayKT;

    public KhuyenMaiDTO(String MaKM, String TenKM, int PhanTramKM, int DieuKien, Date NgayBD, Date NgayKT) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.PhanTramKM = PhanTramKM;
        this.DieuKien = DieuKien;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public int getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(int PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public int getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(int DieuKien) {
        this.DieuKien = DieuKien;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }
    
}
