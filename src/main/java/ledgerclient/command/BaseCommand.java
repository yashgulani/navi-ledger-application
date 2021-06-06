package ledgerclient.command;

public abstract class BaseCommand {

//  protected LedgerManager ledgerManager;

  // to do add exception
  public abstract void execute(String[] commands) throws Exception;

}
