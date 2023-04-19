/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
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
public class NhanVienDAO {

    private ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
    private MSSQLConnect mssql = new MSSQLConnect();

    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(MaCN);
        System.out.println("ChiNhanhDAO: " + MaCN);

    }

    //Hàm đọc đữ liệu ở cả 3 cơ sở để lấy mã tự tăng
    public ArrayList<NhanVienDTO> getListNVMaTuTang() {
        try {
            ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
            String sql = "exec sp_SelectAllNV";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO(
                        rs.getString("MaNV")
                );
                dsnv.add(nv);
            }
            return dsnv;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<NhanVienDTO> getListNhanVien() {
        try {
            ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
            String sql = "SELECT * FROM nhanvien";
            System.out.println("Xin chao");
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getString("NamSinh"),
                        rs.getString("SoDT"),
                        rs.getString("DiaChi"),
                        rs.getString("MaCV"),
                        rs.getString("MaCN"),
                        rs.getString("IMG")
                );
                dsnv.add(nv);
            }
            return dsnv;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }

    public void insertNhanVien(NhanVienDTO nv) {
        try {
            Connection connection = mssql.getConnection();
            String sql = "INSERT INTO nhanvien VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, nv.getMaNV());
            pstatement.setString(2, nv.getHo());
            pstatement.setString(3, nv.getTen());
            pstatement.setString(4, nv.getNamSinh());
            pstatement.setString(5, nv.getSoDT());
            pstatement.setString(6, nv.getDiaChi());
            pstatement.setString(7, nv.getMaCV());
            pstatement.setString(8, nv.getMaCN());
            pstatement.setString(9, nv.getIMG());
            pstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
    }
}
