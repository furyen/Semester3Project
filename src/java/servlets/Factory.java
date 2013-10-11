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
import model.BankDataController;

/**
 *
 * @author hsty
 */
public class Factory {

    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();
  

    private Factory() {
        //login command
         commands.put("logout_command", new LogoutCommand("/login.jsp"));
        //employee side commands
        commands.put("empmain", new TargetCommand("employee/Main.jsp", "Main Page"));
        commands.put("listaccounts", new ListAccountsCommand("employee/ListAccounts.jsp"));
        commands.put("viewtransactions", new ViewTransactionsCommand("employee/ViewTransactions.jsp", "Transactions"));
        commands.put("gotomakenewtransaction", new ViewTransactionsCommand("employee/NewTransaction.jsp","Create a new Transaction"));
        commands.put("makenewtransaction", new NewTransactionCommand("employee/ViewTransactions.jsp"));
        commands.put("gotoaddaccount", new ViewCustomerCommand("employee/CreateNewAccount.jsp"));
        commands.put("addaccount", new CreateNewAccountCommand("employee/ViewCustomer.jsp"));
        commands.put("employeeLogin", new LoginCommand("employee/Main.jsp", "Employee Login"));
        commands.put("viewcustomer", new ViewCustomerCommand("employee/ViewCustomer.jsp"));
        commands.put("listcustomer", new ListCustomersCommand("employee/ListCustomers.jsp"));
        commands.put("addcustomer", new AddCustomerCommand("employee/AddCustomer.jsp"));
        //customer side commands
        commands.put("gotoaddcustomer", new TargetCommand("employee/AddCustomer.jsp"));
        commands.put("custmain", new TargetCommand("customer/Main.jsp", "Main Page"));
        commands.put("customerLogin", new LoginCommand("customer/Main.jsp", "Customer Login"));

    }

    public static Factory getInstance() {
        return instance;
    }

    public static BankDataController getBankController() {
        return DummyBankController.getInstance();
    }

    public Command getCommand(String commandString) {
        if (commandString == null) {
            commandString = "main";
        }
        return commands.get(commandString);
    }

  
}
