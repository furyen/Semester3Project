/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.AccountDTO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author TheOneX
 */
public class CreateNewAccountCommand extends TargetCommand {

    public CreateNewAccountCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String accountType = request.getParameter("accounttype");
        String username = request.getParameter("username");
        BigDecimal balance = new BigDecimal(request.getParameter("balance"));
        String interest = request.getParameter("interest");
        String interestDateString = request.getParameter("interestdate");
        Integer minimumBalance = Integer.parseInt(request.getParameter("minimumbalance"));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date interestDate = null;
        try {      
            interestDate = df.parse(interestDateString);
        } catch (ParseException ex) {
            Logger.getLogger(CreateNewAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!accountType.isEmpty() && !username.isEmpty()) {
            AccountDTO acc = new AccountDTO(accountType, balance, 2, new Date(), Integer.parseInt(interest),interestDate, minimumBalance, username);
            Factory.getInstance().getBankManager().addAccount(acc);

//        request.setAttribute("customer", cust);
            return super.execute(request);
        } else {
            String error = "Culd not create account. Please insert data in all fields.";
            request.setAttribute("errorincreating", error);
            request.setAttribute("username", username);
            Command command = servlets.Factory.getInstance().getCommand("gotoaddaccount");
            String path = command.execute(request);
            return path;
        }
    }
}
