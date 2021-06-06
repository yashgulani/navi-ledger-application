package ledgerclient.dto;


public class BalanceResponse {
  String bankName;
  String customerName;
  Integer amountPaid;
  Integer emisLeft;

  public BalanceResponse(String bankName, String customerName, Integer amountPaid,
      Integer emisLeft) {
    this.bankName = bankName;
    this.customerName = customerName;
    this.amountPaid = amountPaid;
    this.emisLeft = emisLeft;
  }

  public BalanceResponse() {
  }

  public String getBankName() {
    return bankName;
  }

  public String getCustomerName() {
    return customerName;
  }

  public Integer getAmountPaid() {
    return amountPaid;
  }

  public Integer getEmisLeft() {
    return emisLeft;
  }

  @Override
  public String toString() {
    return String.format(bankName + " " + customerName + " " + amountPaid + " " + emisLeft);
  }
}
