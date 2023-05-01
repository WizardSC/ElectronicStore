/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTPhieuNhapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class CTPhieuNhapDAO {

    private MSSQLConnect mssql = new MSSQLConnect();
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(MaCN);
    }

    public ArrayList<CTPhieuNhapDTO> getListCTPN() {
        try {
            ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
            String sql = "Select * from ctphieunhap";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                CTPhieuNhapDTO ctpn = new CTPhieuNhapDTO(
                        rs.getString("MaPN"),
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getInt("ThanhTien")
                );
                dsctpn.add(ctpn);
            }
            return dsctpn;
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
}
