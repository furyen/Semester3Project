/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import model.Account;
import model.Customer;

/**
 *
 * @author hsty
 */
public class ViewTransactionsCommand extends TargetCommand {

    public ViewTransactionsCommand(String target, String title) {
        super(target, title);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String idAccount = request.getParameter("accountid");
    long accountId = Long.parseLong(idAccount);
   Account account = servlets.DummyBankController.getInstance().getAccount(accountId);
    request.setAttribute("account", account);
        return super.execute(request); 
    }
    
    
    
}
