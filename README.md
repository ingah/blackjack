Rules

* To players, you and Sam are playing against each other.
* Each player draw two cards each from the top of a randomly shuffled deck of cards.
* You draw the two first cards, Sam draws the two next.
* Calculate the score for each player.
    * Numeric cards are scored one to ten.
    * Jack, Queen, King are scored as ten.
    * Ace are scored as eleven.
* Determine if one player has 21 points - Blackjack - with their initial cards, and thus win the game.
* If nobody has 21 points, the players will draw cards from the top of the dec.
    * You must stop drawing cards when your score is 17 or higher.
    * You lose the game if your score is higher than 21.
    * When you stop drawing cards, Sam starts drawing cards.
    * Sam stops drawing cards when his score is higher than yours.
    * Sam lose the game if his score is higher than 21.
* Print out who wins the game.
* Print out score and each player's cards by the end of the game. A card is specified by it's suit and value:
    * suit -> [H|D|S|C]
    * value -> [2|3|4|5|6|7|8|9|10|J|Q|K|A]
* Example output:

```
  Winner: Charlie

  Sam | 27 | S7,S10,CJ
  Charlie  | 19 | D2,H2,C6,H9
  {code}
```