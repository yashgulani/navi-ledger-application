package ledgerclient.action;

import java.util.function.Consumer;
import ledgerclient.dto.CreateLoanRequest;
import ledgerclient.model.Bank;
import ledgerclient.model.Customer;
import ledgerclient.model.Loan;

public class CreateLoanAction implements Consumer<CreateLoanRequest> {

  private static int loanId;

  @Override
  public void accept(CreateLoanRequest createLoanRequest) {

    Bank bank = createLoanRequest.getBank();
    Customer customer = createLoanRequest.getCustomer();

    Loan loan = new Loan();
    loan.setLoanId(loanId++);
    loan.setBank(bank);
    loan.setInterestRate(createLoanRequest.getInterestRate());
    loan.setPrincipalAmount(createLoanRequest.getPrincipalAmount());
    loan.setYears(createLoanRequest.getYears());

    customer.getBankLoanMap().put(bank, loan);
  }
}
