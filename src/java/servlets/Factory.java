/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.AddCustomerCommand;
import commands.Command;
import commands.ListCustomersCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ShowCustomersCommand;
import commands.TargetCommand;
import commands.ViewCustomerCommand;
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
        commands.put("empmain",
                new TargetCommand("employee/Main.jsp", "Main Page"));
        commands.put("custmain",
                new TargetCommand("customer/Main.jsp", "Main Page"));
        commands.put("show_customers",
                new ShowCustomersCommand("employee/Show_customers.jsp"));
        commands.put("customerLogin", new LoginCommand("customer/Main.jsp", "Customer Login"));
        commands.put("employeeLogin", new LoginCommand("employee/Main.jsp", "Employee Login"));
        commands.put("logout_command", new LogoutCommand("/login.jsp"));
        commands.put("viewcustomer", new ViewCustomerCommand("employee/ViewCustomer.jsp"));
        commands.put("listcustomer", new ListCustomersCommand("employee/ListCustomers.jsp"));
        commands.put("addcustomer", new AddCustomerCommand("employee/AddCustomer.jsp"));
        commands.put("gotoaddcustomer", new TargetCommand("employee/AddCustomer.jsp"));
     


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
