/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class NhanVienDAO {
    private ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
    private MSSQLConnect mssql = new MSSQLConnect();
    private Connection connection = mssql.getConnection();
    
    
//    public ArrayList<NhanVienDTO> getListNhanVien(){
//        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
//        String sql = "SELECT * FROM nhanvien";
//        PreparedStatement ps = mssql.executeQuery(sql, sql)
//    }
}
