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
public class DummyBankController implements BankDataController{

  private static DummyBankController instance = new DummyBankController();
  
  private Map<Long,Customer> customers = new HashMap();
  private Map<Long,Account> accounts = new HashMap();
  
  private DummyBankController() {
    
    Customer cust = new Customer("Donald","Duck","donald@duck.com");
    Account account1 = new Account("Basic Account",0);
    cust.addAccount(account1);
    account1.createTransaction(20000, "Salary");
    account1.createTransaction(-8000, "Morgage payment");
    account1.createTransaction(-1000, "To savings");
    account1.createTransaction(-1500, "Car Loan");
    account1.createTransaction(-1000, "Ensurance");
    customers.put(cust.getCustomerId(),cust);
    accounts.put(account1.getAccountId(),account1);
    
    
    cust = new Customer("Peter","Pan","peter@pan.com");
    account1 = new Account("Basic Account",0);
    cust.addAccount(account1);
    account1.createTransaction(20000, "Salary");
    account1.createTransaction(-8000, "Morgage payment");
    account1.createTransaction(-1000, "To savings");
    account1.createTransaction(-1500, "Car Loan");
    account1.createTransaction(-1000, "Ensurance");
    customers.put(cust.getCustomerId(),cust);
    accounts.put(account1.getAccountId(),account1);
    
    
  }
  
  public static DummyBankController getInstance(){
    return instance;
  }
  

  @Override
  public void addCustomer(Customer cust) {
    customers.put(cust.getCustomerId(),cust);
  }

  @Override
  public Customer getCustomer(long id) {
    return customers.get(id);
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

}
