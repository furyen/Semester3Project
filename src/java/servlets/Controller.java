/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
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

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       
        String username = (String) session.getAttribute("username");

        System.out.println("session: " + username);

        String commandString = request.getParameter("command");


        if (!"employeeLogin".equals(commandString)&&!"customerLogin".equals(commandString)) {
            session.setAttribute("lastcommand", commandString);
        }
        
        request.setAttribute("style", "h1{color:blue;}");
        request.setAttribute("stylsheetfile", "my.css");
 String path;
        if(Factory.getInstance().isMobileDevice(request)){
     path= "mobile/mobileMainNA.jsp";
 }else{
         path = "/login.jsp";
        }
        if ((username != null /* && notTimedOut(session)*/)
                || "employeeLogin".equals(commandString) || "customerLogin".equals(commandString) || "loginmobile".equals(commandString)) {

            Command command = Factory.getInstance().getCommand1(commandString, request);
            path = command.execute(request);
            
        }
        if (!"logout_command".equals(commandString)) {
            if (username != null && notTimedOut(session) == false) {
                request.setAttribute("error", "Session timeout");
            }
        }

        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
