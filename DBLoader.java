/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabboking1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBLoader {

    static Connection conn;

    public static ResultSet executeStatement(String sqlquery) throws Exception {
        /////  ##CODE //////
        System.out.println(""+sqlquery);
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver loaded successfully");
        
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cabbooking", "root", "Disha@12");
            System.out.println("connection built");
        }
        
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("statement created");

        ResultSet rs = stmt.executeQuery(sqlquery);
        System.out.println("Resultset created");

        return rs;
        //////////  ##Code Ends Here ////////
    }
    
    public static void main(String[] args) {
        try {
            ResultSet rs = DBLoader.executeStatement("select * from admin");
        } catch (Exception ex) {
            Logger.getLogger(DBLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
