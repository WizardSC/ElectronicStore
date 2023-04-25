/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class MSSQLConnect {

    String database = "ElectronicStore";
    String user = "sa";
    String password = "toan123";
    String url = "jdbc:sqlserver://LAPTOP-AEI9M0MI\\WIZARDSC;databasename=ElectronicStore";
    String url1 = "jdbc:sqlserver://LAPTOP-AEI9M0MI\\WIZARDSC1;databasename=ElectronicStore";
    String url2 = "jdbc:sqlserver://LAPTOP-AEI9M0MI\\WIZARDSC2;databasename=ElectronicStore";
    String url3 = "jdbc:sqlserver://LAPTOP-AEI9M0MI\\WIZARDSC3;databasename=ElectronicStore";
    private String MaCN;
//"jdbc:sqlserver://LAPTOP-AEI9M0MI\\WIZARDSC;databasename=ElectronicStore;user=sa;password=toan123"    
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement ps = null;

    public MSSQLConnect(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;

    }

    public MSSQLConnect() {

    }

    public void docMaCN(String temp) {
        this.MaCN = temp;
        Connect(MaCN);
        System.out.println("Thu tu 4");

    }

    public void Connect(String temp) {

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            if (temp.equals("null")) {
                connection = DriverManager.getConnection(url, user, password);
               
               
            }
            if (temp.equals("CN001")) {
                connection = DriverManager.getConnection(url1, user, password);
                

            }
            if (temp.equals("CN002")) {
                connection = DriverManager.getConnection(url2, user, password);
          
            }
            if (temp.equals("CN003")) {
                connection = DriverManager.getConnection(url3, user, password);


            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MSSQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MSSQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MSSQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MSSQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Connect(MaCN);
//            System.out.println("query" +MaCN);
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MSSQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Connection getConnection() {
        Connect(MaCN);
//        System.out.println("query" +MaCN);
        return connection;
    }

}
