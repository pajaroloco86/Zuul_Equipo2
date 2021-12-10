package Tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Game.Game;

public class GameTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeTest
    public void beforeGame(){
        String fakeEntry = "go west\nquit game";
        System.setIn(new ByteArrayInputStream(fakeEntry.getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void gamePlay(){
        Game newGame = Game.getUniqueInstanceGame();
        //Cambiar por la ruta correspondiente o usar una relativa, si es que encuentras como 3:D
        newGame.playGame("D:/Documents/GIT/Zuul_Equipo2/Zuul/src/Tests/Example.json");
    }

    @AfterTest
    public void gameSucess(){
        System.setOut(standardOut);
        String output = new String(outputStreamCaptor.toByteArray());
        Assert.assertTrue(output.contains("Thank you for playing.  Good bye."));
        System.out.println("Test sucess");
    }
}
