/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author hsty
 */
public class LogoutCommand extends TargetCommand {

    public LogoutCommand(String target,SecurityRole role) {
        super(target,role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        //request.getSession().removeAttribute("username");
        request.getSession().invalidate();
        return super.execute(request);
    }
    
    
}
