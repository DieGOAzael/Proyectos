/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.AccionesLugar;
import Modelo.Lugar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aza06
 */
public class modificarLugar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int id_lug = Integer.parseInt(request.getParameter("id_lug2"));
            String nom_lug, st_lug, tel_lug;
            int id_ad, id_al, id_col, id_cp, id_tip, cal_lug;
    
            tel_lug = request.getParameter("tel_lug2");
            nom_lug = request.getParameter("nom_lug2");
            cal_lug = Integer.parseInt(request.getParameter("cal_lug2"));
            st_lug = request.getParameter("st_lug2");
            id_ad = Integer.parseInt(request.getParameter("id_ad2"));
            id_al = Integer.parseInt(request.getParameter("id_al2"));
            id_col = Integer.parseInt(request.getParameter("id_col2"));
            id_cp = Integer.parseInt(request.getParameter("id_cp2"));
            id_tip = Integer.parseInt(request.getParameter("id_tip2"));
            
            System.out.println("Hola1");
            
            Lugar e = new Lugar();
            e.setId_lug(id_lug);
            e.setTel_lug(tel_lug);
            e.setNom_lug(nom_lug);
            e.setCal_lug(cal_lug);
            e.setSt_lug(st_lug);
            e.setId_ad(id_ad);
            e.setId_al(id_al);
            e.setId_col(id_col);
            e.setId_cp(id_cp);
            e.setId_tip(id_tip);
            
            int estatus = AccionesLugar.actualizarLugar(e);
            
            if(estatus > 0){
                response.sendRedirect("registroLugar.jsp");
                /* cosas de diseño */
            }else{
                response.sendRedirect("error.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
