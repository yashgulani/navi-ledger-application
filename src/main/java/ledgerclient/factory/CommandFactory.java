package ledgerclient.factory;

import ledgerclient.command.BalanceCommand;
import ledgerclient.command.BaseCommand;
import ledgerclient.command.LoanCommand;
import ledgerclient.command.PaymentCommand;

public class CommandFactory {

  public CommandFactory() {
  }

  public BaseCommand providesCommand(String commandType) throws Exception {
    switch (commandType) {
      case "LOAN":
        return new LoanCommand();
      case "PAYMENT":
        return new PaymentCommand();
      case "BALANCE":
        return new BalanceCommand();
      default:
        throw new Exception(String.format("Invalid Command Type %s", commandType));
    }
  }

}
