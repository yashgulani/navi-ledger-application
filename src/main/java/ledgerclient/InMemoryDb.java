package ledgerclient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public final class InMemoryDb {


  private InMemoryDb() {
  }

  private static Map<String, Bank> bankNameBankMap = new HashMap<>();
  private static Map<String, Customer> customerNameCustomerMap = new HashMap<>();

  public static Bank getBankByName(String bankName) {
    if(!bankNameBankMap.containsKey(bankName)) {
      Bank bank = new Bank(bankName);
      bankNameBankMap.put(bankName, bank);
    }

    return bankNameBankMap.get(bankName);
  }

  public static Bank getBankIfPresent(String bankName) throws Exception {
    if(!bankNameBankMap.containsKey(bankName)) {
      throw new Exception(String.format("Bank %s not found",bankName));
    }

    return bankNameBankMap.get(bankName);

  }

  public static Customer getCustomerByName(String customerName) {
    if(!customerNameCustomerMap.containsKey(customerName)) {
      Customer customer = new Customer(customerName);
      customerNameCustomerMap.put(customerName, customer);
    }

    return customerNameCustomerMap.get(customerName);
  }

  public static Customer getCustomerIfPresent(String customerName) throws Exception {
    if(!customerNameCustomerMap.containsKey(customerName)) {
      throw new Exception(String.format("Customer %s not found",customerName));
    }

    return customerNameCustomerMap.get(customerName);
  }

}
