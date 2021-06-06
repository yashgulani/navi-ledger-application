package ledgerclient.model;

import java.util.HashMap;
import java.util.Map;

public class Customer {

  private String name;
  //  private List<Loan> loans;
  private Map<Bank, Loan> bankLoanMap = new HashMap<>();

  public void setName(String name) {
    this.name = name;
  }

  public Map<Bank, Loan> getBankLoanMap() {
    return bankLoanMap;
  }

  public String getName() {
    return name;
  }

  public Customer(String name) {
    this.name = name;
  }
}
