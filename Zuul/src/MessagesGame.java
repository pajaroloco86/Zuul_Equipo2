public class MessagesGame {

    public void welcomeMessage(){
        separationLine();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly adventure game.");
        System.out.println("Type 'help' if you need help.\n");
    }

    public void invalidCommandWord(){
        separationLine();
        System.out.println("I don't know what you mean..." + 
        "\nTry again, remember the first word should be a CommandWord:\n" +
        "'help','go','quit'");            
    }

    public void exitsCurrentRoom(Room room){
        separationLine();
        System.out.println("You are in " + room.description);
        
        System.out.print("Exits: ");
        if(room.getNorthExit() != null) {
            System.out.print("north ");
        }
        if(room.getEastExit() != null) {
            System.out.print("east ");
        }
        if(room.getSouthExit() != null) {
            System.out.print("south ");
        }
        if(room.getWestExit() != null) {
            System.out.print("west ");
        }
        System.out.println("\nPlease, type a valid command");
    }

    public void helpMessage(){
        separationLine();
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println("\nYour command words are:");
        System.out.println("'go' 'quit' 'help'\n");
    }

    public void userWordsLength(){
        separationLine();
        System.out.println("Only two words allowed! or type 'help'. Try again");
        System.out.println("Your command words are:");
        System.out.println("'go DIRECTION' 'quit game' 'help'\n");
    }

    private void separationLine(){
        System.out.println("\n\n*********************************************************************");
    }
}
