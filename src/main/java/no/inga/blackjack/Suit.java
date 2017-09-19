package no.inga.blackjack;

enum Suit {
    SPADES("SPADES"),
    HEARTS("HEARTS"),
    DIAMONDS("DIAMONDS"),
    CLUBS("CLUBS");

    private String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol.substring(0,1);
    }
}