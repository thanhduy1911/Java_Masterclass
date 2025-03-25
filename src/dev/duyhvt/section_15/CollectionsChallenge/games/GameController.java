package dev.duyhvt.section_15.CollectionsChallenge.games;

import dev.duyhvt.section_15.CollectionsChallenge.games.poker.PokerGame;

public class GameController {
    public static void main(String[] args) {
        PokerGame fiveCardDraw = new PokerGame(8, 5);
        fiveCardDraw.startPlay();
    }
}
