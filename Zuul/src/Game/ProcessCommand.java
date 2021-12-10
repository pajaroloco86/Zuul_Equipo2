package Game;

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
                wantToQuit = isQuitCommand(command);
                break;
        }
        return wantToQuit;
    }

    private void optionHelp() {
        messagesGame.helpMessage();
    }

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

        if ((nextRoom == null) || (!direction.equals("north") && !direction.equals("east") && !direction.equals("west") && !direction.equals("south"))) {
            messagesGame.wrongDirection();
        }
        else {
            Game.getUniqueInstanceGame().setCurrentRoom(nextRoom);
        }
    }

    private boolean isQuitCommand(Command command){
        if(command.getSecondWord().equals("game")) {
            return true;
        }
        else {
            messagesGame.quitWhat();
            return false;
        }
    }
}
