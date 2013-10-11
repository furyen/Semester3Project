/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import model.Account;
import model.Customer;

/**
 *
 * @author TheOneX
 */
public class CreateNewAccountCommand extends TargetCommand{
 
    public CreateNewAccountCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String accountType = request.getParameter("accounttype");
        String username = request.getParameter("username");
        double balance = Double.parseDouble(request.getParameter("balance"));
        Customer cust = servlets.DummyBankController.getInstance().getCustomer(username);
        Account acc = new Account(accountType, balance);
        cust.addAccount(acc);
        servlets.DummyBankController.getInstance().addAccount(acc);
        request.setAttribute("customer", cust);
        
        
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
