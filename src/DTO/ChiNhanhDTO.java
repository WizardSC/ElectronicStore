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
public class ChiNhanhDTO {
    private String MaCN;
    private String TenCN;
    private String DiaChi;

    public ChiNhanhDTO(String MaCN, String TenCN, String DiaChi) {
        this.MaCN = MaCN;
        this.TenCN = TenCN;
        this.DiaChi = DiaChi;
    }

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String MaCN) {
        this.MaCN = MaCN;
    }

    public String getTenCN() {
        return TenCN;
    }

    public void setTenCN(String TenCN) {
        this.TenCN = TenCN;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
}