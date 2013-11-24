/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.AccountTransactionsDTO;
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
        Collection<AccountTransactionsDTO> transactions = Factory.getInstance().getBankController().getAccountTransactions(accountId);
        request.setAttribute("account", transactions);
        return super.execute(request);
    }
}
