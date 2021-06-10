/*
DataJockey.
 */
package Modelo;

import Control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aza06
 */
public class Usuario {
    private int id_usu, privilegio_usuario;
    private String nom_usu, ema_usu, con_usu;
    
    public Usuario() {

}
    
    
    
    //vamos a crear un metodo para verificar al usuario y que
    //nos devuelva o redireccione si privilegio == 1 -> cliente, 
    //si privilegio == 0 -> admin, si privilegio == 2 ->trabajor
    
    //iniciar sesion
    public Usuario verificarUsuario(String user, String pass){
        Usuario u = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from MUsuario where nom_usu = ? AND con_usu = ?";
            
            ps = con.prepareStatement(q);
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                u = new Usuario();
                u.setId_usu(rs.getInt("id_usu"));
                u.setNom_usu(rs.getString("nom_usu"));
                u.setEma_usu(rs.getString("ema_usu"));
                u.setCon_usu(rs.getString("con_usu"));
                u.setPrivilegio_usuario(rs.getInt("privilegio_usuario"));
                break;
                
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar el usuario");
            System.out.println(sq.getMessage());
            u = null;
        
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(Exception e){
                System.out.println("Error cuando no encuentra la clase");
                System.out.println(e.getMessage());
            
            }
        }
        return u;
    }
    

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getEma_usu() {
        return ema_usu;
    }

    public void setEma_usu(String ema_usu) {
        this.ema_usu = ema_usu;
    }

    public String getCon_usu() {
        return con_usu;
    }

    public void setCon_usu(String con_usu) {
        this.con_usu = con_usu;
    }
    
    public int getPrivilegio_usuario() {
        return privilegio_usuario;
    }

    public void setPrivilegio_usuario(int privilegio_usuario) {
        this.privilegio_usuario = privilegio_usuario;
    }
    
}




