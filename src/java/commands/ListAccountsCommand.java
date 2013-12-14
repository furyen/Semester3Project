/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dto.AccountDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;


public class ListAccountsCommand extends TargetCommand {

    @Override
    public String execute(HttpServletRequest request) {
        Collection<AccountDTO> accounts = Factory.getInstance().getBankManager().getAccounts();
    request.setAttribute("accounts", accounts);
    return super.execute(request); 
    }

    public ListAccountsCommand(String target,SecurityRole role) {
        super(target,role);
    }
    
}
