/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public ArrayList<NhanVienDTO> getListNVMaTuTang(String MaCN) {
        try {
            ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
            String sqlGoc = "select * from nhanvien"; //đăng nhập toàn cục
            String sql = "exec sp_SelectAllMaNV"; //đăng nhập chi nhánh
            if (MaCN.equals("null")) {
                ResultSet rs = mssql.executeQuery(sqlGoc);
                while (rs.next()) {
                    NhanVienDTO nv = new NhanVienDTO(
                            rs.getString("MaNV")
                    );
                    dsnv.add(nv);
                }
                return dsnv;
            } else {
                ResultSet rs = mssql.executeQuery(sql);
                while (rs.next()) {
                    NhanVienDTO nv = new NhanVienDTO(
                            rs.getString("MaNV")
                    );
                    dsnv.add(nv);
                }
                return dsnv;
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<NhanVienDTO> getListMaNV(){
        try {
            ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
            String sql = "select MaNV from nhanvien where MaNV not in(Select MaNV from taikhoan)";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                NhanVienDTO nv = new NhanVienDTO(
                        rs.getString("MaNV")
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
    public ArrayList<NhanVienDTO> getListNhanVien() {
        try {
            ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
            String sql = "SELECT * FROM nhanvien";

            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getInt("NamSinh"),
                        rs.getString("GioiTinh"),
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
            String sql = "INSERT INTO nhanvien VALUES (?,?,?,?,?,?,?,?,?,?,NEWID())";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, nv.getMaNV());
            pstatement.setString(2, nv.getHo());
            pstatement.setString(3, nv.getTen());
            pstatement.setInt(4, nv.getNamSinh());
            pstatement.setString(5, nv.getSoDT());
            pstatement.setString(6, nv.getSoDT());
            pstatement.setString(7, nv.getDiaChi());
            pstatement.setString(8, nv.getMaCV());
            pstatement.setString(9, nv.getMaCN());
//           Tham số thứ 10 là cột rowguid
            pstatement.setString(10, nv.getIMG());
            pstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
    }

    public void updateNhanVien(NhanVienDTO nv) {
        try {
            Connection connection = mssql.getConnection();
            String sql = "UPDATE nhanvien SET Ho = ?, Ten = ?, NamSinh = ?,  GioiTinh = ?, SoDT = ?, DiaChi = ?, MaCV = ?, MaCN = ?, IMG = ? where MaNV = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nv.getHo());
            ps.setString(2, nv.getTen());
            ps.setInt(3, nv.getNamSinh());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getSoDT());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getMaCV());
            ps.setString(8, nv.getMaCN());
            ps.setString(9, nv.getIMG());
            ps.setString(10, nv.getMaNV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }

    }

    public void deleteNhanVien(String MaNV) throws SQLException, SQLServerException {
        try {
            Connection connection = mssql.getConnection();
            String sql = "DELETE from nhanvien where MaNV = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, MaNV);
            ps.executeUpdate();
        } catch (SQLServerException ex) {
            if (ex.getErrorCode() == 547) {
                throw ex;
            }
        } finally {
            mssql.Disconnect();
        }
    }

    public ArrayList<NhanVienDTO> getListNV3ChiNhanh() {
        try {
            ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
            String sql = "EXEC sp_SelectAllNV";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getInt("NamSinh"),
                        rs.getString("GioiTinh"),
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
    public void updateChiNhanh(NhanVienDTO nv) {
        try {
            Connection connection = mssql.getConnection();
            System.out.println("Thuc thi update Chi Nhanh");
            String sql = "exec sp_ChuyenChiNhanhNV N'" + nv.getMaNV() +"'" + ", " + "N'" + nv.getMaCN() +"'";
            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, nv.getMaCN());
//            ps.setString(2, nv.getMaNV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }

    }
//    public void deleteNhanVien(String MaNV) throws SQLException, SQLIntegrityConstraintViolationException{
//        try {
//            Connection connection = mssql.getConnection();
//            String sql = "DELETE from nhanvien where MaNV = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1,MaNV);
//            ps.executeUpdate();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}
