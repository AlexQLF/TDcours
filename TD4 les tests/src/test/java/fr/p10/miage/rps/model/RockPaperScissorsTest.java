package fr.p10.miage.rps.model;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;
    Player p1;
    Player p2;

    @BeforeClass
    public void setUp() {

        rps = new RockPaperScissors();
        p1 = new Player("Alex");
        p2 = new Player("Nassim");

    }

    @AfterClass
    public void tearDown() {

        rps = null;
        p1 = null;
        p2 = null;

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

    @Test
    public void testWinPlay2 (Player p1 ,Player p2 ){

        assertEquals(rps.play(p1, p2),Result.WIN);

    }

    @Test
    public void testTiePlay2 (Player p1 ,Player p2 ){

        assertEquals(rps.play(p1, p2),Result.TIE);

    }

    @Test
    public void testLostPlay2 (Player p1 ,Player p2 ){

        assertEquals(rps.play(p1, p2),Result.LOST);

    }

}