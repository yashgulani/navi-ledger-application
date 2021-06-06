package ledgerclient.command;

import ledgerclient.InMemoryDb;
import ledgerclient.action.MakeLoanPaymentAction;
import ledgerclient.dto.MakePaymentRequest;
import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public class PaymentCommand extends BaseCommand {

  private MakeLoanPaymentAction makeLoanPaymentAction = new MakeLoanPaymentAction();

  public PaymentCommand() {
  }

  @Override
  public void execute(String[] commands) throws Exception {
    makeLoanPaymentAction.accept(buildMakePaymentRequest(commands));
  }

  private MakePaymentRequest buildMakePaymentRequest(String[] commands) throws Exception {

    Bank bank = InMemoryDb.getBankIfPresent(commands[1]);
    Customer customer = InMemoryDb.getCustomerIfPresent(commands[2]);
    Integer lumpSumAmount = Integer.parseInt(commands[3]);
    Integer emiNumber = Integer.parseInt(commands[4]);
    return new MakePaymentRequest(bank, customer, lumpSumAmount, emiNumber);
  }
}
