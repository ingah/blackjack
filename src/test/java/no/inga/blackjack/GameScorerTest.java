package no.inga.blackjack;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameScorerTest {

    @Test
    public void should_determine_score_of_a_hand() {
        assertEquals(14, GameScorer.score(Arrays.asList(new Card(Suit.HEARTS, "7"), new Card(Suit.CLUBS, "7"))));
        assertEquals(21, GameScorer.score(Arrays.asList(new Card(Suit.HEARTS, "7"), new Card(Suit.CLUBS, "7"), new Card(Suit.DIAMONDS, "7"))));
        assertEquals(17, GameScorer.score(Arrays.asList(new Card(Suit.HEARTS, "6"), new Card(Suit.CLUBS, "1"), new Card(Suit.DIAMONDS, "K"))));
        assertEquals(18, GameScorer.score(Arrays.asList(new Card(Suit.HEARTS, "6"), new Card(Suit.CLUBS, "1"), new Card(Suit.DIAMONDS, "A"))));
    }

}
