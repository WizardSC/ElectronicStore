/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaSanXuatDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class NhaSanXuatDAO {

    private MSSQLConnect mssql = new MSSQLConnect();
    String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        mssql.docMaCN(temp);
    }

    public ArrayList<NhaSanXuatDTO> getListNSX() {
        try {
            ArrayList<NhaSanXuatDTO> dsnsx = new ArrayList<>();
            String sql = "select * from nhasanxuat";
            ResultSet rs = mssql.executeQuery(sql);
            while (rs.next()) {
                NhaSanXuatDTO nsx = new NhaSanXuatDTO(
                        rs.getString("MaNSX"),
                        rs.getString("TenNSX"));
                dsnsx.add(nsx);
            }
            return dsnsx;
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
