package com.gradle.Uno;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.FontUIResource;

import static org.junit.jupiter.api.Assertions.*;

class UnoHandTest {
    @Test
    void toStringTest() {
        UnoHand h = new UnoHand();
        UnoCardFactory factory = new UnoCardFactory();

        h.addCard(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED));
        assertEquals("|RED FOUR|", h.toString());

        UnoCard c = factory.createUnoCard(UnoCard.Rank.PLUSFOUR, UnoCard.Colour.WILD);
        h.addCard(c);
        h.addCard(factory.createUnoCard(UnoCard.Rank.PLUSTWO, UnoCard.Colour.GREEN));
        assertEquals("|RED FOUR|WILD PLUS-FOUR|GREEN PLUS-TWO|", h.toString());

        h.removeCard(c);
        assertEquals("|RED FOUR|GREEN PLUS-TWO|", h.toString());
    }

    @Test
    void findPlayableCardTest() {
        UnoDeck d = new UnoDeck(false);
        UnoHand h = new UnoHand();
        UnoCardFactory factory = new UnoCardFactory();

        UnoCard c1 = factory.createUnoCard(UnoCard.Rank.PLUSFOUR, UnoCard.Colour.WILD);
        UnoCard c2 = factory.createUnoCard(UnoCard.Rank.CHANGECOLOUR, UnoCard.Colour.WILD);

        d.addCard(c1);
        h.addCard(c2);
        assertEquals(c2, h.findPlayableCard(d.getTopCard()));

        h.removeCard(c2);
        UnoCard c3 = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.GREEN);
        h.addCard(c3);
        assertEquals(c3, h.findPlayableCard(d.getTopCard()));

        h.removeCard(c3);
        UnoCard c4 = factory.createUnoCard(UnoCard.Rank.CHANGECOLOUR, UnoCard.Colour.WILD);
        h.addCard(c4);
        assertEquals(c4, h.findPlayableCard(d.getTopCard()));

        h.removeCard(c4);
        d.removeCard(c1);
        d.addCard(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.GREEN));
        UnoCard c5 = factory.createUnoCard(UnoCard.Rank.FIVE, UnoCard.Colour.GREEN);
        h.addCard(c5);
        assertEquals(c5, h.findPlayableCard(d.getTopCard()));

        h.removeCard(c5);
        UnoCard c6 = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED);
        h.addCard(c6);
        assertEquals(c6, h.findPlayableCard(d.getTopCard()));

        h.removeCard(c6);
        h.addCard(factory.createUnoCard(UnoCard.Rank.REVERSE, UnoCard.Colour.BLUE));
        assertNull(h.findPlayableCard(d.getTopCard()));
    }

}