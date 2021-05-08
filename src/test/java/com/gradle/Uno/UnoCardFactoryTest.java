package com.gradle.Uno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoCardFactoryTest {

    @Test
    void createUnoCardValidTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoCard card = factory.createUnoCard(UnoCard.Rank.PLUSFOUR, UnoCard.Colour.WILD);
        assertEquals(card.getColour(), UnoCard.Colour.WILD);
        assertEquals(card.getRank(), UnoCard.Rank.PLUSFOUR);
    }

    @Test
    void createUnoCardInvalidTest() {
        UnoCardFactory factory = new UnoCardFactory();

        assertThrows(IllegalArgumentException.class, () -> {
            UnoCard card = factory.createUnoCard(UnoCard.Rank.PLUSFOUR, UnoCard.Colour.GREEN);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            UnoCard card = factory.createUnoCard(UnoCard.Rank.CHANGECOLOUR, UnoCard.Colour.GREEN);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            UnoCard card = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.WILD);
        });
    }
}