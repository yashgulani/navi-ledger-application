package ledgerclient;

import java.util.HashMap;
import java.util.Map;
import ledgerclient.action.ComputeBalanceAction;
import ledgerclient.action.CreateLoanAction;
import ledgerclient.action.MakeLoanPaymentAction;
import ledgerclient.dto.BalanceResponse;
import ledgerclient.dto.ComputeBalanceRequest;
import ledgerclient.dto.CreateLoanRequest;
import ledgerclient.dto.MakePaymentRequest;
import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public class LedgerManager {

  private CreateLoanAction createLoanAction = new CreateLoanAction();
  private ComputeBalanceAction computeBalanceAction = new ComputeBalanceAction();
  private MakeLoanPaymentAction makeLoanPaymentAction = new MakeLoanPaymentAction();
  private Map<String, Bank> bankNameBankMap = new HashMap<>();
  private Map<String, Customer> customerNameCustomerMap = new HashMap<>();

  // as per the input constraints one customer can take only 1 loan at a bank
  public void takeLoan(String bankName, String customerName, Integer principalAmount,
      Integer years, Integer interestRate) {

    Bank bank = new Bank();
    bank.setBankName(bankName);
    bankNameBankMap.put(bankName, bank);

    Customer customer = new Customer();
    customer.setName(customerName);
    customerNameCustomerMap.put(customerName, customer);

    createLoanAction.accept(new CreateLoanRequest(bank, customer, principalAmount, years, interestRate));

  }

  public void showBalance(String bankName, String customerName, Integer emiNumber) {

    if (!isRequestValid(bankName, customerName)) {
      System.out.println("Invalid Bank/Customer name");
      return;
    }

    BalanceResponse balanceResponse = computeBalanceAction.apply(new ComputeBalanceRequest(bankNameBankMap.get(bankName),
        customerNameCustomerMap.get(customerName), emiNumber));

    System.out.println(balanceResponse.toString());

  }

  public void makePayment(String bankName, String customerName, Integer lumpSumAmount,
      Integer emiNumber) {

    if (!isRequestValid(bankName, customerName)) {
      System.out.println("Invalid Bank/Customer name");
      return;
    }

    makeLoanPaymentAction.accept(new MakePaymentRequest(bankNameBankMap.get(bankName),
        customerNameCustomerMap.get(customerName), lumpSumAmount, emiNumber));

  }

  private boolean isRequestValid(String bankName, String customerName){

    return (bankNameBankMap.containsKey(bankName) && customerNameCustomerMap.containsKey(customerName));
  }

}
