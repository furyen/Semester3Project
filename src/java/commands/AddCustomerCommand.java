/*
 */

package commands;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lars Mortensen
 */
public class AddCustomerCommand extends TargetCommand {

  public AddCustomerCommand(String target) {
    super(target);
  }

  @Override
  public String execute(HttpServletRequest request) {
    String firstname = request.getParameter("fisrtName");
    String lastname = request.getParameter("lastName");
    String mail = request.getParameter("mail");
    
    
   servlets.Factory.getBankController().addCustomer(new model.Customer(firstname, lastname, mail));
   
    return super.execute(request); //To change body of generated methods, choose Tools | Templates.
  }
  

}
