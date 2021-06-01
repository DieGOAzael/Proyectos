/*
DtataJockey.
 */
package Control;


import java.sql.*;

public class Conexion {
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url, userName, password;
            
            url = "jdbc:mysql://localhost/CarritoHelados4IV8";
            userName = "root";
            password= "n0m3l0";
            
            return DriverManager.getConnection(url, userName, password);
        
        }catch(SQLException sq){
            System.out.println("Error al conectar con la BD");
            System.out.println(sq.getMessage());
        
        }catch(Exception e){
            System.out.println("No encuentra la clase");
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
