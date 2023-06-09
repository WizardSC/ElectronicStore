/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiNhanhDTO;

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
public class ChiNhanhDAO {

    private MSSQLConnect msSQL = new MSSQLConnect();
    private ArrayList<ChiNhanhDTO> dscn = new ArrayList<>();

//    private Connection connection = msSQL.getConnection();
    private String MaCN;

    public void docMaCN(String temp) {
        this.MaCN = temp;
        msSQL.docMaCN(MaCN);
        System.out.println("ChiNhanhDAO: " + MaCN);

    }

    public ArrayList<ChiNhanhDTO> getListChiNhanh() {
        try {

            ArrayList<ChiNhanhDTO> dscn = new ArrayList<>();
            String sql = "select * from chinhanh";

            ResultSet rs = msSQL.executeQuery(sql);
            while (rs.next()) {
                ChiNhanhDTO cn = new ChiNhanhDTO(
                        rs.getString("MaCN"),
                        rs.getString("TenCN"),
                        rs.getString("DiaChi")
                );
                dscn.add(cn);

            }
            return dscn;
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            msSQL.Disconnect();
        }
        return null;
    }

    public ArrayList<ChiNhanhDTO> getList3ChiNhanh() {
        try {
            ArrayList<ChiNhanhDTO> dscn = new ArrayList<>();
            String sql = "exec sp_SelectAllCN";

            ResultSet rs = msSQL.executeQuery(sql);
            while (rs.next()) {
                ChiNhanhDTO cn = new ChiNhanhDTO(
                        rs.getString("MaCN"),
                        rs.getString("TenCN"),
                        rs.getString("DiaChi")
                );
                dscn.add(cn);
            }
            return dscn;
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            msSQL.Disconnect();
        }
        return null;

    }
}
