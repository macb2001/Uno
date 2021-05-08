package com.gradle.Uno;

public class UnoCardFactory {
    public UnoCard createUnoCard(UnoCard.Rank r, UnoCard.Colour c) {
        if (((r != UnoCard.Rank.PLUSFOUR && r != UnoCard.Rank.CHANGECOLOUR) && c == UnoCard.Colour.WILD)
                || ((r == UnoCard.Rank.PLUSFOUR || r == UnoCard.Rank.CHANGECOLOUR) && c != UnoCard.Colour.WILD))
            throw new IllegalArgumentException("Invalid Card!");

        return new UnoCard(r, c);
    }
}
