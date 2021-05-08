package com.gradle.Uno;

public class UnoHand extends UnoCardBunch {
    public String toString() {
        String hand = "|";
        for (UnoCard card : this.cards)
            hand += card.toString() + "|";

        return hand;
    }

    public UnoCard findPlayableCard(UnoCard card) {
        for (UnoCard c : this.cards) {
            if (card.playable(c)) {
                return c;
            }
        }
        return null;
    }
}
