import java.util.Arrays;
import java.util.Scanner;

public class UserEntry {
    private String firstWord;
    private String secondWord;
    private CommandWords commandWords;
    private MessagesGame messagesGame;
    private Scanner reader;

    public UserEntry(){
        commandWords = new CommandWords();
        messagesGame = new MessagesGame();
    }

    public Command readValidEntry() {
        boolean isCommand = false;

        while(!isCommand){
            reader = new Scanner(System.in);
            String userEntry = reader.nextLine();
            isCommand = validateEntry(userEntry.toLowerCase());
        }
        return new Command(getFirstWord(),getSecondWord());
    }

    private boolean validateEntry(String userEntry) {
        String[] userWords = userEntry.split(" ");
       
        if(isCommandWord(userWords[0])){
            messagesGame.invalidCommandWord();
            return false;
        }

        else if(!(userWords.length == 2 || userWords.length == 1)) {    
            messagesGame.userWordsLength();
            return false;
        }

        else if(userWords[0].equals("help")){
            setFirstWord(userWords[0]);
            return true;
        }

        else if(userWords.length == 2){
            setSecondWord(userWords[1]);
        }

        setFirstWord(userWords[0]);

        return true;
    }

    public String getFirstWord(){
        return this.firstWord;
    }

    public String getSecondWord(){
        return this.secondWord;
    }

    public void setFirstWord(String firstWord){
        this.firstWord = firstWord;
    }

    public void setSecondWord(String secondWord){
        this.secondWord = secondWord;
    }

    private boolean isCommandWord(String WordToCheck){
       return !Arrays.stream(commandWords.getCommandWords()).anyMatch(WordToCheck::equals);
    }
}