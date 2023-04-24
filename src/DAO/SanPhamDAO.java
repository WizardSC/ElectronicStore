/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import DTO.SanPham_ChiNhanhDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class SanPhamDAO {

    private ArrayList<SanPhamDTO> dssp = new ArrayList<>();
    private MSSQLConnect mssql = new MSSQLConnect();
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(temp);
    }

    public ArrayList<SanPham_ChiNhanhDTO> getListSanPham() {
        try {
            ArrayList<SanPham_ChiNhanhDTO> dssp = new ArrayList<>();
            String sql = "select sp.MaSP, TenSP, DonViTinh, SoLuong, DonGia, MaLoai, MaNSX, MaNCC, IMG, MaCN "
                    + "from SANPHAM as sp "
                    + "join SANPHAM_CHINHANH as spcn on sp.MaSP = spcn.MaSP";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                SanPham_ChiNhanhDTO spcn = new SanPham_ChiNhanhDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getString("DonViTinh"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("MaLoai"),
                        rs.getString("MaNSX"),
                        rs.getString("MaNCC"),
                        rs.getString("IMG"),
                        rs.getString("MaCN")
                );
               dssp.add(spcn);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
