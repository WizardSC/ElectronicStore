/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import DTO.SanPham_ChiNhanhDTO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    private MSSQLConnect mssql = new MSSQLConnect();
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(temp);
    }
    public ArrayList<SanPhamDTO> getListMaSP(){
        try {
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "Select * from sanpham";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                SanPhamDTO sp = new SanPhamDTO(
                        rs.getString("MaSP"),
                        rs.getInt("DonGia")
                );
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
        
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
    public void insertSanPham(SanPham_ChiNhanhDTO sp){
        try {
            Connection connection = mssql.getConnection();
            String sql = "INSERT INTO sanpham (MaSP, TenSP, DonViTinh, DonGia, MaLoai, MaNSX, MaNCC, IMG) VALUES(?,?,?,?,?,?,?,?)";
            String sql1 = "INSERT INTO sanpham_chinhanh (MaSP, MaCN, SoLuong) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps.setString(1, sp.getMaSP());
            ps.setString(2,sp.getTenSP());
            ps.setString(3,sp.getDonViTinh());
            ps.setInt(4,sp.getDonGia());
            ps.setString(5,sp.getMaLoai());
            ps.setString(6,sp.getMaNSX());
            ps.setString(7,sp.getMaNCC());
            ps.setString(8,sp.getIMG());
            ps1.setString(1,sp.getMaSP());
            ps1.setString(2,sp.getMaCN());
            ps1.setInt(3,sp.getSoLuong());
            ps.executeUpdate();
            ps1.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateSanPham(SanPham_ChiNhanhDTO sp){
        try {
            Connection connection = mssql.getConnection();
            ArrayList<SanPham_ChiNhanhDTO> dssp = new ArrayList<>();
            String sql = "UPDATE sanpham set TenSP = ?, DonViTinh = ?, MaLoai = ?, MaNSX = ?, MaNCC = ?, IMG = ? where MaSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setString(2,sp.getDonViTinh());
            ps.setString(3,sp.getMaLoai());
            ps.setString(4,sp.getMaNSX());
            ps.setString(5,sp.getMaNCC());
            ps.setString(6,sp.getIMG());
            ps.setString(7,sp.getMaSP());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteSanPham(String MaSP) throws SQLException, SQLServerException{
        try {
            Connection connection = mssql.getConnection();
            ArrayList<SanPham_ChiNhanhDTO> dssp = new ArrayList<>();
            String sql = "exec sp_deleteSan7Pham ?"; 
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,MaSP);
            ps.executeUpdate();
        } catch (SQLServerException ex) {
            if (ex.getErrorCode() == 547) {
                throw ex;
            }
        } finally {
            mssql.Disconnect();
        }
    }
    
    public void updateGiaBan(SanPhamDTO sp){
        try {
            Connection connection = mssql.getConnection();
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "update sanpham set DonGia = ? * 1.05 where MaSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,sp.getDonGia());
            ps.setString(2,sp.getMaSP());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void capNhatSLNhapHang(String MaSP, int SoLuongNhap, int SoLuongTrongKho){
        try {
            Connection connection = mssql.getConnection();
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "update sanpham_chinhanh set SoLuong = ? where MaSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,SoLuongNhap + SoLuongTrongKho);
            ps.setString(2,MaSP);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void capNhatSLBanHang(String MaSP, int SoLuongBan, int SoLuongTrongKho){
        try {
            Connection connection = mssql.getConnection();
            String sql = "update sanpham_chinhanh set SoLuong = ? where MaSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,SoLuongTrongKho - SoLuongBan);
            ps.setString(2,MaSP);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void capNhatSLXoaSPGioHang(String MaSP, int SoLuongXoa, int SoLuongTrongKho){
        try {
            Connection connection = mssql.getConnection();
            String sql = "update sanpham_chinhanh set SoLuong = ? where MaSP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, SoLuongXoa + SoLuongTrongKho);
            ps.setString(2,MaSP);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
