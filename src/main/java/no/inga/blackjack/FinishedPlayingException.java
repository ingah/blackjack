package no.inga.blackjack;

class FinishedPlayingException extends RuntimeException {
    FinishedPlayingException(String s) {
        super(s);
    }
}
