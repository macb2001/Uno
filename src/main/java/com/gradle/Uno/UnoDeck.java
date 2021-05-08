package com.gradle.Uno;

import java.util.Collection;
import java.util.Collections;

public class UnoDeck extends UnoCardBunch {

    public UnoDeck(boolean isDrawPile) {
        this.isDrawPile = isDrawPile;
    }

    public void initialize() {
        if (this.isDrawPile) {
            UnoCardFactory factory = new UnoCardFactory();
            final UnoCard.Colour[] colours = UnoCard.Colour.values();
            final UnoCard.Rank[] ranks = UnoCard.Rank.values();

            //Adding Wild cards (4 Plus-Fours, 4 Change-colours)
            for (int j = 13; j < ranks.length; j++) {
                for (int i = 0; i < 4; i++)
                    this.addCard(factory.createUnoCard(ranks[j], UnoCard.Colour.WILD));
            }

            for (int i = 0; i < colours.length - 1; i++) {
                //Adding single zero card
                this.addCard(factory.createUnoCard(UnoCard.Rank.ZERO, colours[i]));

                //Adding cards 1 - 9 & Special cards (two of each)
                for (int j = 1; j < ranks.length - 2; j++) {
                    for (int k = 0; k < 2; k++)
                        this.addCard(factory.createUnoCard(ranks[j], colours[i]));
                }
            }
        } else {
            throw new IllegalCallerException("Discard Pile Cannot Be Initialized!");
        }
    }

    public UnoCard getTopCard() {
        if (this.getSize() == 0) {
            throw new IllegalStateException("Deck is Empty!");
        } else {
            return this.cards.get(this.cards.size() -1);
        }
    }

    public void shuffle() {
        if (this.isDrawPile) {
            if (this.getSize() == 0) {
                throw new IllegalStateException("Deck is Empty!");
            } else {
                Collections.shuffle(this.cards);
            }
        } else {
            throw new IllegalCallerException("Discard Pile Cannot Be Shuffled!");
        }

    }

    public void recycle(UnoDeck d) {
        if (this.isDrawPile) {
            if (!d.isDrawPile) {
                if (this.getSize() == 0) {
                    for (int i = d.getSize() - 1; i >= 0; i--)
                        this.takeCard(d, d.cards.get(i));
                } else {
                    throw new IllegalStateException("Deck Is Not Empty!");
                }
            } else {
                throw new IllegalArgumentException("Cannot Recycle From Another Draw Pile!");
            }
        } else {
            throw new IllegalCallerException("Discard Pile Cannot Be Recycled!");
        }
    }

    private final boolean isDrawPile;
}
