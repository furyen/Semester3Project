/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.TransactionsDTO;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        DecimalFormat df = new DecimalFormat();
        BigDecimal amount = null;
        try {
            amount = (BigDecimal)df.parse(request.getParameter("amount"));
        } catch (ParseException ex) {
            Logger.getLogger(NewTransactionCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        String info = request.getParameter("info");
        int recipient = Integer.parseInt(request.getParameter("recipient"));
       
   if((amount.compareTo(BigDecimal.ZERO)>0)&& !info.isEmpty()){   
    Factory.getInstance().getBankManager().createTransaction(new TransactionsDTO(recipient, amount, accountId));
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
 

