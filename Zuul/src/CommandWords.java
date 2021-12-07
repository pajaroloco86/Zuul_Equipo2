import java.util.Arrays;

public class CommandWords
{
    private final String[] validCommands = {
        "go", "quit", "help"
    };

    public String[] getCommandWords(){
        return this.validCommands;
    }

    public boolean isCommand(String wordToCheck)
    {
        for(int i = 0; i < getCommandWords().length; i++) {
            if(Arrays.stream(getCommandWords()).anyMatch(wordToCheck::equals))
                return true;
        }
        return false;
    }
}