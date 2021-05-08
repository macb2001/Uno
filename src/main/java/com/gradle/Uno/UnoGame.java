package com.gradle.Uno;

import java.util.ArrayList;

public class UnoGame {

    public void play() {

    }

    public void setPlayers() {

    }



    public UnoCard.Colour getCurrentColour() {
        return this.currentColour;
    }

    public boolean getClockwise() {
        return this.clockwise;
    }

    public UnoDeck getDrawPile() {
        return this.drawPile;
    }

    public UnoDeck getDiscardPile() {
        return this.discardPile;
    }

    private ArrayList<UnoPlayer> players = new ArrayList<UnoPlayer>();
    private UnoDeck drawPile = new UnoDeck(true);
    private UnoDeck discardPile = new UnoDeck(false);
    private UnoCard.Colour currentColour;
    private boolean clockwise;
}
