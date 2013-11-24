
package commands;

import dto.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

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
    CustomerDTO cust =Factory.getInstance().getBankController().getCustomer(username);
    request.setAttribute("customer", cust);
    return super.execute(request); 
  }
  
  
  

}
