package ledgerclient;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LenderApplication
{
    public static void main(String[] args) throws FileNotFoundException {

      LedgerManager ledgerManager = new LedgerManager();
      String filePath = System.getProperty("user.dir") + "/src/main/java/ledgerclient/sample_io/INPUT1.txt";
      Scanner myReader = new Scanner(new FileReader(filePath));
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] commands = data.split(" ");
        String commandType = commands[0];
        switch (commandType) {
          case "LOAN":
            ledgerManager.takeLoan(commands[1], commands[2], Integer.valueOf(commands[3]),
                Integer.valueOf(commands[4]), Integer.valueOf(commands[5]));
            break;
          case "PAYMENT":
            ledgerManager.makePayment(commands[1], commands[2], Integer.valueOf(commands[3]), Integer.valueOf(commands[4]));
            break;
          case "BALANCE":
            ledgerManager.showBalance(commands[1], commands[2], Integer.valueOf(commands[3]));
            break;
        }
      }
      myReader.close();
    }
}