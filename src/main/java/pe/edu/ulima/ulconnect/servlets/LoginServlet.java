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
import pe.edu.ulima.ulconnect.model.UsuarioMongoDAO;
import pe.edu.ulima.ulconnect.model.beans.Usuario;

/**
 *
 * @author hquintana
 */
public class LoginServlet extends HttpServlet {




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
        System.out.println("Entra aca");
        String codigo = request.getParameter("txt_codigo");
        String password = request.getParameter("txt_password");
        
        Usuario usuario = UsuarioMongoDAO.getInstance().get(codigo, password);
        if (usuario == null){
            // Login incorrect
            response.sendRedirect("index.html");
        }else{
            // Login correcto
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("MostrarMuroServlet");
        }
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
