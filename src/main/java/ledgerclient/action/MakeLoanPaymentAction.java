package ledgerclient.action;

import java.util.function.Consumer;
import ledgerclient.LoanCalculator;
import ledgerclient.dto.MakePaymentRequest;
import ledgerclient.model.Loan;
import ledgerclient.model.Payment;

public class MakeLoanPaymentAction implements Consumer<MakePaymentRequest> {

  @Override
  public void accept(MakePaymentRequest request){

    Payment payment = new Payment(request.getBank(), request.getCustomer(),
        request.getLumpSumAmount(), request.getEmiNumber());

    Loan loan = request.getCustomer().getBankLoanMap().get(request.getBank());
    validate(request, loan);

    loan.getPayments().add(payment);
  }

  private void validate(MakePaymentRequest request, Loan loan) throws RuntimeException {

    if(request.getLumpSumAmount() <= 0 || request.getEmiNumber() < 0) {
      throw new RuntimeException("Invalid Request");
    }

    LoanCalculator loanCalculator = new SimpleInterestCalculatorUtil();
    int monthlyEmi = loanCalculator.getMonthlyEmi(loan.getPrincipalAmount(), loan.getYears(), loan.getInterestRate());
    int totalAmount = loanCalculator.calculateAmount(loan.getPrincipalAmount(), loan.getYears(), loan.getInterestRate());
    int lumpSumAmountsPaid = loanCalculator.getLumpSumAmountPaid(loan, request.getEmiNumber());
    int amountPaid = monthlyEmi*request.getEmiNumber() + lumpSumAmountsPaid;
    int amountPending = totalAmount - amountPaid;

    if(amountPending < request.getLumpSumAmount()) {
      throw new RuntimeException(String.format("LumpSumpAmount %s greated than pending amount pending %s",request.getLumpSumAmount(), amountPending));
    }

  }
}
