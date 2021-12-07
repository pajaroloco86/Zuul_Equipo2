import java.util.Arrays;
import java.util.Scanner;

public class UserEntry {
    private String firstWord;
    private String secondWord;
    private CommandWords commandWords;
    private Scanner reader;

    public UserEntry(){
        commandWords = new CommandWords();
    }

    public Command readValidEntry() {
        boolean isCommand = false;

        while(!isCommand){
            reader = new Scanner(System.in);
            String userEntry = reader.nextLine();
            isCommand = validateEntry(userEntry);
        }

        return new Command(getFirstWord(),getSecondWord());
    }

    //Hacer más verificaciones puede ingresar solo go y falla
    //convertir a minusculas
    //aceptar que puede ser solohelp y es valido
    private boolean validateEntry(String userEntry) {
        String[] userWords = userEntry.split(" ");

        if(userWords.length > 2 || userWords.length < 1) {
            System.out.println("No. Only two words allowed!. Try again");
            return false;
        }else if(!Arrays.stream(commandWords.getCommandWords()).anyMatch(userWords[0]::equals)){
            System.out.println("I don't know what you mean...");
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