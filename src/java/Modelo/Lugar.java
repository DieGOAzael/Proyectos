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
public class Lugar {
    private int id_lug, id_ad, id_al, id_col, id_cp, id_tip, tel_lug, cal_lug;
    private String nom_lug, st_lug, com_lug;
    
    public Lugar(){

}
    public int getId_tip(){
        return id_tip;
    }
    
    public void setId_tip(int id_tip){
        this.id_tip = id_tip;
    }
    
    public int getId_lug() {
        return id_lug;
    }

    public void setId_lug(int id_lug) {
        this.id_lug = id_lug;
    }

    public int getId_ad() {
        return id_ad;
    }

    public void setId_ad(int id_ad) {
        this.id_ad = id_ad;
    }

    public int getId_al() {
        return id_al;
    }

    public void setId_al(int id_al) {
        this.id_al = id_al;
    }

    public int getId_col() {
        return id_col;
    }

    public void setId_col(int id_col) {
        this.id_col = id_col;
    }

    public int getId_cp() {
        return id_cp;
    }

    public void setId_cp(int id_cp) {
        this.id_cp = id_cp;
    }

    public int getTel_lug() {
        return tel_lug;
    }

    public void setTel_lug(int tel_lug) {
        this.tel_lug = tel_lug;
    }

    public int getCal_lug() {
        return cal_lug;
    }

    public void setCal_lug(int cal_lug) {
        this.cal_lug = cal_lug;
    }

    public String getNom_lug() {
        return nom_lug;
    }

    public void setNom_lug(String nom_lug) {
        this.nom_lug = nom_lug;
    }

    public String getSt_lug() {
        return st_lug;
    }

    public void setSt_lug(String st_lug) {
        this.st_lug = st_lug;
    }

    public String getCom_lug() {
        return com_lug;
    }

    public void setCom_lug(String com_lug) {
        this.com_lug = com_lug;
    }

    
    
}
