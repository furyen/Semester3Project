/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.AddCustomerCommand;
import commands.Command;
import commands.CreateNewAccountCommand;
import commands.ListCustomersCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ListAccountsCommand;
import commands.NewTransactionCommand;
import commands.TargetCommand;
import commands.ViewCustomerCommand;
import commands.ViewTransactionsCommand;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.BankDataController;
import util.UAgentInfo;

/**
 *
 * @author hsty
 */
public class Factory {

    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();

    private Factory() {
        //login command
        commands.put("login", new TargetCommand("/login.jsp"));
        commands.put("logout_command", new LogoutCommand("/login.jsp"));
        //employee side commands
        commands.put("empmain", new TargetCommand("employee/Main.jsp", "Main Page"));
        commands.put("listaccounts", new ListAccountsCommand("employee/ListAccounts.jsp"));
        commands.put("viewtransactions", new ViewTransactionsCommand("employee/ViewTransactions.jsp", "Transactions"));
        commands.put("gotoaddcustomer", new TargetCommand("employee/AddCustomer.jsp"));
        commands.put("gotomakenewtransaction", new ViewTransactionsCommand("employee/NewTransaction.jsp", "Create a new Transaction"));
        commands.put("makenewtransaction", new NewTransactionCommand("employee/ViewTransactions.jsp"));
        commands.put("gotoaddaccount", new ViewCustomerCommand("employee/CreateNewAccount.jsp"));
        commands.put("addaccount", new CreateNewAccountCommand("employee/ViewCustomer.jsp"));
        commands.put("employeeLogin", new LoginCommand("employee/Main.jsp", "Employee Login"));
        commands.put("viewcustomer", new ViewCustomerCommand("employee/ViewCustomer.jsp"));
        commands.put("listcustomer", new ListCustomersCommand("employee/ListCustomers.jsp"));
        commands.put("addcustomer", new AddCustomerCommand("employee/AddCustomer.jsp"));
        //customer side commands
        commands.put("custmain", new TargetCommand("customer/Main.jsp", "Main Page"));
        commands.put("customerLogin", new LoginCommand("customer/Main.jsp", "Customer Login"));
        commands.put("viewowntransactions", new ViewTransactionsCommand("customer/ViewTransactions.jsp", "Transactions"));
        commands.put("gotomakenewowntransaction", new ViewTransactionsCommand("customer/NewTransaction.jsp","Create new transaction"));
        commands.put("makenewowntransaction", new NewTransactionCommand("customer/ViewTransactions.jsp"));
        //mobile commands
        commands.put("mainmobile", new TargetCommand("mobile/mobileMainNA.jsp"));
        commands.put("loginmobile", new TargetCommand("mobile/loginMobile.jsp"));
    
    }

    public static Factory getInstance() {
        return instance;
    }

    public Command getCommand(String commandString) {
        if (commandString == null) {
            commandString = "login";
        }
        return commands.get(commandString);
    }
    public Command getCommand1(String cmdStr, HttpServletRequest res) {
        if(cmdStr == null){
            cmdStr = isMobileDevice(res)? "mainmobile": "main";
        }else{
            cmdStr = "main";
        }
        return commands.get(cmdStr);
    }
    public boolean isMobileDevice(HttpServletRequest res){
        String userAgent = res.getHeader("User-Agent");
        String httpAccept = res.getHeader("Accept");
        UAgentInfo detector = new UAgentInfo(userAgent,httpAccept);
        return detector.detectMobileQuick();
    }
}
