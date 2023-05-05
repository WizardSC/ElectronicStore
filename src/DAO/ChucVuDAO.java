/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChucVuDTO;
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
public class ChucVuDAO {

    private ArrayList<ChucVuDTO> dscv = new ArrayList<>();
    private MSSQLConnect mssql = new MSSQLConnect();

    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(temp);
    }

    public ArrayList<ChucVuDTO> getListChucVu() {
        try {
            ArrayList<ChucVuDTO> dscv = new ArrayList<>();
            String sql = "SELECT * FROM chucvu";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                ChucVuDTO cv = new ChucVuDTO(
                        rs.getString("MaCV"),
                        rs.getString("TenCV")
                );
                dscv.add(cv);
            }
            return dscv;

        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }

    public void insertChucVu(ChucVuDTO cv) {
        try {
            Connection connection = mssql.getConnection();
            String sql = "insert into chucvu (MaCV, TenCV) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cv.getMaCV());
            ps.setString(2, cv.getTenCV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateChucVu(ChucVuDTO cv) {
        try {
            Connection connection = mssql.getConnection();
            String sql = "Update Chucvu set TenCV = ? where MaCV = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cv.getTenCV());
            ps.setString(2, cv.getMaCV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteChucVu(String MaCV) throws SQLException, SQLServerException {
        try {
            Connection connection = mssql.getConnection();
            String sql = "delete from chucvu where MaCV = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, MaCV);
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
