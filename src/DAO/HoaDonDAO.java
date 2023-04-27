/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class HoaDonDAO {

    private MSSQLConnect mssql = new MSSQLConnect();
    private String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(MaCN);
    }

    public ArrayList<HoaDonDTO> getListMaHDTuTang() {
        try {
            ArrayList<HoaDonDTO> dshd = new ArrayList<>();
            String sql = "EXEC sp_SelectAllMaHD";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO(
                        rs.getString("MaHD")
                );
                dshd.add(hd);
            }
            return dshd;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDon3CN() {
        try {
            ArrayList<HoaDonDTO> dshd = new ArrayList<>();
            String sql = "EXEC sp_SelectAllHD";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO(
                        rs.getString("MaHD"),
                        rs.getDate("NgayLap"),
                        rs.getInt("TongTien"),
                        rs.getString("MaNV"),
                        rs.getString("MaKH"),
                        rs.getString("MaKM")
                );
                dshd.add(hd);
            }
            return dshd;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDon() {
        try {
            ArrayList<HoaDonDTO> dshd = new ArrayList<>();
            String sql = "SELECT * FROM hoadon";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO(
                        rs.getString("MaHD"),
                        rs.getDate("NgayLap"),
                        rs.getInt("TongTien"),
                        rs.getString("MaNV"),
                        rs.getString("MaKH"),
                        rs.getString("MaKM")
                );
                dshd.add(hd);
            }
            return dshd;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
}
