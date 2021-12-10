package Tests;

import java.io.ByteArrayInputStream;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Game.Game;

public class GameTest {

    @BeforeTest
    public void setUserFakeEntry(){
        String fakeEntry = "go west\nquit game";
        System.setIn(new ByteArrayInputStream(fakeEntry.getBytes()));
    }

    @Test
    public void gamePlay(){
        Game newGame = Game.getUniqueInstanceGame();
        //Cambiar por la ruta correspondiente o usar una relativa, si es que encuentras como 3:D
        newGame.playGame("D:/Documents/GIT/Zuul_Equipo2/Zuul/src/Tests/Example.json");
    }
}
