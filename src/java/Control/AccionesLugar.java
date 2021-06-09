/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Lugar;
import java.sql.*;
import java.util.*;
import Servlet.filtrarLugares;

public class AccionesLugar {
    
    public static int registrarLugar(Lugar e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
                    
            String q = "insert into MLugar(tel_lug, nom_lug, cal_lug, st_lug, id_ad, id_al, id_col, id_cp, id_tip)"
                    + "values(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, e.getTel_lug());
            ps.setString(2, e.getNom_lug());
            ps.setInt(3, e.getCal_lug());
            ps.setString(4, e.getSt_lug());
            ps.setInt(5, e.getId_ad());
            ps.setInt(6, e.getId_al());
            ps.setInt(7, e.getId_col());
            ps.setInt(8, e.getId_cp());
            ps.setInt(9, e.getId_tip());
         
            estatus = ps.executeUpdate();
            
           
                    
            System.out.println("Se a registrado lugar correctamente.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar el lugar.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static int actualizarLugar(Lugar e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update MLugar set nom_lug = ?, st_lugar = ?,"
                    + "com_lug = ?, tel_lug = ?, cal_lug = ?, id_ad = ?, id_al = ?, id_col = ?, is_cp = ?"
                    + " where id_lug = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getNom_lug());
            ps.setString(2, e.getSt_lug());
            ps.setString(3, e.getCom_lug());
            ps.setInt(4, e.getTel_lug());
            ps.setInt(5, e.getCal_lug());
            ps.setInt(6, e.getId_ad());
            ps.setInt(7, e.getId_al());
            ps.setInt(8, e.getId_col());
            ps.setInt(9, e.getId_cp());
            ps.setInt(10, e.getId_lug());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion del lugar exitosa.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el lugar.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static int borrarLugar(int id_lug){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from MLugar where id_lug = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id_lug);
            
            estatus = ps.executeUpdate();
            System.out.println("Lugar eliminado.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al borrar el lugar.");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static Lugar buscarLugarById(int id_lug){
        Lugar e = new Lugar();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from MLugar where id_lug = ?";
            /*Quien haga la base, aqui es donde se hace la consulta con nuestra base*/
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id_lug);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId_lug(rs.getInt(1));
                e.setNom_lug(rs.getString(2));
                e.setSt_lug(rs.getString(3));
                e.setCom_lug(rs.getString(4));
                e.setTel_lug(rs.getInt(5));
                e.setCal_lug(rs.getInt(6));
                e.setId_ad(rs.getInt(7));
                e.setId_al(rs.getInt(8));
                e.setId_col(rs.getInt(9));
                e.setId_cp(rs.getInt(10));
                
            }
            System.out.println("Lugar no encontrado encontrado.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al buscar el lugar.");
            System.out.println(ed.getMessage());
        
        }
        return e;
        
    }
    
    public static List<Lugar> getAllLugar(){
        List<Lugar> lista = new ArrayList<Lugar>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from mlugar";
            /* aquí hay otra cuestion de la base*/
            PreparedStatement ps = con.prepareStatement(q);

            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
            System.out.println("Lugar encontrado.");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al buscar los lugares");
            System.out.println(ed.getMessage());
        
        }
        return lista;
        
    }
    
    /*Este es le método que hicimos, lo que queremos es que de la variable 
    id_tip obtenida en el servlet se compruebe que si es igual a cierto valor pase una u otra consulta de MySQL
    El problema es que no sabemos como usar esa variable en este método*/
   
    public static List<Lugar> getFiltroLugar(){
        List<Lugar> lista = new ArrayList<Lugar>();
         
        try{
            Connection con = Conexion.getConnection();
            filtrarLugares lugares = new filtrarLugares();
            System.out.println("este es la opción del tipo: " +filtrarLugares.id_tip);
            System.out.println("este es la opción de la alcaldia " +filtrarLugares.id_alc);
            if(filtrarLugares.id_tip == 0){
                if(filtrarLugares.id_alc == 0){
                    String q = "select * from MLugar";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }
            }else if(filtrarLugares.id_tip == 1){
                if(filtrarLugares.id_alc == 0){
                    String q = "select * from MLugar where id_tip = 1";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 1){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 1";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 2){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 2";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 3){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 3";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 4){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 4";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 5){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 5";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 6){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 6";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 7){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 7";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 8){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 8";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 9){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 9";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 10){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 10";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 11){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 11";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 12){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 12";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 13){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 13";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 14){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 14";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 15){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 15";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 16){
                    String q = "select * from MLugar where id_tip = 1 and id_al = 16";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }
                
            
            System.out.println("Lugar encontrado 1.");
            con.close();
            
            /*termina primer filtro*/
            }else if(filtrarLugares.id_tip == 2){
                if(filtrarLugares.id_alc == 0){
                    String q = "select * from MLugar where id_tip= 3";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 1){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 1";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 2){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 2";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 3){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 3";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 4){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 4";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 5){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 5";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 6){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 6";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 7){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 7";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 8){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 8";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 9){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 9";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 10){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 10";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 11){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 11";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 12){
                    String q = "select * from MLugar where id_tip= 3 and al = 12";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 13){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 13";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 14){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 14";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 15){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 15";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if (filtrarLugares.id_alc == 16){
                    String q = "select * from MLugar where id_tip= 3 and id_al = 16";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }
                
            System.out.println("Lugar encontrado 2.");
            con.close();
            
            
            }else if(filtrarLugares.id_tip == 3){
                if(filtrarLugares.id_alc == 0){
                    String q = "select * from MLugar where id_tip = 2";
                PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 1){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 1";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 2){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 2";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 3){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 3";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 4){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 4";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 5){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 5";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 6){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 6";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 7){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 7";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 8){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 8";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 9){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 9";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 10){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 10";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 11){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 11";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 12){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 12";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 13){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 13";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 14){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 14";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 15){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 15";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }else if(filtrarLugares.id_alc == 16){
                    String q = "select * from MLugar where id_tip = 2 and id_al = 16";
                    PreparedStatement ps = con.prepareStatement(q);
                /* aquí hay otra cuestion de la base*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lugar e = new Lugar();
                e.setId_lug(rs.getInt(1));
                e.setTel_lug((int) rs.getLong(2));
                e.setNom_lug(rs.getString(3));
                e.setCal_lug(rs.getInt(4));
                e.setSt_lug(rs.getString(5));
                e.setId_ad(rs.getInt(6));
                e.setId_al(rs.getInt(7));
                e.setId_col(rs.getInt(8));
                e.setId_cp(rs.getInt(9));
                e.setId_tip(rs.getInt(10));
                lista.add(e);
            }
                }
                
            System.out.println("Lugar encontrado 3.");
            con.close();
            }    
        }catch(Exception ed){
            System.out.println("Error al buscar los lugares");
            System.out.println(ed.getMessage());
        
        }
        return lista;
        
    }

   
}
