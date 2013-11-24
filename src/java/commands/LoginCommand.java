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
        String loginType = request.getParameter("command");
        System.out.println("login: " + username);
        Boolean success;

        switch (loginType) {
            case "emplogin":
                success = Factory.getInstance().getBankController().empLogin(username, password);
                break;
            case "custlogin":
                success = Factory.getInstance().getBankController().custLogin(username, password);
                break;
            default:
                throw new AssertionError();
        }
        if (success) {

            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("customer", Factory.getInstance().getBankController().getCustomer(username));
            String lastCommand = (String) request.getSession()
                    .getAttribute("lastcommand");
            if (lastCommand != null) {
                Command command = Factory.getInstance().getCommand(lastCommand);
                String path = command.execute(request);
                return path;
            }
            return super.execute(request);

        } else {
            request.setAttribute("error", "Error: wrong username or password");
            return "/login.jsp";
        }
    }
}
