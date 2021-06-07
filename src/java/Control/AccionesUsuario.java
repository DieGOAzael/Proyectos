/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Usuario;
import java.sql.*;
import java.util.*;

public class AccionesUsuario {
    
    /**
     *
     * @param e
     * @return
     */
    public static int registrarUsuario(Usuario e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "insert into MUsuario(nom_usu, con_usu, ema_usu) "
                    + "values(?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getNom_usu());
            ps.setString(2, e.getCon_usu());
            ps.setString(3, e.getEma_usu());
            
            estatus = ps.executeUpdate();
            
            System.out.println("Se a registrado exitosamente.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar el usuario.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
        
    }
    
    
    public static int actualizarUsuario(Usuario e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update MUsuario set nom_usu = ?, con_usu = ?,"
                    + "ema_usu = ?"
                    + " where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getNom_usu());
            ps.setString(2, e.getCon_usu());
            ps.setString(3, e.getEma_usu());
            ps.setInt(4, e.getId_usu());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion del usuario exitosa.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el usuario.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static int borrarUsuario(int id_usu){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from MUsuario where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id_usu);
            
            estatus = ps.executeUpdate();
            System.out.println("Se ha elimando el usuario.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al borrar el usuario.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static Usuario buscarUsuarioById(int id_usu){
        Usuario e = new Usuario();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from MUsuario where id_usu = ?";
            /*Miguel o quien haga la base xd, aqui es donde se hace la consulta con nuestra base*/
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id_usu);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId_usu(rs.getInt(1));
                e.setNom_usu(rs.getString(2));
                e.setEma_usu(rs.getString(3));
                e.setCon_usu(rs.getString(4));
                
            }
            System.out.println("Usuario encontrado.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al buscar este usuario.");
            System.out.println(ed.getMessage());
        
        }
        return e;
        
    }
    
    public static List<Usuario> getAllUsuario(){
        List<Usuario> lista = new ArrayList<Usuario>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from MUsuario";
            /* aquí hay otra cuestion de la base*/
            PreparedStatement ps = con.prepareStatement(q);

            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario e = new Usuario();
                e.setId_usu(rs.getInt(1));
                e.setNom_usu(rs.getString(2));
                e.setCon_usu(rs.getString(3));
                e.setEma_usu(rs.getString(4));
                lista.add(e);
            }
            System.out.println("Se encontro al usuario.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al buscar a los usuarios");
            System.out.println(ed.getMessage());
        
        }
        return lista;
        
    }
    
    
    
}
