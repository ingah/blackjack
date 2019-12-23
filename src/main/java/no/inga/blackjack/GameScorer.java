package no.inga.blackjack;

import java.util.List;

class GameScorer {

    static int score(List<Card> cards) {
        return cards.stream().mapToInt(Card::getValue).sum();
    }
}
