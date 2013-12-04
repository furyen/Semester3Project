
package commands;

import dto.CustomerAccountsDTO;
import dto.CustomerDTO;
import java.util.Collection;
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
    CustomerDTO cust =Factory.getInstance().getBankManager().getCustomer(username);
    request.setAttribute("customer", cust);
    Collection<CustomerAccountsDTO> acc = Factory.getInstance().getBankManager().getCustomerAccounts(username);
    request.setAttribute("accounts", acc);
    return super.execute(request); 
  }
  
  
  

}
