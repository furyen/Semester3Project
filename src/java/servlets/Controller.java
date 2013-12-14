/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.Command;
import commands.LogoutCommand;
import commands.ShowLoginCommand;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hsty
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    static final long TIME_OUT = 5000;
    private final int PORT_NON_SSL = 8080;
    private final int PORT_SSL = 8181;

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
        
      
        String cmdStr = request.getParameter("command");
        Command command = Factory.getInstance().getCommand(cmdStr, request);
        String path = command.execute(request);

        if (command instanceof ShowLoginCommand && !request.isSecure()) {
            String SSL = "https://" + request.getServerName() + ":" + PORT_SSL + request.getRequestURI() + "?command=showlogin";
            response.sendRedirect(SSL);
        } else if (command instanceof LogoutCommand) {
            String nonSSL = "http://" + request.getServerName() + ":" + PORT_NON_SSL + request.getRequestURI();
            response.sendRedirect(nonSSL);
        } else {
            request.getRequestDispatcher(path).forward(request, response);
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

    //not used currently
    private boolean notTimedOut(HttpSession session) {
        long lastTime = session.getLastAccessedTime();
        long currentTime = new Date().getTime();
        long diff = currentTime - lastTime;
        if (diff < TIME_OUT) {
            return true;
        }
        return false;
    }
}
