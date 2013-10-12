/*
 */
package servlets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import model.Account;
import model.BankDataController;
import model.Customer;

/**
 * @author Lars Mortensen
 */
public class DummyBankController implements BankDataController {

    private static DummyBankController instance = new DummyBankController();
    private Map<String, String> employees = new HashMap<>();
    private Map<String, Customer> customers = new HashMap();
    private Map<Long, Account> accounts = new HashMap();

    private DummyBankController() {

        Customer cust = new Customer("Donald", "Duck", "donald@duck.com", "don", "1");
        Account account1 = new Account("Basic Account", 0);
        cust.addAccount(account1);
        account1.createTransaction(20000, "Salary");
        account1.createTransaction(-8000, "Morgage payment");
        account1.createTransaction(-1000, "To savings");
        account1.createTransaction(-1500, "Car Loan");
        account1.createTransaction(-1000, "Ensurance");
        customers.put(cust.getUsername(), cust);
        accounts.put(account1.getAccountId(), account1);


        cust = new Customer("Peter", "Pan", "peter@pan.com", "pet", "1");
        account1 = new Account("Basic Account", 0);
        cust.addAccount(account1);
        account1.createTransaction(20000, "Salary");
        account1.createTransaction(-8000, "Morgage payment");
        account1.createTransaction(-1000, "To savings");
        account1.createTransaction(-1500, "Car Loan");
        account1.createTransaction(-1000, "Ensurance");
        customers.put(cust.getUsername(), cust);
        accounts.put(account1.getAccountId(), account1);
        
        employees.put("joe", "321");
    }

    public static DummyBankController getInstance() {
        return instance;
    }

    @Override
    public void addCustomer(Customer cust) {
        customers.put(cust.getUsername(), cust);
    }

    @Override
    public Customer getCustomer(String username) {
        return customers.get(username);
    }
    
    @Override
    public void addAccount(Account acc){
        accounts.put(acc.getAccountId(), acc);
    }
    
    @Override
    public Account getAccount(long id) {
        return accounts.get(id);
    }

    @Override
    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    @Override
    public Collection<Customer> getCustomers() {
        return customers.values();
    }

    public boolean checkUserLogin(String username, String password, String userType) {
        String pw = null;

        switch (userType) {
            case "customerLogin": {
                System.out.println("cust");
                pw = customers.get(username).getPassword();
                break;
            }
            case "employeeLogin": {
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
