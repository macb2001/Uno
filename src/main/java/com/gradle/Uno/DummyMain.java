package com.gradle.Uno;

public class DummyMain {
    public static void main(String args[]) {
        UnoDeck d = new UnoDeck(true);
        d.initialize();
        for (UnoCard card : d.cards) {
            System.out.println(card.toString());
        }
    }
}
