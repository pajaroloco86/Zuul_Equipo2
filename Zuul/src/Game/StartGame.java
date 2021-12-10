package Game;

public class StartGame {
    public static void main(String[] args) {
        Game newGame = Game.getUniqueInstanceGame();
        newGame.playGame("./Zuul/src/Game/Example.json");
    }
}