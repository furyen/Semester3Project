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
        String balance = request.getParameter("balance");
        if(!accountType.isEmpty() && !username.isEmpty() && !balance.isEmpty()){
        double balanceTrue = Double.parseDouble(balance);
            Customer cust = servlets.DummyBankController.getInstance().getCustomer(username);
        Account acc = new Account(accountType, balanceTrue);
        cust.addAccount(acc);
        servlets.DummyBankController.getInstance().addAccount(acc);
        request.setAttribute("customer", cust);
        return super.execute(request);
        }else{
            String error = "Culd not create account. Please insert data in all fields.";
            request.setAttribute("errorincreating", error);
            request.setAttribute("username", username);
            Command command = servlets.Factory.getInstance().getCommand("gotoaddaccount");
                String path = command.execute(request);
                return path;
        }
    }
    
    
    
}
