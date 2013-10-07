/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.Command;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ShowCustomersCommand;
import commands.ShowDateCommand;
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
    private Map<String, String> customers = new HashMap<>();
    private Map<String, String> employees = new HashMap<>();

    private Factory() {
        commands.put("main",
                new TargetCommand("/Main.jsp", "Main Page"));
        commands.put("show_customers",
                new ShowCustomersCommand("employee/Show_customers.jsp"));
        commands.put("customerLogin", new LoginCommand("customer/Main.jsp", "Customer Login"));
        commands.put("employeeLogin", new LoginCommand("employee/Main.jsp", "Employee Login"));
        commands.put("logout_command", new LogoutCommand("/Login.jsp"));
        commands.put("view_customer", new ViewCustomerCommand("employee/viewCustomer.jsp"));

        customers.put("peter", "123");
        employees.put("joe", "321");


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

    public boolean checkUserLogin(String username, String password, String userType) {
        String pw = null;
        
        switch (userType) {
            case "customerLogin":
                {
                    System.out.println("cust");
                     pw = customers.get(username);
                    break;
                }
            case "employeeLogin":
                {
                    System.out.println("emp");
                     pw = employees.get(username);
                    break;
                }
        }
        if (pw != null && pw.equals(password)) {
            return true;
        }
        return false;
    }
}
