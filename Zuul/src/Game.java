public class Game {
    private static Game uniqueInstanceGame;
    private Room currentRoom;
    private UserEntry userEntry;
    private ProcessCommand processCommand;
    private MessagesGame messagesGame;

    public static Game getUniqueInstanceGame() {
        if (uniqueInstanceGame == null) {
            uniqueInstanceGame = new Game();
        }
        return uniqueInstanceGame;
    }

    private Game() {
        userEntry = new UserEntry();
        processCommand = new ProcessCommand();
        messagesGame = new MessagesGame();
        createRooms();
    }

    //El archivo de entrada tiene que ser de tipo JSON con el siguiente formato:
    //{"ROOM":{"description":"", "northRoom": "value","eastRoom":"value","westRoom":"value","southRoom":"value"}}
    private void createRooms() {
        try {
            JSONParser jsonData = new JSONParser("src/Example.json");
            String[] roomKeys = jsonData.getRoomsKeys();
            Room[] rooms = new Room[roomKeys.length];

            for (int i = 0; i < roomKeys.length; i++) {
                rooms[i] = new Room(jsonData.getRoomDescription(roomKeys[i]));
            }

            for (int i = 0; i < rooms.length; i++) {
                String[] togheterRooms = jsonData.getTogetherRooms(roomKeys[i]);

                Room northRoom = searchRoomIndexBykey(togheterRooms[0], roomKeys, rooms);
                Room eastRoom = searchRoomIndexBykey(togheterRooms[1], roomKeys, rooms);
                Room westRoom = searchRoomIndexBykey(togheterRooms[2], roomKeys, rooms);
                Room southRoom = searchRoomIndexBykey(togheterRooms[3], roomKeys, rooms);

                rooms[i].setExits(northRoom, eastRoom, southRoom, westRoom);
            }
            currentRoom = rooms[0];
        } catch (Exception e) {
            System.out.println("Error en la creación de los cuartos");
        }
    }

    private Room searchRoomIndexBykey(String roomKey, String[] roomsKeys, Room[] rooms) {
        for (int j = 0; j < roomsKeys.length; j++) {
            if (roomKey.equals(roomsKeys[j])) {
                return rooms[j];
            }
        }
        return null;
    }

    public void playGame() {
        boolean gameOver = false;

        messagesGame.welcomeMessage();

        while (!gameOver) {
            messagesGame.exitsCurrentRoom(getCurrentRoom());
            gameOver = getCommandGame();
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    public boolean getCommandGame() {
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
