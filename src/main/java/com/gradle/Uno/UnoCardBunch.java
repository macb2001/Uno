package com.gradle.Uno;

import java.util.ArrayList;

public class UnoCardBunch {
    public void addCard(UnoCard c) {
        this.cards.add(c);
    }

    public void removeCard(UnoCard c) {
        if (this.getSize() == 0) {
            throw new IllegalStateException("Is Empty! Cannot Remove!");
        } else {
            this.cards.remove(c);
        }
    }

    public void takeCard(UnoCardBunch b, UnoCard c) {
        this.addCard(c);
        b.removeCard(c);
    }

    public int getSize() {
        return this.cards.size();
    }

    protected ArrayList<UnoCard> cards = new ArrayList<UnoCard>();
}
