package no.inga.blackjack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Deck {
    private Stack<Card> deck;

    Deck() {
        deck = new Stack<>();
    }

    private Deck(Stack<Card> deck) {
        this.deck = deck;
    }

    static Deck prepareNewShuffledDeck() {
        Stack<Card> deck = new Stack<>();

        for (Suit suit : Suit.values()) {
            IntStream.range(2, 11).forEach(it -> deck.add(new Card(suit, String.valueOf(it))));
            deck.add(new Card(suit, "J"));
            deck.add(new Card(suit, "Q"));
            deck.add(new Card(suit, "K"));
            deck.add(new Card(suit, "A"));
        }
        Collections.shuffle(deck);
        return new Deck(deck);
    }

    static Deck prepareDeckFromFile(String path) throws IOException {
        try (FileReader fileReader = new FileReader(new File(path)); BufferedReader br = new BufferedReader(fileReader)){
            List<String> cards = Arrays.asList(br.readLine().split(", "));
            Deck deck = new Deck();
            cards.forEach(it -> deck.add(Card.fromString(it)));
            return deck;
        }
    }

    void add(Card card) {
        deck.add(card);
    }

    Card pop() {
        return deck.pop();
    }

    int size() {
        return deck.size();
    }

    boolean empty() {
        return deck.empty();
    }

    Stream<Card> stream() {
        return deck.stream();
    }

    void addAll(List<Card> cards) {
        deck.addAll(cards);
    }
}
