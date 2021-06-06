package ledgerclient.model;

import java.util.ArrayList;
import java.util.List;

public class Loan {

  private Integer loanId;
  private Integer principalAmount;
  private Integer years;
  private Integer interestRate;
  private Bank bank;
  private List<Payment> payments = new ArrayList<>();

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public void setPrincipalAmount(Integer principalAmount) {
    this.principalAmount = principalAmount;
  }

  public void setYears(Integer years) {
    this.years = years;
  }

  public void setInterestRate(Integer interestRate) {
    this.interestRate = interestRate;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public Integer getLoanId() {
    return loanId;
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

  public Bank getBank() {
    return bank;
  }

  public List<Payment> getPayments() {
    return payments;
  }

}
