package ledgerclient.command;

import ledgerclient.InMemoryDb;
import ledgerclient.action.CreateLoanAction;
import ledgerclient.dto.CreateLoanRequest;
import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public class LoanCommand extends BaseCommand {

  // todo action marker interface
  private CreateLoanAction createLoanAction = new CreateLoanAction();

  public LoanCommand() {
  }

  @Override
  public void execute(String[] commands) {
    createLoanAction.accept(buildCreateLoanRequest(commands));
  }

  private CreateLoanRequest buildCreateLoanRequest(String[] commands) {
    Bank bank = InMemoryDb.getBankByName(commands[1]);
    Customer customer = InMemoryDb.getCustomerByName(commands[2]);
    Integer principalAmount = Integer.parseInt(commands[3]);
    Integer years = Integer.parseInt(commands[4]);
    Integer interestRate = Integer.parseInt(commands[5]);

    return new CreateLoanRequest(bank, customer, principalAmount, years, interestRate);
  }

}
