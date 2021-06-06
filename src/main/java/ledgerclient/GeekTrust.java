package ledgerclient;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import ledgerclient.factory.CommandFactory;

public class GeekTrust
{
    public static void main(String[] args) throws Exception {

      String filePath = args[0];
      Scanner myReader = new Scanner(new FileReader(filePath));
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] commands = data.split(" ");
        String commandType = commands[0];
        CommandFactory factory = new CommandFactory();
        try {
          factory.providesCommand(commandType).execute(commands);
        }
        catch (Exception e) {
          System.out.println(String.format("Error Occured while executing command %s with message %s",
              Arrays.toString(commands), e.getMessage()));
        }
      }
      myReader.close();
    }
}