/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBCConnect.Connect;

import JDBCConnect.Config.IJDBCConfig;

import java.sql.*;

/**
 *
 * @author FanciGoD
 */
public class JDBCConnect implements IJDBCConfig {

    public static Connection Connect() {
        Connection con = null;

        String ConnectUrl = "jdbc:mysql://" + IJDBCConfig.hostname
                + ":" + IJDBCConfig.port + "/"
                + IJDBCConfig.dbName;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException ex) {
            System.err.println("wrong driver");
            return con;
        }
        System.out.println("connect driver successfully");

        try {
            con = DriverManager.getConnection(ConnectUrl, IJDBCConfig.username, IJDBCConfig.password);
        } catch (SQLException ex) {
            System.err.println("wrong url");
            return con;
        }
        System.out.println("connect to DB successfully");
        return con;

    }

    public static void CloseConnect(Connection c){
        if(c != null){
            try {
                c.close();
            } catch (SQLException ex) {
               System.err.println("can't close");
            }
        }System.out.println("close successfully");
    }
    
    public static void main(String[] args) {

        System.err.println(JDBCConnect.Connect());
    }

}
