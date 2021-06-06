package ledgerclient.dto;

import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public class CreateLoanRequest {

  private Bank bank;
  private Customer customer;
  private Integer principalAmount;
  private Integer years;
  private Integer interestRate;

  public Bank getBank() {
    return bank;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Integer getPrincipalAmount() {
    return principalAmount;
  }

  public Integer getYears() {
    return years;
  }

  public Integer getInterestRate() {
    return interestRate;
  }

  public CreateLoanRequest(Bank bank, Customer customer, Integer principalAmount,
      Integer years, Integer interestRate) {
    this.bank = bank;
    this.customer = customer;
    this.principalAmount = principalAmount;
    this.years = years;
    this.interestRate = interestRate;
  }
}
