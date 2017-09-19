package no.inga.blackjack;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Card {

    private final int scoreValue;
    private final Suit suit;
    private final String value;

    @JsonCreator
    Card(@JsonProperty("suit") Suit suit, @JsonProperty("value") String value) {
        this.suit = suit;
        this.value = value;
        this.scoreValue = determineScoreValue(value);
    }

    int getValue() {
        return scoreValue;
    }

    public String toString() {
        return suit.toString() +  value;
    }

    private static int determineScoreValue(String value) {
        int scoreValue;
        if (isValidNumber(value)) {
            scoreValue = Integer.parseInt(value);
        } else if (value.equals("J") || value.equals("Q") || value.equals("K")) {
            scoreValue = 10;
        } else if (value.equals("A")) {
            scoreValue = 11;
        } else {
            throw new RuntimeException("Cannot parse Card, " + value + " is not a valid card type");
        }
        return scoreValue;
    }

    private static boolean isValidNumber(String letter) {
        return letter.matches("^[1-9]0?$");
    }

}
