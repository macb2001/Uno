package com.gradle.Uno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoCardTest {

    @Test
    void constructorTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoCard card = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.BLUE);

        assertEquals(card.getColour(), UnoCard.Colour.BLUE);
        assertEquals(card.getRank(), UnoCard.Rank.FOUR);
    }

    @Test
    void getColourTest() {
        UnoCardFactory factory = new UnoCardFactory();

        assertEquals((factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.BLUE)).getColour(), UnoCard.Colour.BLUE);
    }

    @Test
    void getRankTest() {
        UnoCardFactory factory = new UnoCardFactory();

        assertEquals((factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.BLUE)).getRank(), UnoCard.Rank.FOUR);
    }

    @Test
    void getCardNameTest() {
        UnoCardFactory factory = new UnoCardFactory();

        assertEquals("BLUE FOUR",
                (factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.BLUE)).toString());

        assertEquals("WILD PLUS-FOUR",
                (factory.createUnoCard(UnoCard.Rank.PLUSFOUR, UnoCard.Colour.WILD)).toString());

        assertEquals("RED PLUS-TWO",
                (factory.createUnoCard(UnoCard.Rank.PLUSTWO, UnoCard.Colour.RED)).toString());

        assertEquals("WILD CHANGE-COLOUR",
                (factory.createUnoCard(UnoCard.Rank.CHANGECOLOUR, UnoCard.Colour.WILD)).toString());
    }

    @Test
    void playableTest() {
        UnoCardFactory factory = new UnoCardFactory();

        assertTrue((factory.createUnoCard(UnoCard.Rank.PLUSFOUR, UnoCard.Colour.WILD))
                .playable(factory.createUnoCard(UnoCard.Rank.CHANGECOLOUR, UnoCard.Colour.WILD)));

        assertTrue((factory.createUnoCard(UnoCard.Rank.PLUSFOUR, UnoCard.Colour.WILD))
                .playable(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.GREEN)));

        assertTrue((factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED))
                .playable(factory.createUnoCard(UnoCard.Rank.CHANGECOLOUR, UnoCard.Colour.WILD)));

        assertTrue((factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.GREEN))
                .playable(factory.createUnoCard(UnoCard.Rank.FIVE, UnoCard.Colour.GREEN)));

        assertTrue((factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.GREEN))
                .playable(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.RED)));

        assertFalse((factory.createUnoCard(UnoCard.Rank.SKIP, UnoCard.Colour.RED))
                .playable(factory.createUnoCard(UnoCard.Rank.REVERSE, UnoCard.Colour.BLUE)));
    }
}