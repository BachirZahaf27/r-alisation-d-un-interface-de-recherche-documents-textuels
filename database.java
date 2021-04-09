/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auteur_finder;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class database {
    /**
     * @param args the command line arguments
     */
    
        Connection conn=null;//connection to database
        
        public static Connection java_db(){
        
        try{
             Class.forName("org.sqlite.JDBC");
            Connection conn =DriverManager.getConnection("jdbc:sqlite:auteur.db");
           //JOptionPane.showMessageDialog(null, "Connection to database is successful");
            return conn;
           
            
        }catch (HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    
}
