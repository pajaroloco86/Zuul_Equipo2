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
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoomNorthExit();
                break;
            case "east":
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoomEastExit();
                break;
            case "south":
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoomSouthExit();
                break;
            case "west":
                nextRoom = Game.getUniqueInstanceGame().getCurrentRoomWestExit();
                break;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            Game.getUniqueInstanceGame().setCurrentRoom(nextRoom);
        }
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
