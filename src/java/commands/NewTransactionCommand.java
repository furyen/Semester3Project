/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.AccountDTO;
import dto.TransactionsDTO;
import java.math.BigDecimal;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author TheOneX
 */
public class NewTransactionCommand extends TargetCommand {

    public NewTransactionCommand(String target,SecurityRole role) {
        super(target,role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        String info = request.getParameter("info");
        int recipient = Integer.parseInt(request.getParameter("recipient"));
        String idAccount = request.getParameter("accountid");
        int accountId = Integer.parseInt(idAccount);

        if ((amount.compareTo(BigDecimal.ZERO) > 0) && !info.isEmpty()) {
            Factory.getInstance().getBankManager().createTransaction(new TransactionsDTO(recipient, amount, accountId));
            AccountDTO account = Factory.getInstance().getBankManager().getAccount(accountId);
            Collection<TransactionsDTO> transactions = Factory.getInstance().getBankManager().getAccountTransactions(accountId);
            request.setAttribute("account", account);
            request.setAttribute("transactions", transactions);
            return super.execute(request);
        } else {
            String error = "Culd not create transaction. Please insert data in all fields.";
            request.setAttribute("errorincreating", error);
            Command command = servlets.Factory.getInstance().getCommand("gotomakenewtransaction",request);
            String path = command.execute(request);
            return path;
        }
    }
}
