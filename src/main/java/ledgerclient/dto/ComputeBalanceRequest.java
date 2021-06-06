package ledgerclient.dto;

import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public class ComputeBalanceRequest {
  private Bank bank;
  private Customer customer;
  private Integer emiNumber;

  public Bank getBank() {
    return bank;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Integer getEmiNumber() {
    return emiNumber;
  }

  public ComputeBalanceRequest(Bank bank, Customer customer, Integer emiNumber) {
    this.bank = bank;
    this.customer = customer;
    this.emiNumber = emiNumber;
  }
}
