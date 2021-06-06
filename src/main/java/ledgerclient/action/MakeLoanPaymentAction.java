package ledgerclient.action;

import java.util.function.Consumer;
import ledgerclient.dto.MakePaymentRequest;
import ledgerclient.model.Loan;
import ledgerclient.model.Payment;

public class MakeLoanPaymentAction implements Consumer<MakePaymentRequest> {

  @Override
  public void accept(MakePaymentRequest request){

    validate(request);
    Payment payment = new Payment(request.getBank(), request.getCustomer(),
        request.getLumpSumAmount(), request.getEmiNumber());

    Loan loan = request.getCustomer().getBankLoanMap().get(request.getBank());

    loan.getPayments().add(payment);
  }

  private void validate(MakePaymentRequest request) {

    if(request.getLumpSumAmount() <= 0 || request.getEmiNumber() < 0) {
      throw new RuntimeException("Invalid Request");
    }
  }
}
