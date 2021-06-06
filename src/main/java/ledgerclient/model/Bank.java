package ledgerclient.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {

  // unique;
  private String bankName;
  private String address;
  private String city;
  private String pincode;
  private String ifscCode;
  private Map<Customer,Loan> customerLoanMap;

  public Bank(String bankName) {
    this.bankName = bankName;
    this.customerLoanMap = new HashMap<>();
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBankName() {
    return bankName;
  }

  public Map<Customer, Loan> getCustomerLoanMap() {
    return customerLoanMap;
  }
}
