/*
 * This is a card class which can generate cards with provided enums
 * This Class also have sorting methods, like sort rank and suit in different
 * orders
 */
package question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Baokang Zhou
 */
public class Card implements java.io.Serializable, Comparable<Card> {

    static final long serialVersionUID = 100;

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10),
        ACE(11);
        final int value;
        /**
         * Rank enum constructor
         * @param value is the Rank Value
         */
        Rank(int value) {
            this.value = value;
        }
        public static Rank[] r = Rank.values();

        /**
         * --task 2 This method check the ACE in rank
         *
         * @param r store value rank
         * @return true or false, if the r is equal or not equal
         */
        public boolean isAce(Rank[] r) {
            boolean result;
            result = r[this.ordinal()] == ACE;
            return result;
        }

        /**
         * --task 2 getNext value method, this will allow the program get the
         * next value of the current value, for example: FOUR next value is
         * FIVE.
         *
         * @return return next Rank element.
         */
        public Rank getNext() {
            if (!isAce(r)) {
                return r[this.ordinal() + 1];
            } else {
                return r[0];
            }
        }
        
        public int getValue(){
            return this.value;
        }
    }
    //-- task 3
    private Rank rank;
    private Suit suit;

    /**
     * --task 3 a constructor pass arguments
     *
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * --task4 sort card in ascending order by enum ordinal
     *
     * @param card
     * @return return int 0,1,-1
     */
    @Override
    public int compareTo(Card card) {
        if (rank.ordinal() == card.rank.ordinal()) {
            return 0;
        } else if (rank.ordinal() > card.rank.ordinal()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * --task5 accessor method
     *
     * @return return value to rank
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * --task5 accessor method
     *
     * @return return value to suit
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * --task6 display a card information
     *
     * @return a card detail rank & suit
     */
    @Override
    public String toString() {
        return "["+getRank() + " of " + getSuit()+"]";
    }

    /**
     * --task7 a static method that return the difference in rank between two
     * cards
     *
     * @param c1 first card
     * @param c2 second card
     * @return difference in integer between two cards
     */
    public static int difference(Card c1, Card c2) {
        int result;
        if (c1.rank.ordinal() > c2.rank.ordinal()) {
            result = c1.rank.ordinal() - c2.rank.ordinal();
        } else {
            result = c2.rank.ordinal() - c1.rank.ordinal();
        }
        return result;
    }

    /**
     * --task8 a static method return difference value between two cards so
     * difference between ten and queen is 0
     *
     * @param c1 first rank card
     * @param c2 second rank card
     * @return difference in integer between two cards
     */
    public static int differenceValue(Card c1, Card c2) {
        int result;
        if (c1.getRank().getValue() > c2.getRank().getValue()) {
            result = c1.getRank().getValue() - c2.getRank().getValue();
        } else {
            result = c2.getRank().getValue() - c1.getRank().getValue();
        }
        return result;
    }

    /**
     * --task9 nested class in the Card.java class, and made this class generic
     *
     */
    public static class CompareDescending
            implements Comparator<Card> {

        /**
         * Descending the rank in order by using ordinal() method from java
         * library
         *
         * @param c1 Card1
         * @param c2 Card2
         * @return integer and descending rank
         */
        @Override
        public int compare(Card c1, Card c2) {
            return c2.getRank().ordinal() - c1.getRank().ordinal();
        }
    }

    public static class CompareSuit implements Comparator<Card> {

        /**
         * Sort suit in order: Club -> diamond -> heart -> spade
         *
         * @param c1 Card1
         * @param c2 Card2
         * @return integer and sort suits in order
         */
        @Override
        public int compare(Card c1, Card c2) {
            return c1.getSuit().ordinal() - c2.getSuit().ordinal();
        }
    }

    public static void main(String[] args) {
        /*-- test Cards --*/
        ArrayList<Card> card = new ArrayList<>();
        int i = 0;
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                card.add(new Card(r, s));
            }
        }
        
        for (Card c : card) {
            i++;
            System.out.println(i + ":" + c);            
        }
        /*--test accessor methods*/
        System.out.println("--Test accessor methods");
        System.out.println(card.get(4).getRank());
        System.out.println(card.get(4).getSuit());

        /*--test getnext() method in rank enum--*/
        ArrayList<Rank> rank = new ArrayList<>();
        //add all rank enum elements to rank
        rank.addAll(Arrays.asList(Rank.values()));
        System.out.println(rank.get(12) + " next is " + rank.get(12).getNext());
        /*--test difference and differenceValue methods--*/
        System.out.println("Difference in ranks between "
                + card.get(42) + " and " + card.get(34) + " is "
                + difference(card.get(43), card.get(34)));
        
        System.out.println("Difference in value between "
                + card.get(35) + " and " + card.get(44) + " is "
                + differenceValue(card.get(35), card.get(44)));

        /*--test ascending method(comparable interface)--*/
        System.out.println("--test comparable interface");
        ArrayList<Card> ascCard = new ArrayList<>();
        ascCard.add(new Card(Rank.TEN, Suit.SPADES));
        ascCard.add(new Card(Rank.TEN, Suit.DIAMONDS));
        ascCard.add(new Card(Rank.TWO, Suit.CLUBS));
        ascCard.add(new Card(Rank.SIX, Suit.HEARTS));
        System.out.println("--before sort ascending");
        System.out.println(ascCard);
        /**
         * The collections class provide static methods for sorting the elements
         * of collections. the it interact with comparable interface
         */
        System.out.println("--after sorted ascending");
        Collections.sort(ascCard, new CompareSuit());
        Collections.sort(ascCard);
        System.out.println(ascCard);
        /*--test descending nested class, use rank to compare 
            card and sort in decending order*/
        ArrayList<Card> desCard = new ArrayList<>();
        desCard.add(new Card(Rank.TEN, Suit.DIAMONDS));
        desCard.add(new Card(Rank.TEN, Suit.SPADES));
        desCard.add(new Card(Rank.TWO, Suit.CLUBS));
        desCard.add(new Card(Rank.SIX, Suit.HEARTS));

        System.out.println("Before Sort Descending");
        System.out.println(desCard);
        Collections.sort(desCard, new CompareSuit());
        Collections.sort(desCard, new CompareDescending());
        System.out.println("After Sort Descending");
        System.out.println(desCard);

        /*--test sorting suit suit class, nested in the card class*/
        ArrayList<Card> sortSuit = new ArrayList<>();
        sortSuit.add(new Card(Rank.TEN, Suit.SPADES));
        sortSuit.add(new Card(Rank.FIVE, Suit.SPADES));
        sortSuit.add(new Card(Rank.TEN, Suit.DIAMONDS));
        sortSuit.add(new Card(Rank.FIVE, Suit.CLUBS));
        sortSuit.add(new Card(Rank.SIX, Suit.DIAMONDS));
        sortSuit.add(new Card(Rank.TWO, Suit.CLUBS));
        sortSuit.add(new Card(Rank.SIX, Suit.SPADES));
        sortSuit.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        sortSuit.add(new Card(Rank.SEVEN, Suit.HEARTS));
        sortSuit.add(new Card(Rank.SIX, Suit.HEARTS));

        System.out.println("Before Sort Suit");
        System.out.println(sortSuit);

        Collections.sort(sortSuit, new CompareSuit());
        Collections.sort(sortSuit, new CompareDescending());
        System.out.println("After Sort Suit");
        System.out.println(sortSuit);
    }
}