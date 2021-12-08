public class Game {
    private static Game uniqueInstanceGame;
    private Room currentRoom;
    private UserEntry userEntry;
    private ProcessCommand processCommand;
    private MessagesGame messagesGame;

    public static Game getUniqueInstanceGame(){
        if(uniqueInstanceGame == null){
            uniqueInstanceGame = new Game();
        }
        return uniqueInstanceGame;
    }

    private Game(){
        userEntry = new UserEntry();
        processCommand = new ProcessCommand();
        messagesGame = new MessagesGame();
        //Aqui hay que ajustar con Alexis
        createRooms();
    }

    //Aqui hay que ajustar con Alexis
    private void createRooms(){
        Room outside, theatre, pub, lab, office;
      
        outside = new Room("outside, the main entrance of the university.");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        outside.setExits(null, theatre, lab, pub);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        currentRoom = outside; 
    }

    public void playGame() {
        boolean gameOver = false;

        messagesGame.welcomeMessage();
        
        while(!gameOver) {
            messagesGame.exitsCurrentRoom(getCurrentRoom());
            gameOver = getCommandGame();
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    public boolean getCommandGame(){
        Command command = userEntry.readValidEntry();
        return processCommand.processCommand(command);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoomNorthExit() {
        return getCurrentRoom().getNorthExit();
    }

    public Room getCurrentRoomSouthExit() {
        return getCurrentRoom().getSouthExit();
    }

    public Room getCurrentRoomEastExit() {
        return getCurrentRoom().getEastExit();
    }

    public Room getCurrentRoomWestExit() {
        return getCurrentRoom().getWestExit();
    }
}
