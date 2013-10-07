package model;

import java.util.Collection;

public interface BankDataController {
   void addCustomer(Customer cust);
   Customer getCustomer(long id);
   Account getAccount(long id);
   Collection<Account> getAccounts();
   Collection<Customer> getCustomers();
}
