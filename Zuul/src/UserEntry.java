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

        if(!Arrays.stream(commandWords.getCommandWords()).anyMatch(userWords[0]::equals)){
            messagesGame.invalidCommandWord();
            return false;
        }

        //Refactoring
        if(userWords[0].equals("help")){
            if(userWords.length > 1){
                return false;
            }
        }
        
        if(!(userWords.length == 2 || userWords.length == 1)) {    
            messagesGame.userWordsLength();
            return false;
        }

        setFirstWord(userWords[0]);
        setSecondWord(userWords[1]);

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
}