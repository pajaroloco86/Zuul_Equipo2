import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser 
{
    private CommandWords commands; 
    private UserEntry userEntry; 

    public Parser() 
    {
        commands = new CommandWords();
    }

    public Command getCommand() 
    { 
        String firstWord = null;
        String secondWord = null;
        userEntry = new UserEntry();

        System.out.print("> ");

        if(commands.isCommand(firstWord)) {
            return new Command(firstWord, secondWord);
        }
        else {
            return new Command(null, secondWord); 
        }
    }
}