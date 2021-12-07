public class MessagesGame {

    public void welcomeMessage(){

    }

    public void locationMessage(Room room){
        System.out.println("You are in " + room.description);
        System.out.println("Please, type a valid command");
        System.out.println("> ");
    }

    public void helpMessage(){
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }
}
