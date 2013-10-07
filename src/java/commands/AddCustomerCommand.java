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
    //We might need to something here
    return super.execute(request); //To change body of generated methods, choose Tools | Templates.
  }
  

}
