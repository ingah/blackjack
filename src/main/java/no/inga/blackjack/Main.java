package no.inga.blackjack;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Deck deck;
        if(args.length == 1) {
            deck = Deck.prepareDeckFromFile(args[0]);
        } else if (args.length == 0) {
            deck = Deck.prepareNewShuffledDeck();
        } else {
            System.out.println("Please provide only one or no parameters");
            return;
        }

        Game.runGame(deck);
    }
}
