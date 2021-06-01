/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author aza06
 */
public class Administrador {
    
    private int id_ad;
    private String ema_ad, con_ad;
    
    public Administrador() {

}

    public int getId_ad() {
        return id_ad;
    }

    public void setId_ad(int id_ad) {
        this.id_ad = id_ad;
    }

    public String getEma_ad() {
        return ema_ad;
    }

    public void setEma_ad(String ema_ad) {
        this.ema_ad = ema_ad;
    }

    public String getCon_ad() {
        return con_ad;
    }

    public void setCon_ad(String con_ad) {
        this.con_ad = con_ad;
    }
    
}
