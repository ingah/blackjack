package no.inga.blackjack;

class Card {

    private final int scoreValue;
    private final Suit suit;
    private final String value;

    Card(Suit suit, String value) {
        this.suit = suit;
        this.value = value;
        this.scoreValue = determineScoreValueFromLetter(value);
    }

    int getValue() {
        return scoreValue;
    }

    public String toString() {
        return suit.toString() + value;
    }

    static Card fromString(String cardRepresentation) {
        String value = cardRepresentation.substring(1);
        Suit suit = Suit.parse(cardRepresentation.substring(0,1));
        return new Card(suit, value);
    }

    private static int determineScoreValueFromLetter(String letter) {
        int value;
        try {
            value = Integer.parseInt(letter);
        } catch (NumberFormatException nfe) {
            if (letter.equals("J") || letter.equals("Q") || letter.equals("K")) {
                value = 10;
            } else if (letter.equals("A")) {
                value = 11;
            } else {
                throw new RuntimeException("Cannot parse Card, " + letter + " is not a valid card type");
            }
        }
        return value;
    }

}
