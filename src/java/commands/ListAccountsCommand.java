/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import model.Account;
import model.Customer;
import servlets.Factory;

/**
 *
 * @author hsty
 */
public class ListAccountsCommand extends TargetCommand {

    @Override
    public String execute(HttpServletRequest request) {
        Collection<Account> accounts = servlets.DummyBankController.getInstance().getAccounts();
    request.setAttribute("accounts", accounts);
    return super.execute(request); 
    }

    public ListAccountsCommand(String target) {
        super(target);
    }
    
}
