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
      System.out.println("xxxxxxxxxxx");
    String lastname = request.getParameter("lastName");
    String mail = request.getParameter("mail");
    servlets.Factory.getBankController().addCustomer(new model.Customer(firstname, lastname, mail));
    String created = "Customer Created";
    request.setAttribute("created", created);
    Command command = servlets.Factory.getInstance().getCommand("listcustomer");
                String path = command.execute(request);
                return path;
   // return super.execute(request); //To change body of generated methods, choose Tools | Templates.
  }
  

}
