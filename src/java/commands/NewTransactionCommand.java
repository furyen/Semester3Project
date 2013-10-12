/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import model.Account;

/**
 *
 * @author TheOneX
 */
public class NewTransactionCommand extends TargetCommand{

    public NewTransactionCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String idAccount = request.getParameter("accountid");
        String amount = request.getParameter("amount");
        String info = request.getParameter("info");
        long accountId = Long.parseLong(idAccount);
        Account account = servlets.DummyBankController.getInstance().getAccount(accountId);
   if(!amount.isEmpty() && !info.isEmpty()){   
    double amountReady = Double.parseDouble(amount);
   account.createTransaction(amountReady, info);
    request.setAttribute("account", account);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
   }else{
       String error = "Culd not create transaction. Please insert data in all fields.";
            request.setAttribute("errorincreating", error);
            request.setAttribute("account", account);
            Command command = servlets.Factory.getInstance().getCommand("gotomakenewtransaction");
                String path = command.execute(request);
                return path;
   }
   } 
   }
 

