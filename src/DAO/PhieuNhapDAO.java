/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class PhieuNhapDAO {

    private MSSQLConnect mssql = new MSSQLConnect();
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        mssql.docMaCN(MaCN);
    }
    public ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        try {
            ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
            String sql = "Select * from phieunhap";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                PhieuNhapDTO pn = new PhieuNhapDTO(
                        rs.getString("MaPN"),
                        rs.getDate("NgapLap"),
                        rs.getInt("TongTien"),
                        rs.getString("MaNV"),
                        rs.getString("MaNCC")
                );
                dspn.add(pn);
            }
            return dspn;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
    
    public ArrayList<PhieuNhapDTO> getListPhieuNhap3CN(){
        try {
            ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
            String sql = "exec sp_SelectAllPN";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                PhieuNhapDTO pn = new PhieuNhapDTO(
                        rs.getString("MaPN"),
                        rs.getDate("NgapLap"),
                        rs.getInt("TongTien"),
                        rs.getString("MaNV"),
                        rs.getString("MaNCC")
                );
                dspn.add(pn);

            }
            return dspn;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mssql.Disconnect();
        }
        return null;
    }
}
