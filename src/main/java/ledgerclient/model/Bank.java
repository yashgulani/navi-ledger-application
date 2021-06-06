package ledgerclient.model;

public class Bank {

  // unique;
  private String bankName;
  private String address;
  private String city;
  private String pincode;
  private String ifscCode;

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBankName() {
    return bankName;
  }
}
