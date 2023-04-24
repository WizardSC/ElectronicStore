/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Phuc Toan
 */
public class ChucVuDTO {
    private String MaCV;
    private String TenCV;

    public ChucVuDTO(String MaCV, String TenCV) {
        this.MaCV = MaCV;
        this.TenCV = TenCV;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }
    
}
