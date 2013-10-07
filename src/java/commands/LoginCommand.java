/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author hsty
 */
public class LoginCommand extends TargetCommand {

    public LoginCommand(String target, String title) {
        super(target, title);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("login: " + username);
        if(Factory.getInstance().checkUserLogin(username, password))
        {
            System.out.println("login: " + username);
            request.getSession().setAttribute("username", username);
            
            String lastCommand = (String) request.getSession()
                                                 .getAttribute("lastcommand");
            if(lastCommand != null)
            {
                Command command = Factory.getInstance().getCommand(lastCommand);
                String path = command.execute(request);
                return path;
            }
            return super.execute(request);
            
        }
        request.setAttribute("error", "Error: wrong username or password");
        return "/login.jsp";
    }
    
    
}
