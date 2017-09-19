package no.inga.blackjack;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Stack;

public class Main {

    private static String deckUrl = "";

    public static void main(String args[]) {
        if (args.length > 0) {
            deckUrl = args[0];
        } else {
            System.out.println("Using defalt deck URL " + deckUrl + ". For different deck URL, provide it as command line parameter.");
        }
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<Stack<Card>> cardType = new ParameterizedTypeReference<Stack<Card>>() {};
        ResponseEntity<Stack<Card>> response = restTemplate.exchange(deckUrl, HttpMethod.GET, null, cardType);
        Game.runGame(response.getBody());
    }
}
