/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.AccountDTO;
import dto.TransactionsDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

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
        int accountId = Integer.parseInt(idAccount);
        AccountDTO account= Factory.getInstance().getBankManager().getAccount(accountId);
        Collection<TransactionsDTO> transactions = Factory.getInstance().getBankManager().getAccountTransactions(accountId);
        request.setAttribute("account", account);
        request.setAttribute("transactions", transactions);
        return super.execute(request);
    }
}
