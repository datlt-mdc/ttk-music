package datlt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE161707 Le Thanh Dat
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TTK music";
            Connection con = DriverManager.getConnection(url, "sa", "1");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
