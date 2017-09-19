package no.inga.blackjack;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import static no.inga.blackjack.CardBuilder.fromString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void inga_should_win_when_score_is_closest_to_21() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Game game = new Game();
        Stack<Card> deck = new Stack<>();
        deck.add(fromString("HK"));
        deck.add(fromString("HQ"));
        deck.add(fromString("SQ")); //19
        deck.add(fromString("H6")); // initial card for Sam
        deck.add(fromString("H2")); // initial card for Sam
        deck.add(fromString("S6"));
        deck.add(fromString("S3"));
        game.runGame(deck);

        System.out.flush();
        System.setOut(old);
        assertTrue(deck.empty());
        assertEquals("Winner: Inga\n" +
                "Inga:\t 19 | S3, S6, SQ\n" +
                "Sam:\t 28 | H2, H6, HQ, HK", baos.toString());
    }

    @Test
    public void sam_should_win_when_score_is_closest_to_21() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Game game = new Game();
        Stack<Card> deck = new Stack<>();
        deck.add(fromString("H7"));
        deck.add(fromString("H2")); // initial card for Sam
        deck.add(fromString("SQ")); // initial card for Sam
        deck.add(fromString("S7"));
        deck.add(fromString("S10"));

        game.runGame(deck);

        System.out.flush();
        System.setOut(old);
        assertTrue(deck.empty());
        assertEquals("Winner: Sam\n" +
                "Sam:\t 12 | SQ, H2\n" +
                "Inga:\t 24 | S10, S7, H7", baos.toString());
    }

    @Test
    public void inga_should_lose_when_her_score_is_over_21() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Game game = new Game();
        Stack<Card> deck = new Stack<>();
        deck.add(fromString("SK")); // I score 26
        deck.add(fromString("S1")); // initial card for Sam
        deck.add(fromString("H1")); // initial card for Sam
        deck.add(fromString("SQ"));
        deck.add(fromString("S6"));

        game.runGame(deck);

        System.out.flush();
        System.setOut(old);
        assertTrue(deck.empty());
        assertEquals("Winner: Sam\n" +
                "Sam:\t 2 | H1, S1\n" +
                "Inga:\t 26 | S6, SQ, SK", baos.toString());
    }

    @Test
    public void sam_should_lose_when_his_score_is_over_21() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Game game = new Game();
        Stack<Card> deck = new Stack<>();
        deck.add(fromString("SK"));
        deck.add(fromString("S2")); // Inga scores 18
        deck.add(fromString("S7")); // initial card for Sam
        deck.add(fromString("HK")); // initial card for Sam
        deck.add(fromString("SQ"));
        deck.add(fromString("S6"));

        game.runGame(deck);

        System.out.flush();
        System.setOut(old);
        assertTrue(deck.empty());
        assertEquals("Winner: Inga\n" +
                "Inga:\t 18 | S6, SQ, S2\n" +
                "Sam:\t 27 | HK, S7, SK", baos.toString());
    }

    @Test
    public void inga_should_win_when_initial_score_is_21() { // In theory both may have 21, but no requirements are defined for this case.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Game game = new Game();
        Stack<Card> deck = new Stack<>();
        deck.add(fromString("S1"));
        deck.add(fromString("S2"));
        deck.add(fromString("SK"));
        deck.add(fromString("SA"));

        game.runGame(deck);

        System.out.flush();
        System.setOut(old);
        assertTrue(deck.empty());
        assertEquals("Winner: Inga\n" +
                "Inga:\t 21 | SA, SK\n" +
                "Sam:\t 3 | S2, S1", baos.toString());
    }

    @Test
    public void sam_should_win_when_initial_score_is_21() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Game game = new Game();
        Stack<Card> deck = new Stack<>();
        deck.add(fromString("SK"));
        deck.add(fromString("SA"));
        deck.add(fromString("S1"));
        deck.add(fromString("S2"));

        game.runGame(deck);

        System.out.flush();
        System.setOut(old);
        assertTrue(deck.empty());
        assertEquals("Winner: Sam\n" +
                "Sam:\t 21 | SA, SK\n" +
                "Inga:\t 3 | S2, S1", baos.toString());

    }
}
