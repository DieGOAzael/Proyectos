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
            url = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_80d8318be6377a9";
            userName = "b0180b357a408c";
            password = "5fb85820";
            
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
