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
        Suit suit = Suit.parse(cardRepresentation.substring(0, 1));
        return new Card(suit, value);
    }

    private static int determineScoreValueFromLetter(String letter) {
        if (letter.equals("J") || letter.equals("Q") || letter.equals("K")) {
            return 10;
        } else if (letter.equals("A")) {
            return 11;
        } else {
            return parseToInt(letter);
        }
    }

    private static int parseToInt(String letter) {
        try {
            return Integer.parseInt(letter);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("Cannot parse Card, " + letter + " is not a valid card type", nfe);
        }
    }

}
