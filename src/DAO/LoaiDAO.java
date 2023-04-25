/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoaiDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class LoaiDAO {

    private MSSQLConnect mssql = new MSSQLConnect();
   
    String MaCN;
    
    public void docMaCN(String temp){
        this.MaCN = "CN003";
        mssql.docMaCN(MaCN);
        System.out.println("Thu tu 3");
    }

    public ArrayList<LoaiDTO> getListLoai() {
        try {
            ArrayList<LoaiDTO> dsloai = new ArrayList<>();
            String sql = "SELECT * FROM loai";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
                LoaiDTO loai = new LoaiDTO(
                        rs.getString("MaLoai"),
                        rs.getString("TenLoai")
                );
                dsloai.add(loai);
            }
            return dsloai;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
