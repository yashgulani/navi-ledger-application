package ledgerclient.action;

import java.util.function.Function;
import ledgerclient.AmountCalculator;
import ledgerclient.dto.BalanceResponse;
import ledgerclient.dto.ComputeBalanceRequest;
import ledgerclient.model.Bank;
import ledgerclient.model.Customer;
import ledgerclient.model.Loan;
import ledgerclient.model.Payment;

public class ComputeBalanceAction implements Function<ComputeBalanceRequest,BalanceResponse> {

  @Override
  public BalanceResponse apply(ComputeBalanceRequest computeBalanceRequest) {

    Customer customer = computeBalanceRequest.getCustomer();
    Bank bank = computeBalanceRequest.getBank();
    Loan loan = customer.getBankLoanMap().get(bank);
    validate(computeBalanceRequest,loan);

    AmountCalculator amountCalculator = new SimpleInterestAmountCalculator();
    Integer totalAmount = amountCalculator.calculateAmount(loan.getPrincipalAmount(),
        loan.getYears(), loan.getInterestRate());
    Integer monthlyEmi = amountCalculator.getMonthlyEmi(loan.getPrincipalAmount(),
        loan.getYears(), loan.getInterestRate());

    Integer lumpSumAmountsPaid = loan.getPayments().stream()
        .filter(payment -> payment.getEmisPaid() <= computeBalanceRequest.getEmiNumber())
        .mapToInt(Payment::getLumpSumAmount)
        .sum();

    Integer amountPaid = monthlyEmi*computeBalanceRequest.getEmiNumber() + lumpSumAmountsPaid;

    Integer numberOfEmisLeft = (int) Math.ceil((totalAmount - amountPaid)/((double)monthlyEmi));

    return new BalanceResponse(bank.getBankName(), customer.getName(), amountPaid, numberOfEmisLeft);

  }

  private void validate(ComputeBalanceRequest computeBalanceRequest, Loan loan) {
    if(computeBalanceRequest.getEmiNumber() > loan.getYears()*12) {
      throw new RuntimeException("Invalid Emi number");
    }
  }
}
