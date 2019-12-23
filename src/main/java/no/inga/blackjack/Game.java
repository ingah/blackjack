package no.inga.blackjack;


import java.util.Stack;

class Game {

    private static final int TARGET_SCORE = 21;

    static void runGame(Stack<Card> deck) {
        Player inga = new Player("Inga", deck, 17);
        Player sam = new Player("Sam", deck);

        if (inga.getCurrentScore() == TARGET_SCORE) {
            printResults(inga, sam);
            return;
        }
        if (sam.getCurrentScore() == TARGET_SCORE) {
            printResults(sam, inga);
            return;
        }
        while (!inga.isDone()) {
            inga.drawCard();
        }
        int ingascore = inga.getCurrentScore();
        if (inga.getCurrentScore() > TARGET_SCORE) {
            printResults(sam, inga);
            return;
        }

        sam.setBailOutLimit(++ingascore);
        while (!sam.isDone()) {
            sam.drawCard();
        }

        if (sam.getCurrentScore() > TARGET_SCORE) {
            printResults(inga, sam);
        } else {
            printResults(sam, inga);
        }
    }

    private static void printResults(Player winner, Player loser) {
        System.out.println("Winner: " + winner.getPlayerName());
        System.out.println(winner.getPlayerName() + ":\t " + winner.getCurrentScore() + " | " + winner.getResults());
        System.out.print(loser.getPlayerName() + ":\t " + loser.getCurrentScore() + " | " + loser.getResults());
    }
}
