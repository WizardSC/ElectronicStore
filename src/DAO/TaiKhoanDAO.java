/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoanDTO;
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
public class TaiKhoanDAO {

    private MSSQLConnect mssql = new MSSQLConnect();
    private String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(MaCN);
    }
    public ArrayList<TaiKhoanDTO> getListTK3CN(){
        try {
            ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();
            String sql = "exec sp_SelectAllTK";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                TaiKhoanDTO tk = new TaiKhoanDTO(
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getBoolean("TinhTrang"),
                        rs.getString("MaCV")
                );
                dstk.add(tk);
            }
            return dstk;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
    public ArrayList<TaiKhoanDTO> getListTaiKhoan() {
        try {
            ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();
            String sql = "select * from taikhoan";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO(
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getBoolean("TinhTrang"),
                        rs.getString("MaCV")
                );
                dstk.add(tk);
            }
            return dstk;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
    
    public void insertTaiKhoan(TaiKhoanDTO tk){
        try {
            Connection connection = mssql.getConnection();
            String sql = "Insert into taikhoan (TenDangNhap, MatKhau, MaNV, TinhTrang, MaCV) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,tk.getTenDangNhap());
            ps.setString(2,tk.getMatKhau());
            ps.setString(3,tk.getMaNV());
            ps.setBoolean(4,tk.isTinhTrang());
            ps.setString(5,tk.getMaCV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateMatKhauTK(TaiKhoanDTO tk){
        try {
            Connection connection = mssql.getConnection();
            String sql = "update taikhoan set MatKhau = ? where TenDangNhap = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,tk.getMatKhau());
            ps.setString(2,tk.getTenDangNhap());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void khoaTaiKhoan(TaiKhoanDTO tk){
        try {
            Connection connection = mssql.getConnection();
            String sql = "update taikhoan set TinhTrang = ? where TenDangNhap = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBoolean(1, tk.isTinhTrang());
            ps.setString(2,tk.getTenDangNhap());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
