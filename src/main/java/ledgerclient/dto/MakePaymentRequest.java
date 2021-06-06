package ledgerclient.dto;

import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public class MakePaymentRequest {

  private Bank bank;
  private Customer customer;
  private Integer lumpSumAmount;
  private Integer emiNumber;

  public Bank getBank() {
    return bank;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Integer getLumpSumAmount() {
    return lumpSumAmount;
  }

  public Integer getEmiNumber() {
    return emiNumber;
  }

  public MakePaymentRequest(Bank bank, Customer customer, Integer lumpSumAmount,
      Integer emiNumber) {
    this.bank = bank;
    this.customer = customer;
    this.lumpSumAmount = lumpSumAmount;
    this.emiNumber = emiNumber;
  }
}
