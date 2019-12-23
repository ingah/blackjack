package no.inga.blackjack;

enum Suit {
    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C");

    private String symbolLetter;

    Suit(String symbolLetter) {
        this.symbolLetter = symbolLetter;
    }

    @Override
    public String toString() {
        return symbolLetter;
    }

    public static Suit parse(String s) {
        for (Suit suit : Suit.values()) {
            if (suit.symbolLetter.equalsIgnoreCase(s)) {
                return suit;
            }
        }
        throw new RuntimeException("Could not parse Suite, " + s + " is not a valid suit");
    }
}