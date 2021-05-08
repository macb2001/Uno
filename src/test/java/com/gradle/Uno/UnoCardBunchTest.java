package com.gradle.Uno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoCardBunchTest {
    @Test
    void addCardTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoCardBunch b = new UnoCardBunch();

        assertEquals(0, b.getSize());

        b.addCard(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED));
        assertEquals(1, b.getSize());
    }

    @Test
    void removeCardValidTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoCard c = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED);
        UnoCardBunch b = new UnoCardBunch();

        b.addCard(c);
        assertEquals(1, b.getSize());

        b.removeCard(c);
        assertEquals(0, b.getSize());
    }

    @Test
    void removeCardInvalidTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoCardBunch b = new UnoCardBunch();

        assertThrows(IllegalStateException.class, () -> {
            b.removeCard(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED));
        });
    }

    @Test
    void takeCardTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoCard c = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED);
        UnoCardBunch b1 = new UnoCardBunch();
        UnoCardBunch b2 = new UnoCardBunch();

        b1.addCard(c);
        assertEquals(1, b1.getSize());
        assertEquals(0, b2.getSize());

        b2.takeCard(b1, c);
        assertEquals(0, b1.getSize());
        assertEquals(1, b2.getSize());
    }

    @Test
    void getSizeTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoCard c = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED);
        UnoCardBunch b = new UnoCardBunch();

        assertEquals(0, b.getSize());

        b.addCard(c);
        assertEquals(1, b.getSize());

        b.removeCard(c);
        assertEquals(0, b.getSize());
    }


}