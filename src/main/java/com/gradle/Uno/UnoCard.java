package com.gradle.Uno;

public class UnoCard {
    public UnoCard(Rank rank, Colour colour) {
        this.rank = rank;
        this.colour = colour;
    }

    public enum Colour {
        BLUE, GREEN, RED, YELLOW, WILD;

        private static final Colour[] colours = Colour.values();
        public static Colour getColour(int i) {
            return Colour.colours[i];
        }
    }

    public enum Rank {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, REVERSE, SKIP, PLUSTWO, PLUSFOUR, CHANGECOLOUR;

        private static final Rank[] ranks = Rank.values();
        public static Rank getRank(int i) {
            return Rank.ranks[i];
        }
    }

    public Colour getColour() {
        return this.colour;
    }

    public Rank getRank() {
        return this.rank;
    }

    public String toString() {
        String rankStr = this.colour.name() + " ";
        if (this.rank == Rank.PLUSTWO || this.rank == Rank.PLUSFOUR || this.rank == Rank.CHANGECOLOUR) {
            for (int i = 0; i < this.rank.name().length(); i++) {
                rankStr += this.rank.name().charAt(i);
                if ((this.rank == Rank.PLUSTWO || this.rank == Rank.PLUSFOUR) && this.rank.name().charAt(i) == 'S') {
                    rankStr += '-';
                } else if (this.rank == Rank.CHANGECOLOUR && this.rank.name().charAt(i) == 'E') {
                    rankStr += '-';
                }
            }
        } else {
            rankStr += rank.name();
        }

        return rankStr;
    }

    public boolean playable(UnoCard c) {
        return c.getRank() == this.getRank() || c.getColour() == this.getColour()
                || c.getColour() == UnoCard.Colour.WILD || this.getColour() == UnoCard.Colour.WILD;
    }

    private final Rank rank;
    private final Colour colour;
}
