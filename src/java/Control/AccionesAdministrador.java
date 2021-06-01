/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Administrador;
import java.sql.*;
import java.util.*;

public class AccionesAdministrador {
    
     public static int registrarAdministrador(Administrador e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "insert into MAdministrador(em_ad, con_ad) "
                    + "values(?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getEma_ad());
            ps.setString(2, e.getCon_ad());
            estatus = ps.executeUpdate();
            System.out.println("Administrador registrado.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registrar administrador.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static int actualizarAdministrador(Administrador e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update MAdministrador set ema_ad = ?, con_ad = ?,"
                    + " where id_ad = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getEma_ad());
            ps.setString(2, e.getCon_ad());
            ps.setInt(3, e.getId_ad());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion de admin completa.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar al administrador.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
}
