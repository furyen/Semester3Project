
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
    Customer cust = servlets.DummyBankController.getInstance().getCustomer(username);
    request.setAttribute("customer", cust);
    return super.execute(request); 
  }
  
  
  

}
