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
import commands.ShowLoginCommand;
import commands.TargetCommand;
import commands.ViewCustomerCommand;
import commands.ViewTransactionsCommand;
import control.BankManagerRemote;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import util.UAgentInfo;

/**
 *
 * @author hsty
 */
public class Factory {

    private final BankManagerRemote bankManager = lookupBankManagerRemote();
    private static Factory instance = null;
    private final Map<String, Command> commands = new HashMap<>();
    private static NewJerseyClient rest = null;

    public static NewJerseyClient getRestClient() {
        if (rest == null) {
            rest = new NewJerseyClient();
            rest.setUsernamePassword("test", "test");
        }
        return rest;
    }

    private Factory() {
        Map<SecurityRole, String> roleToTarget = new HashMap();
        roleToTarget.put(SecurityRole.Customers, "/customer/Main.jsp");
        roleToTarget.put(SecurityRole.Employees, "/employee/Main.jsp");
        //login command
        commands.put("main", new TargetCommand("/login.jsp", SecurityRole.All));
        commands.put("login", new LoginCommand(roleToTarget, "/login.jsp"));
        commands.put("showlogin", new ShowLoginCommand("/login.jsp", SecurityRole.All));
        commands.put("logout_command", new LogoutCommand("/login.jsp", SecurityRole.All));

        //employee side commands
        commands.put("empmain", new TargetCommand("employee/Main.jsp", "Main Page", SecurityRole.Employees));
        commands.put("listaccounts", new ListAccountsCommand("employee/ListAccounts.jsp", SecurityRole.Employees));
        commands.put("viewtransactions", new ViewTransactionsCommand("employee/ViewTransactions.jsp", "Transactions", SecurityRole.Employees));
        commands.put("gotoaddcustomer", new TargetCommand("employee/AddCustomer.jsp", SecurityRole.Employees));
        commands.put("gotomakenewtransaction", new ViewTransactionsCommand("employee/NewTransaction.jsp", "Create a new Transaction", SecurityRole.Employees));
        commands.put("makenewtransaction", new NewTransactionCommand("employee/ViewTransactions.jsp", SecurityRole.Employees));
        commands.put("gotoaddaccount", new ViewCustomerCommand("employee/CreateNewAccount.jsp", SecurityRole.Employees));
        commands.put("addaccount", new CreateNewAccountCommand("employee/ViewCustomer.jsp", SecurityRole.Employees));
        commands.put("emplogin", new TargetCommand("employee/Main.jsp", "Employee Login", SecurityRole.Employees));
        commands.put("viewcustomer", new ViewCustomerCommand("employee/ViewCustomer.jsp", SecurityRole.Employees));
        commands.put("listcustomer", new ListCustomersCommand("employee/ListCustomers.jsp", SecurityRole.Employees));
        commands.put("addcustomer", new AddCustomerCommand("employee/AddCustomer.jsp", SecurityRole.Employees));

        //customer side commands
        commands.put("custmain", new TargetCommand("customer/Main.jsp", "Main Page", SecurityRole.Customers));
        commands.put("custchat", new TargetCommand("customer/Chat.jsp", "Chat Page", SecurityRole.Customers));
        commands.put("custlogin", new TargetCommand("customer/Main.jsp", "Customer Login", SecurityRole.Customers));
        commands.put("viewowntransactions", new ViewTransactionsCommand("customer/ViewTransactions.jsp", "Transactions", SecurityRole.Customers));
        commands.put("gotomakenewowntransaction", new ViewTransactionsCommand("customer/NewTransaction.jsp", "Create new transaction", SecurityRole.Customers));
        commands.put("makenewowntransaction", new NewTransactionCommand("customer/ViewTransactions.jsp", SecurityRole.Customers));

        //mobile commands
        commands.put("mainmobile", new TargetCommand("mobile/mobileMainNA.jsp", SecurityRole.All));
        commands.put("loginmobile", new TargetCommand("mobile/loginMobile.jsp", SecurityRole.All));

    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Command getCommand(String cmdStr, HttpServletRequest request) {
        if (cmdStr == null) {
            cmdStr = "showlogin";
        }
        Command cmd = commands.get(cmdStr);

        //The most important place in terms of security.
        //If you fail here your security is broken
        if (cmd instanceof TargetCommand) {
            SecurityRole requiredRole = ((TargetCommand) cmd).getRole();
            if (requiredRole != SecurityRole.All
                    && !request.isUserInRole(requiredRole.toString())) {
                throw new SecurityException("You don't have the necessary rights to perform this command");
            }
        }

        return cmd;
    }

    public Command getCommand1(String cmdStr, HttpServletRequest res) {
        if (cmdStr == null) {
            cmdStr = isMobileDevice(res) ? "mainmobile" : "main";
        } else {
            cmdStr = "main";
        }
        return commands.get(cmdStr);
    }

    public boolean isMobileDevice(HttpServletRequest res) {
        String userAgent = res.getHeader("User-Agent");
        String httpAccept = res.getHeader("Accept");
        UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);
        return detector.detectMobileQuick();
    }

    public BankManagerRemote getBankManager() {
        return bankManager;
    }

    private BankManagerRemote lookupBankManagerRemote() {
        try {
            Context c = new InitialContext();
            return (BankManagerRemote) c.lookup("java:global/ProjectBackend/BankManager!control.BankManagerRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
