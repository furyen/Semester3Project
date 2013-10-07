/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import model.Account;
import commands.Command;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ShowCustomersCommand;
import commands.ShowDateCommand;
import commands.TargetCommand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.BankDataController;
import model.Customer;

/**
 *
 * @author hsty
 */
public class Factory {
    
    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();
    private List<Customer> customers = new ArrayList<>();
    private Map<String,String> users = new HashMap<>();
    
    private Factory() 
    {
        commands.put("main", 
                new TargetCommand("/main.jsp", "Main Page"));
        commands.put("show_date", 
                new ShowDateCommand("/show_date.jsp", "Show Date"));
        commands.put("show_customers", 
                new ShowCustomersCommand("/show_customers.jsp"));
        commands.put("login_command", new LoginCommand("/main.jsp", "Main Page"));
        commands.put("logout_command", new LogoutCommand("/login.jsp"));
        
        users.put("peter", "123");
        users.put("joe", "321");
        
        Customer cust = new Customer("Donald","Duck","donald@duck.com");
        Account account1 = new Account("Basic Account",0);
        cust.addAccount(account1);
        account1.createTransaction(20000, "Salary");
        account1.createTransaction(-8000, "Morgage payment");
        account1.createTransaction(-1000, "To savings");
        account1.createTransaction(-1500, "Car Loan");
        account1.createTransaction(-1000, "Ensurance");
        customers.add(cust);
        cust = new Customer("Peter","Pedal","peter@pedal.com");
        customers.add(cust);
    }
    
    public static Factory getInstance()
    {
        return instance;
    }
    public static BankDataController getBankController(){
      return DummyBankController.getInstance();
    }
    
    public Command getCommand(String commandString)
    {
        if(commandString == null)
        {
            commandString = "main";
        }
        return commands.get(commandString);
    }
    
    public List<Customer> getCustomers()
    {
        return customers;
    }

    public boolean checkUserLogin(String username, String password) {
        String pw = users.get(username);
        if(pw != null && pw.equals(password))
        {
            return true;
        }
        return false;
    }
}
