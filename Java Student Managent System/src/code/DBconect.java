/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;



public class DBconect {
    public static Connection connect(){
    
        Connection con=null;
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1234","root","");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBconect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return con; 
    
    }
    
    
    
}
