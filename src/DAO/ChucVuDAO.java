/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChucVuDTO;
import java.sql.Connection;
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
    
    public void docMaCN(String temp){
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

}
