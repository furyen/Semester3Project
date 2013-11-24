/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.TransactionsDTO;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

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
        int accountId = Integer.parseInt(request.getParameter("accountid"));
        Double amount = Double.parseDouble(request.getParameter("amount"));
        String info = request.getParameter("info");
        int recipient = Integer.parseInt(request.getParameter("recipient"));
       
   if(amount>0&& !info.isEmpty()){   
    Factory.getInstance().getBankManager().createTransaction(accountId, recipient, amount);
        return super.execute(request);
   }else{
       String error = "Culd not create transaction. Please insert data in all fields.";
            request.setAttribute("errorincreating", error);
            Command command = servlets.Factory.getInstance().getCommand("gotomakenewtransaction");
                String path = command.execute(request);
                return path;
   }
   } 
   }
 

