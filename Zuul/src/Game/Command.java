package Game;

public class Command{
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord){
        this.commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }
}