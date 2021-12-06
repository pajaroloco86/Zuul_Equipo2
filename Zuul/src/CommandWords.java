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
            if(getCommandWords().equals(wordToCheck))
                return true;
        }
        return false;
    }
}