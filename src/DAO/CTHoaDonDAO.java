/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTHoaDonDTO;
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
public class CTHoaDonDAO {
    private MSSQLConnect mssql = new MSSQLConnect();
    private String MaCN;
    
    public void docMaCN(String temp){
        this.MaCN = temp;
        mssql.docMaCN(MaCN);
    }
    
    public ArrayList<CTHoaDonDTO> getListCTHD(){
        try {
            ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
            String sql = "Select * from cthoadon";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                CTHoaDonDTO cthd = new CTHoaDonDTO(
                        rs.getString("MaHD"),
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getInt("ThanhTien")
                );
                dscthd.add(cthd);
            }
            return dscthd;
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
    public ArrayList<CTHoaDonDTO> getListCTHD3CN(){
        try {
            ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
            String sql = "exec sp_SelectAllCTHD";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                CTHoaDonDTO cthd = new CTHoaDonDTO(
                rs.getString("MaHD"),
                rs.getString("MaSP"),
                rs.getString("TenSP"),
                rs.getInt("SoLuong"),
                rs.getInt("DonGia"),
                rs.getInt("ThanhTien"));
                dscthd.add(cthd);
                        }
            return dscthd;
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
    public void insertCTHD(CTHoaDonDTO cthd){
        try {
            Connection connection = mssql.getConnection();
            String sql = "Insert into cthoadon (MaHD, MaSP, TenSP, SoLuong, DonGia, ThanhTien) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cthd.getMaHD());
            ps.setString(2,cthd.getMaSP());
            ps.setString(3,cthd.getTenSP());
            ps.setInt(4,cthd.getSoLuong());
            ps.setInt(5,cthd.getDonGia());
            ps.setInt(6,cthd.getThanhTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
