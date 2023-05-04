/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhuyenMaiDTO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class KhuyenMaiDAO {

    String MaCN;
    private MSSQLConnect mssql = new MSSQLConnect();

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(temp);
    }

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai() {
        try {
            ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
            String sql = "select * from khuyenmai";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString("MaKM"),
                        rs.getString("TenKM"),
                        rs.getInt("PhanTramKM"),
                        rs.getInt("DieuKienKM"),
                        rs.getDate("NgayBD"),
                        rs.getDate("NgayKT")
                );
                dskm.add(km);
            }
            return dskm;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertKhuyenMai(KhuyenMaiDTO km) {
        try {
            Connection connection = mssql.getConnection();
            String sql = "insert into khuyenmai (MaKM, TenKM, PhanTramKM, DieuKienKM,NgayBD, NgayKT) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            java.sql.Date ngayBD = new java.sql.Date(km.getNgayBD().getTime());
            java.sql.Date ngayKT = new java.sql.Date(km.getNgayKT().getTime());
            ps.setString(1, km.getMaKM());
            ps.setString(2, km.getTenKM());
            ps.setInt(3, km.getPhanTramKM());
            ps.setInt(4, km.getDieuKien());
            ps.setDate(5, ngayBD);
            ps.setDate(6, ngayKT);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateKhuyenMai(KhuyenMaiDTO km) {
        try {
            Connection connection = mssql.getConnection();
            String sql = "Update khuyenmai set TenKM = ?, PhanTramKM = ?, DieuKienKM = ?,NgayBD = ?,NgayKT = ? where MaKM = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            java.sql.Date ngayBD = new java.sql.Date(km.getNgayBD().getTime());
            java.sql.Date ngayKT = new java.sql.Date(km.getNgayKT().getTime());
            ps.setString(1, km.getTenKM());
            ps.setInt(2, km.getPhanTramKM());
            ps.setInt(3, km.getDieuKien());
            ps.setDate(4, ngayBD);
            ps.setDate(5, ngayKT);
            ps.setString(6, km.getMaKM());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteKhuyenmai(String MaKM) throws SQLException, SQLServerException {
        try {
            Connection connection = mssql.getConnection();
            String sql = "Delete from khuyenmai where MaKM = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, MaKM);
            ps.executeUpdate();
        } catch (SQLServerException ex) {
            if (ex.getErrorCode() == 547) {
                throw ex;
            }
        } finally {
            mssql.Disconnect();
        }
    }
}
