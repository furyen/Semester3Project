
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
    String idAsStr = request.getParameter("custid");
    long id = Long.parseLong(idAsStr);
    Customer cust = servlets.Factory.getBankController().getCustomer(id);
    request.setAttribute("customer", cust);
    return super.execute(request); 
  }
  
  
  

}
