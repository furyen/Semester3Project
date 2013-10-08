
package commands;

import javax.servlet.http.HttpServletRequest;
import model.Customer;

/**
 * @author Lars Mortensen
 */
public class ViewCustomerCommand extends TargetCommand{

  public ViewCustomerCommand(String target) {
    super(target);
  }

  @Override
  public String execute(HttpServletRequest request) {
    String username = request.getParameter("username");
    Customer cust = servlets.Factory.getBankController().getCustomer(username);
    request.setAttribute("customer", cust);
    request.setAttribute("accounts", cust.getAccounts());
    return super.execute(request); 
  }
  
  
  

}
