package ledgerclient.command;


import ledgerclient.InMemoryDb;
import ledgerclient.action.ComputeBalanceAction;
import ledgerclient.dto.ComputeBalanceRequest;
import ledgerclient.model.Bank;
import ledgerclient.model.Customer;

public class BalanceCommand extends BaseCommand {

  private ComputeBalanceAction computeBalanceAction = new ComputeBalanceAction();

  public BalanceCommand() {
  }

  @Override
  public void execute(String[] commands) throws Exception {
    System.out.println(computeBalanceAction.apply(buildComputeBalanceRequest(commands)).toString());
  }

  private ComputeBalanceRequest buildComputeBalanceRequest(String[] commands) throws Exception {
    Bank bank = InMemoryDb.getBankIfPresent(commands[1]);
    Customer customer = InMemoryDb.getCustomerIfPresent(commands[2]);
    Integer emiNumber = Integer.parseInt(commands[3]);

    return new ComputeBalanceRequest(bank, customer,emiNumber);

  }
}
