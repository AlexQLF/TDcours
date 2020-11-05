package fr.p10.miage.rps.model;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;
    List<RPSEnum> listMouv1;
    List<RPSEnum> listMouv2;

    @BeforeClass
    public void setUp() {

        rps = new RockPaperScissors();
        listMouv1 = List.of(RPSEnum.ROCK,RPSEnum.PAPER,RPSEnum.SCISSORS,RPSEnum.ROCK,RPSEnum.PAPER,RPSEnum.SCISSORS,RPSEnum.ROCK,RPSEnum.PAPER,RPSEnum.SCISSORS,RPSEnum.ROCK);
        listMouv2 = List.of(RPSEnum.PAPER,RPSEnum.SCISSORS,RPSEnum.ROCK,RPSEnum.PAPER,RPSEnum.SCISSORS,RPSEnum.ROCK,RPSEnum.PAPER,RPSEnum.SCISSORS,RPSEnum.ROCK,RPSEnum.PAPER);

    }

    @AfterClass
    public void tearDown() {

        rps = null;
        listMouv1 = null;
        listMouv2 = null;
    }

    @DataProvider(name="lostData")
    public Object [][] createLostData() {

        return new Object[][] {

                {RPSEnum.PAPER, RPSEnum.SCISSORS},

                {RPSEnum.SCISSORS, RPSEnum.ROCK},

                {RPSEnum.ROCK, RPSEnum.PAPER},

        } ;

    }

    @DataProvider(name="winData")
    public Object [][] createWinData() {

        return new Object[][] {

                {RPSEnum.PAPER, RPSEnum.ROCK},

                {RPSEnum.SCISSORS, RPSEnum.PAPER},

                {RPSEnum.ROCK, RPSEnum.SCISSORS},

        } ;

    }

    @DataProvider(name="tieData")
    public Object [][] createTieData() {

        return new Object[][] {

                {RPSEnum.PAPER, RPSEnum.PAPER},

                {RPSEnum.SCISSORS, RPSEnum.SCISSORS},

                {RPSEnum.ROCK, RPSEnum.ROCK},

        } ;

    }

    @DataProvider(name="playerLostData")
    public Object [][] createPlayerLostData() {

        return new Object[][] {

                {new Player("Alex",listMouv1), new Player("Nassim",listMouv2)},

        } ;

    }

    @DataProvider(name="playerWinData")
    public Object [][] createPlayerWinData() {

        return new Object[][] {

                {new Player("Alex",listMouv2), new Player("Nassim",listMouv1)},

        } ;

    }

    @DataProvider(name="playerTieData")
    public Object [][] createPlayerTieData() {

        return new Object[][] {

                {new Player("Alex",listMouv1), new Player("Nassim",listMouv1)},

        } ;

    }


    @Test ( dataProvider = "winData")
    public void testWinPlay (RPSEnum p1 ,RPSEnum p2 ){

        assertEquals(rps.play(p1, p2),Result.WIN);

    }

    @Test ( dataProvider = "tieData")
    public void testTiePlay (RPSEnum p1 ,RPSEnum p2 ){

        assertEquals(rps.play(p1, p2),Result.TIE);

    }

    @Test ( dataProvider = "lostData")
    public void testLostPlay (RPSEnum p1 ,RPSEnum p2 ){

        assertEquals(rps.play(p1, p2),Result.LOST);

    }

    @Test ( dataProvider = "playerWinData")
    public void testWinPlay2 (Player p1 ,Player p2 ){

        assertEquals(rps.play(p1, p2),Result.WIN);

    }

    @Test ( dataProvider = "playerLostData")
    public void testLostPlay2 (Player p1 ,Player p2 ){

        assertEquals(rps.play(p1, p2),Result.LOST);

    }

    @Test ( dataProvider = "playerTieData")
    public void testTiePlay2 (Player p1 ,Player p2 ){

        assertEquals(rps.play(p1, p2),Result.TIE);

    }
}