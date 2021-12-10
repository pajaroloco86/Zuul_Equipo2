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
        else if(numberOfWordsExceeded(userWords)) {    
            messagesGame.userWordsLength();
            return false;
        }
        else if(avoidNullInSecondWord(userWords)){
            setFirstWord(userWords[0]);
            setSecondWord("");
            return true;
        }
        else if(isDirectionMissing(userWords)){
            messagesGame.missingDirection();
            return false;
        }
        
        else if(helpPlusOtherWords(userWords)){
            messagesGame.justTypeHelp();
            setSecondWord("");
            return false;
        }
        else if(userWords.length == 2){
            setSecondWord(userWords[1]);
        }

        setFirstWord(userWords[0]);

        return true;
    }

    private boolean isCommandWord(String WordToCheck){
        return !Arrays.stream(commandWords.getCommandWords()).anyMatch(WordToCheck::equals);
     }
 
     private boolean avoidNullInSecondWord(String[] userWords){
         return ((userWords[0].equals("help") || userWords[0].equals("quit")) && userWords.length == 1);
     }
 
     private boolean numberOfWordsExceeded(String[] userWords){
         return !(userWords.length == 2 || userWords.length == 1);
     }
     
     private boolean isDirectionMissing(String[] userWords){
         return (userWords[0].equals("go") && userWords.length == 1);
 
     }
     
     private boolean helpPlusOtherWords(String[] userWords){
         return userWords[0].equals("help") && userWords.length != 1;
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