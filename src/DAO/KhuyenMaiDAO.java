/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class KhuyenMaiDAO {
    String MaCN;
    private MSSQLConnect mssql = new MSSQLConnect();
    public void docMaCN(String temp){
        this.MaCN = temp;
        mssql.docMaCN(temp);
    }
    public ArrayList<KhuyenMaiDTO> getListKhuyenMai(){
        try {
            ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
            String sql = "select * from khuyenmai";
            ResultSet rs = mssql.executeQuery(sql);
            while(rs.next()){
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
}
