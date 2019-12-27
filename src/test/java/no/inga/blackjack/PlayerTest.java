package no.inga.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static no.inga.blackjack.Card.fromString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

   @Test
    public void should_stop_drawing_when_bail_out_litmit_reached() {
       Deck deck = new Deck();
       deck.addAll(Arrays.asList(fromString("D1"), fromString("SJ"), fromString("S5"), fromString("S1")));
       Player player = new Player("player", deck, 17);
       player.drawCard();
       assertFalse(player.isDone());
       player.drawCard();
       assertTrue(player.isDone());
      assertThrows(FinishedPlayingException.class, player::drawCard);
   }
}
