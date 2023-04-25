/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Phuc Toan
 */
public class NhaSanXuatDAO {
    private MSSQLConnect mssql = new MSSQLConnect();
    String MaCN;
    public void docMaCN(String temp){
        this.MaCN = temp;
        mssql.docMaCN(temp);
    }
    
}
