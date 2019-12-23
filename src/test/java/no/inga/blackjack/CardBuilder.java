package no.inga.blackjack;

class CardBuilder {

    static Card fromString(String cardRepresentation) {
        String value = cardRepresentation.substring(1);
        Suit suit = parseSuit(cardRepresentation.substring(0, 1));
        return new no.inga.blackjack.Card(suit, value);
    }

    private static Suit parseSuit(String symbol) {
        if (symbol.equals("S")) {
            return Suit.SPADES;
        } else if (symbol.equals("H")) {
            return Suit.HEARTS;
        } else if (symbol.equals("D")) {
            return Suit.DIAMONDS;
        } else if (symbol.equals("C")) {
            return Suit.CLUBS;
        }
        throw new RuntimeException("Could not parse Suite, " + symbol + " is not a valid suit");
    }
}
