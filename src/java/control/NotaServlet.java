/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import db.Logica;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CesarPC
 */
@WebServlet(name = "NotaServlet", urlPatterns = {"/NotaServlet"})
public class NotaServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NotaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       String accion = request.getParameter("accion");
        if(accion.equals("ingresar"))
        {
            String nombre = request.getParameter("nombre");
            String tag = request.getParameter("tag");
            String tipo = request.getParameter("tipo");
            String contenido = request.getParameter("contenido");
            String archivosound = request.getParameter("archivosound");
            String horafecha = request.getParameter("horafecha");
            String latitud = request.getParameter("latitud");
            float lat = Float.parseFloat(latitud);
            String longitud = request.getParameter("longitud");
            float longi = Float.parseFloat(longitud);
            String creador = request.getParameter("creador");
            Logica l = new Logica();
            int i =l.ingresarNota(nombre, tag, tipo, contenido, archivosound, horafecha, lat, longi, creador);
                if(i>0){
                    PrintWriter writer= response.getWriter();
                    writer.println("IngresarOK");
                }else{
                    PrintWriter writer= response.getWriter();
                    writer.println("Error en ingresar nota");
                }
        }
        else if (accion.equals("eliminar")){
            String nombre = request.getParameter("nombre");
            String creador = request.getParameter("creador");
            
            Logica l = new Logica();
            int i =l.EliminarNota(nombre, creador);
            if(i>0){     
                PrintWriter writer= response.getWriter();
                writer.println("EliminarOK");
            }
            else{
                 PrintWriter writer= response.getWriter();
                 writer.println("Error en eliminar nota");
            }
         
        }
        else if (accion.equals("editar")){
            String antiguo = request.getParameter("antiguo");
            String nuevo = request.getParameter("nuevo");
            
            Logica l = new Logica();
            int i =l.editarNota(nuevo, antiguo);
            if(i>0){     
                PrintWriter writer= response.getWriter();
                writer.println("EditarOK");
            }
            else{
                 PrintWriter writer= response.getWriter();
                 writer.println("Error en editar nota");
            }
         
        }
        
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
