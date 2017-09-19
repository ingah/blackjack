package no.inga.blackjack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static junit.framework.TestCase.assertFalse;
import static no.inga.blackjack.CardBuilder.fromString;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

   @Test(expected = FinishedPlayingException.class)
    public void should_stop_drawing_when_bail_out_litmit_reached() {
       Stack<Card> deck = new Stack<>();
       deck.addAll(Arrays.asList(fromString("D1"), fromString("SJ"), fromString("S5"), fromString("S1")));
       Player player = new Player("player", deck, 17);
       player.drawCard();
       assertFalse(player.isDone());
       player.drawCard();
       assertTrue(player.isDone());
       player.drawCard();
   }
}
