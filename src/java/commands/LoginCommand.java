/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import servlets.DummyBankController;
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
        
        if(DummyBankController.getInstance().checkUserLogin(username, password,request.getParameter("command")))
        {
           
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("customer", DummyBankController.getInstance().getCustomer(username));
            
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
