public class ProcessCommand {
    private MessagesGame messagesGame;

    public ProcessCommand(){
        messagesGame = new MessagesGame();
    }

    public boolean processCommand(Command command) {
        boolean wantToQuit = false;
        String commandWord = command.getCommandWord();

        switch (commandWord){
            case "help":
                optionHelp();
                break;
            case "go":
                processDirectioner(command);
                break;
            case "quit":
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    private void optionHelp() {
        messagesGame.helpMessage();
    }

    //Nulos creo que deben cambiarse
    private void processDirectioner(Command command) {
        String direction = command.getSecondWord();
        Room nextRoom = null;

        switch (direction){
            case "north":
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoom().getNorthExit();
                break;
            case "east":
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoom().getEastExit();
                break;
            case "south":
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoom().getSouthExit();
                break;
            case "west":
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoom().getWestExit();
                break;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            goRoom(nextRoom);
        }
    }

    private void goRoom(Room nextRoom){
        Game.getUniqueInstanceGame().setCurrentRoom(nextRoom);
        System.out.println("You are " + Game.getUniqueInstanceGame().getCurrentRoom().getDescription());
        System.out.print("Exits: ");
        if(Game.getUniqueInstanceGame().getCurrentRoom().northExit != null) {
            System.out.print("north ");
        }
        if(Game.getUniqueInstanceGame().getCurrentRoom().eastExit != null) {
            System.out.print("east ");
        }
        if(Game.getUniqueInstanceGame().getCurrentRoom().southExit != null) {
            System.out.print("south ");
        }
        if(Game.getUniqueInstanceGame().getCurrentRoom().westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    private boolean quit(Command command){
        if(command.getSecondWord().equals("game")) {
            return true;
        }
        else {
            System.out.println("Quit what?");
            return false;
        }
    }
}
