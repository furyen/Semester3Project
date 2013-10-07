package commands;
import commands.TargetCommand;
import model.Customer;
/*
 */


import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;

/**
 * @author Lars Mortensen
 */
public class ListCustomersCommand extends TargetCommand {

  public ListCustomersCommand(String target) {
    super(target);
  }

  @Override
  public String execute(HttpServletRequest request) {
    Collection<Customer> custs = servlets.Factory.getBankController().getCustomers();
    request.setAttribute("customers", custs);
    return super.execute(request); 
  }
  
  

}
