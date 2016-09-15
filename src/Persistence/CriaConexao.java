/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;


import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class CriaConexao {
    private static Connection con; 
    
    public static void CriaConexao() throws SQLException, ClassNotFoundException{
     
        try{
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/central","root","");
        }
        catch(ClassNotFoundException ex){
         System.out.println("classe não encontrada, adicione o drive nas bibliotecas");
         Logger.getLogger(CriaConexao.class.getName()).log(Level.SEVERE,null,ex);
        
        }catch(SQLException e){
            System.out.println(e);      
            throw new RuntimeException(e);
        }
    
    }
    
    public Connection getCon(){
      return con;
    }
}
