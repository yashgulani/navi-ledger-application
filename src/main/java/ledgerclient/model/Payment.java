package ledgerclient.model;

public class Payment {

  private Bank bank;
  private Customer customer;
  private Integer lumpSumAmount;
  private Integer emisPaid;

  public Payment(Bank bank, Customer customer, Integer lumpSumAmount, Integer emisPaid) {
    this.bank = bank;
    this.customer = customer;
    this.lumpSumAmount = lumpSumAmount;
    this.emisPaid = emisPaid;
  }

  public Integer getLumpSumAmount() {
    return lumpSumAmount;
  }

  public Integer getEmisPaid() {
    return emisPaid;
  }
}
