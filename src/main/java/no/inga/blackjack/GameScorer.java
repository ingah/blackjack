package no.inga.blackjack;

import java.util.List;

public class GameScorer {

    public static int score(List<Card> cards) {
        return cards.stream().mapToInt(Card::getValue).sum();
    }
}
