/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
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
public class KhachHangDAO {
    private MSSQLConnect mssql = new MSSQLConnect();
    private ArrayList<KhachHangDTO> dskh = new ArrayList<>();
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        mssql.docMaCN(MaCN);
    }
    public ArrayList<KhachHangDTO> getListMaKH(){
        try {
            ArrayList<KhachHangDTO> dskh  = new ArrayList<>();
            String sql = "exec sp_SelectAllMaKH";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                KhachHangDTO kh = new KhachHangDTO(
                        rs.getString("MaKH"));
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
    public ArrayList<KhachHangDTO> getListKhachHang(){
        try {
            ArrayList<KhachHangDTO> dskh = new ArrayList<>();
            String sql = "SELECT * FROM khachhang";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                KhachHangDTO kh = new KhachHangDTO(
                        rs.getString("MaKH"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getString("NamSinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("SoDT"),
                        rs.getString("DiaChi"),
                        rs.getString("IMG")
                );
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
    
    
    
    public void insertKhachHang(KhachHangDTO kh){
        try {
            Connection connection = mssql.getConnection();
            String sql = "Insert into khachhang values(?,?,?,?,?,?,?,?,NEWID())";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,kh.getMaKH());
            ps.setString(2,kh.getHo());
            ps.setString(3,kh.getTen());
            ps.setInt(4,Integer.parseInt(kh.getNamSinh()));
            ps.setString(5,kh.getGioiTinh());
            ps.setString(6,kh.getSoDT());
            ps.setString(7,kh.getDiaChi());
            ps.setString(8,kh.getIMG());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateKhachHang(KhachHangDTO kh){
        try {
            Connection connection = mssql.getConnection();
            String sql = "update khachhang set Ho = ?, Ten = ?, NamSinh = ?, GioiTinh = ?, SoDT = ?, DiaChi = ?, IMG = ? where MaKH = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,kh.getHo());
            ps.setString(2,kh.getTen());
            ps.setInt(3,Integer.parseInt(kh.getNamSinh()));
            ps.setString(4,kh.getGioiTinh());
            ps.setString(5,kh.getSoDT());
            ps.setString(6,kh.getDiaChi());
            ps.setString(7,kh.getIMG());
            ps.setString(8,kh.getMaKH());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteKhachHang(String MaKH) throws SQLException, SQLServerException{
        try {
            Connection connection = mssql.getConnection();
            String sql = "exec sp_deleteKhachHang ?";
//            String sql = "delete from khachhang where MaKH = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,MaKH);
            ps.executeUpdate();
        } catch (SQLServerException ex) {
            if (ex.getErrorCode() == 547) {
                throw ex;
            }
            if(ex.getErrorCode()==50000){
                throw ex;
            }
        } finally {
            mssql.Disconnect();
        }
    }
}
