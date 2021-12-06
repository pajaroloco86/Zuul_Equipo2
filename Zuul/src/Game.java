public class Game {
    private Room currentRoom;
    Parser parser = new Parser();

    public Game(){
        createRooms();
    }

    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        outside = new Room("outside the main entrance of the university");
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

    public void play() 
    {            
        boolean finished = false;
        do {
            Command command = parser.getCommand();
        } while(! finished);
        System.out.println("Thank you for playing.  Good bye.");
    }
}
