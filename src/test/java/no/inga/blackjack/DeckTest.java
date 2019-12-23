package no.inga.blackjack;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    @Test
    public void shouldCreateNewDeck() {
        Deck deck = Deck.prepareNewShuffledDeck();
        assertEquals(52, deck.size());
    }

    @Test
    public void shouldReadDeckFromCsvFile() throws IOException {
        URL resource = getClass().getResource("deck.csv");

        Deck deck = Deck.prepareDeckFromFile(resource.getPath());

        String deckFromFile;
        try (FileReader fileReader = new FileReader(new File(resource.getPath())); BufferedReader br = new BufferedReader(fileReader)){
            deckFromFile = br.readLine();
        }

        assertEquals(deckFromFile, deck.stream().map(Card::toString).collect(Collectors.joining(", ")));
    }
}
