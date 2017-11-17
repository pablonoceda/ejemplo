/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectomercadolibre.prototipo1.controlers;

import com.google.gson.Gson;
import com.proyectomercadolibre.prototipo1.model.Model;
import com.proyectomercadolibre.prototipo1.util.AjaxResult;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.conn.HttpHostConnectException;

/**
 *
 * @author NOCEDA
 */
@WebServlet(name = "AjaxServlet",
        urlPatterns = {
            "/ajax/getService"})
@MultipartConfig
public class AjaxServlet extends HttpServlet {
    @EJB
    private Model model;
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
        try {
        if (request.getServletPath().equals("/ajax/getService")) {
                getService(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet ControllerServlet</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
                finally {
                    out.close();
                }
            }
        }
        catch (org.apache.http.conn.ConnectTimeoutException ex) {
            AjaxResult result = new AjaxResult();
            result.setErrorCode(1);
            result.setMessage(ex.getMessage());
            String json = new Gson().toJson(result);
            response.setContentType("application/json");
            response.getWriter().write(json);
            return;
        }
        catch (HttpHostConnectException ex) {
            AjaxResult result = new AjaxResult();
            result.setErrorCode(1);
            result.setMessage(ex.getMessage());
            String json = new Gson().toJson(result);
            response.setContentType("application/json");
            response.getWriter().write(json);
            return;
        }
        catch (java.net.SocketTimeoutException ex) {
            AjaxResult result = new AjaxResult();
            result.setErrorCode(1);
            result.setMessage(ex.getMessage());
            String json = new Gson().toJson(result);
            response.setContentType("application/json");
            response.getWriter().write(json);
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
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

    private void getService(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
