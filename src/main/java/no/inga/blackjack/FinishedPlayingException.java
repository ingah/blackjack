package no.inga.blackjack;

public class FinishedPlayingException extends RuntimeException {
    public FinishedPlayingException(String s) {
        super(s);
    }
}
