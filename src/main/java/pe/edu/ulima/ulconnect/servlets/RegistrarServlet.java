/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.ulima.ulconnect.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import pe.edu.ulima.ulconnect.model.CarreraMongoDAO;
import pe.edu.ulima.ulconnect.model.PerfilMongoDAO;
import pe.edu.ulima.ulconnect.model.UsuarioMongoDAO;
import pe.edu.ulima.ulconnect.model.beans.Carrera;
import pe.edu.ulima.ulconnect.model.beans.Perfil;
import pe.edu.ulima.ulconnect.model.beans.Usuario;

/**
 *
 * @author hquintana
 */
public class RegistrarServlet extends HttpServlet {


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
        String codigo = request.getParameter("txt_codigo");
        String password = request.getParameter("txt_password");
        String nombre = request.getParameter("txt_nombre");
        String sel_perfiles = request.getParameter("sel_perfiles");
        String sel_carreras = request.getParameter("sel_carreras");
        
        Perfil perfil = 
                PerfilMongoDAO.getInstance().get(new ObjectId(sel_perfiles));
        Carrera carrera = 
                CarreraMongoDAO.getInstance().get(new ObjectId(sel_carreras));
        
        Usuario usuario = new Usuario(
                codigo,
                nombre,
                password,
                perfil,
                carrera
        );
        
        UsuarioMongoDAO.getInstance().create(usuario);
        
        response.sendRedirect("index.html");
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
