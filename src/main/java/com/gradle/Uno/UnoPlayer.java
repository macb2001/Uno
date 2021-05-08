package com.gradle.Uno;

public class UnoPlayer {
    public UnoPlayer(String name, boolean human) {
        this.name = name;
        this.human = human;
    }

    public void drawCards(int n, UnoDeck d) {
        for (int i = 0; i < n; i++)
            this.hand.addCard(d.getTopCard());
    }

    public boolean getHuman() {
        return this.human;
    }

    public String getName() {
        return this.name;
    }



    private UnoHand hand = new UnoHand();
    private String name;
    private boolean human;
}
