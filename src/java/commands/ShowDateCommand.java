/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hsty
 */
public class ShowDateCommand extends TargetCommand {

    public ShowDateCommand(String target, String title) {
        super(target, title);
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("date", new Date());
        return super.execute(request); 
    }
    
    
    
}
