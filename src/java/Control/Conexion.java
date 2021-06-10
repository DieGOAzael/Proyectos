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
            url = "jdbc:mysql://localhost/Salud_Maps";
            userName = "root";
            password= "Boby15_9634";
            
            return DriverManager.getConnection(url, userName, password);
        
        }catch(SQLException sq){
            System.out.println("Error al conectar con la BD de Salud Maps");
            System.out.println(sq.getMessage());
        
        }catch(Exception e){
            System.out.println("No se encuentra la clase D:");
            System.out.println(e.getMessage());
        }
        return null;
    }
    /*este parte es solo para comprobar que conexion sí se logra*/
    /*
    public static void main(String[] args){
        Conexion con = new Conexion();
    }
    */
    
}
