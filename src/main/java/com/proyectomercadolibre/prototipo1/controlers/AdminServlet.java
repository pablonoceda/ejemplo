/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectomercadolibre.prototipo1.controlers;

import com.proyectomercadolibre.prototipo1.adapter.implement.RestMercadoAdapter;
import com.proyectomercadolibre.prototipo1.model.Model;
import com.proyectomercadolibre.prototipo1.util.ConfigReadWrite;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.conn.HttpHostConnectException;

/**
 *
 * @author NOCEDA
 */
@WebServlet(name = "AdminServlet", urlPatterns = {
    "/index",
    "/demo",
    "/checkSettings",
    "/settings"
})

public class AdminServlet extends HttpServlet {

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
            if (request.getServletPath().equals("/index")) {
                index(request, response);
            } else if (request.getServletPath().equals("/demo")) {
                demo(request, response);
            } else if (request.getServletPath().equals("/checkSettings")) {
                checkSettings(request, response);
            } else if (request.getServletPath().equals("/settings")) {
                settings(request, response);
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
                } finally {
                    out.close();
                }
            }
        } catch (org.apache.http.conn.ConnectTimeoutException ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        } catch (HttpHostConnectException ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        } catch (java.net.SocketTimeoutException ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        } catch (Exception ex) {
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

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void settings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConfigReadWrite properties = new ConfigReadWrite();
        request.setAttribute("accessControl", properties.getPropValues("accessControl"));
        request.setAttribute("demo", properties.getPropValues("demo"));
        request.setAttribute("modifySettings", properties.getPropValues("modifySettings"));
        request.getRequestDispatcher("settings.jsp").forward(request, response);
    }

    private void checkSettings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestMercadoAdapter sep = new RestMercadoAdapter();
        ConfigReadWrite properties = new ConfigReadWrite();

        String databaseIp = request.getParameter("databaseIp");
        String databasePort = request.getParameter("databasePort");

        boolean demo = request.getParameter("demo") != null;
        boolean modifySettings = request.getParameter("modifySettings") != null;
        boolean accessControl = request.getParameter("accessControl") != null;

        if (accessControl == true) {
            properties.setPropValues("accessControl", "enabled");
        } else {
            properties.setPropValues("accessControl", "disabled");
        }
        if (demo == true) {
            properties.setPropValues("demo", "enabled");
        } else {
            properties.setPropValues("demo", "disabled");
        }

        if (modifySettings == true) {
            properties.setPropValues("modifySettings", "enabled");
        } else {
            properties.setPropValues("modifySettings", "disabled");
        }

        properties.setPropValues("IP", databaseIp);
        properties.setPropValues("Port", databasePort);

        response.sendRedirect("/Prototipo1/index");
    }

  
    private void demo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("demo.jsp").forward(request, response);
    }

}
