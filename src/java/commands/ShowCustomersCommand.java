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
public class ShowCustomersCommand extends TargetCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(
                "customers", 
                Factory.getInstance().getCustomers());
        return super.execute(request);
    }

    public ShowCustomersCommand(String target) {
        super(target);
    }
    
}
