/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.AccountDTO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

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
        BigDecimal balance = new BigDecimal(request.getParameter("balance"));
        String interest = request.getParameter("interest");
        String interestDate = request.getParameter("interestdate");
        Integer minimumBalance = Integer.parseInt(request.getParameter("minimumbalance"));
        if(!accountType.isEmpty() && !username.isEmpty()){
        AccountDTO acc = new AccountDTO(accountType, balance, 2, new Date(), Integer.parseInt(interest), new Date(interestDate), minimumBalance, username);
        Factory.getInstance().getBankController().addAccount(acc);
  
//        request.setAttribute("customer", cust);
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
