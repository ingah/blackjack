package no.inga.blackjack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static no.inga.blackjack.GameScorer.*;
 class Player {

    private final String playerName;
    private final Deck deck;
    private final List<Card> hand = new ArrayList<>();
    private int bailOutLimit;
    private boolean done = false;
     Player(String playerName, Deck deck, int bailOutLimit) {
        this(playerName, deck);
        this.bailOutLimit = bailOutLimit;
    }

    Player(String playerName, Deck deck) {
        this.playerName = playerName;
        this.deck = deck;
        drawInitialCards();
    }

    void setBailOutLimit(int bailOutLimit) {
        this.bailOutLimit = bailOutLimit;
    }

    private void drawInitialCards() {
        hand.add(deck.pop());
        hand.add(deck.pop());
    }

    String getPlayerName() {
        return playerName;
    }

    int getCurrentScore() {
        return score(hand);
    }

    boolean isDone() {
        return done;
    }

    void drawCard(){
        if(done) {
            throw new FinishedPlayingException("I've already told you, I'm done!");
        }
        hand.add(deck.pop());
        if(score(hand) >= bailOutLimit) {
            done = true;
        }
    }

    String getResults() {
        return hand.stream().map(Card::toString).collect(Collectors.joining(", "));
    }
}
