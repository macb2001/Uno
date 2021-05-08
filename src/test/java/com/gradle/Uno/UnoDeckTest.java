package com.gradle.Uno;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class UnoDeckTest {

    @Test
    void initializeTest() {
        UnoDeck d = new UnoDeck(true);
        d.initialize();
        ArrayList<String> arr = new ArrayList<String>();
        for (UnoCard card : d.cards) {
            arr.add(card.toString());
        }

        for (String s : arr) {
            if (s.contains("ZERO")) {
                assertEquals(1, Collections.frequency(arr, s));
            } else if (s.contains("WILD")) {
                assertEquals(4, Collections.frequency(arr, s));
            } else {
                assertEquals(2, Collections.frequency(arr, s));
            }
        }
    }

    @Test
    void initializeSizeTest() {
        UnoDeck d = new UnoDeck(true);
        final UnoCard.Colour[] colours = UnoCard.Colour.values();
        final UnoCard.Rank[] ranks = UnoCard.Rank.values();
        d.initialize();

        assertEquals(108, d.getSize());
    }

    @Test
    void initializeInvalidTest() {
        UnoDeck d = new UnoDeck(false);

        assertThrows(IllegalCallerException.class, d::initialize);
    }

    @Test
    void getTopCardValidTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoDeck d = new UnoDeck(true);
        UnoCard card = factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.BLUE);

        d.addCard(card);
        assertEquals(card, d.getTopCard());
    }

    @Test
    void getTopCardInvalidTest() {
        UnoDeck d = new UnoDeck(false);

        assertThrows(IllegalStateException.class, d::getTopCard);

    }

    @Test
    void shuffleValidTest() {
        UnoCardFactory factory = new UnoCardFactory();
        UnoDeck d = new UnoDeck(true);
        d.addCard(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.BLUE));

        assertDoesNotThrow(d::shuffle);
    }

    @Test
    void shuffleInvalidTest() {
        UnoDeck d1 = new UnoDeck(true);
        UnoDeck d2 = new UnoDeck(false);

        assertThrows(IllegalStateException.class, d1::shuffle);
        assertThrows(IllegalCallerException.class, d2::shuffle);
    }

    @Test
    void recycleValidTest() {
        UnoDeck d1 = new UnoDeck(true);
        UnoDeck d2 = new UnoDeck(false);

        d1.initialize();

        d2.cards.addAll(d1.cards);
        d1.cards.clear();

        assertEquals(0, d1.getSize());
        assertEquals(108, d2.getSize());

        d1.recycle(d2);

        assertEquals(0, d2.getSize());
        assertEquals(108, d1.getSize());
    }

    @Test
    void recycleInvalidTest() {
        UnoDeck d1 = new UnoDeck(true);
        UnoDeck d2 = new UnoDeck(false);
        UnoDeck d3 = new UnoDeck(true);
        UnoDeck d4 = new UnoDeck(false);

        assertThrows(IllegalCallerException.class, () -> {
            d2.recycle(d4);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            d1.recycle(d3);
        });

        UnoCardFactory factory = new UnoCardFactory();
        d1.addCard(factory.createUnoCard(UnoCard.Rank.FOUR, UnoCard.Colour.BLUE));

        assertThrows(IllegalStateException.class, () -> {
            d1.recycle(d2);
        });
    }

}