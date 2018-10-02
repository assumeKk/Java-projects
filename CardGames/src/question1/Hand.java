/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import question1.Card.Rank;
import question1.Card.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Baokang
 */
public class Hand implements java.io.Serializable, Iterable<Card> {

    /*task2 create serialisation ID*/
    static final long serialVersionUID = 102;

    private ArrayList<Card> hand;   // card in the hand
    private int[] rankCount;       //count for rank
    private int[] suitCount;       //count for suit
    private int totalValue;      //total value of the cards in the hand

    /*--task 1--*/
    /**
     * Default constructor, creating an empty hand
     */
    public Hand() {
        this.hand = new ArrayList<>();
        initHistograms();
        this.totalValue = 0;
    }

    /**
     * Constructor that takes array of cards and add them to hand
     *
     * @param cards list of cards
     */
    public Hand(ArrayList<Card> cards) {
        initHistograms();
        this.hand = cards;
        /*--update hitorgrams for current hand--*/
        for (Card card : cards) {
            updateHistograms(card);
            //add total value(s) of the cards in the hands
            this.totalValue += card.getRank().getValue();
            //add card to the hand
            this.hand.add(card);
        }
    }

    /**
     * Constructor that takes a different hand and copies all cards to this hand
     *
     * @param otherHand different hand
     */
    public Hand(Hand otherHand) {
        initHistograms();
        /*--this takes a different hand and copies all the cards to this hand-*/
        this.hand = otherHand.getHand();
        /*--updating the histograms for other hand--*/
        for (Card card : otherHand.getHand()) { //replace with getHand() method
            updateHistograms(card);
            //add total value(s) of the cards in the hands
            this.totalValue += card.getRank().getValue();
        }
    }

    /*--task3--*/
    /**
     * initialise the histograms for rank and suit count
     */
    private void initHistograms() {
        rankCount = new int[13];
        suitCount = new int[4];
    }

    /**
     * this method will update the histogram
     *
     * @param card for found rank and suit
     */
    private void updateHistograms(Card card) {
        int rankIndex = card.getRank().ordinal();
        rankCount[rankIndex]++;

        int suitIndex = card.getSuit().ordinal();
        suitCount[suitIndex]++;
    }

    /**
     * reduce histograms values
     *
     * @param card
     */
    private void updateSubHistograms(Card card) {
        //reduce values in rank and suit array
        this.rankCount[card.getRank().ordinal()]--;
        this.suitCount[card.getSuit().ordinal()]--;
        this.totalValue -= card.getRank().getValue();
    }

    /**
     *
     * @return hand
     */
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /**
     * task 5 add a single card
     *
     * @param c card
     */
    public void add(Card c) {
        this.hand.add(c);
        rankCount[c.getRank().ordinal()]++;
        suitCount[c.getSuit().ordinal()]++;
        totalValue += c.getRank().getValue();
    }

    /**
     * task 5 add a collection of cards
     *
     * @param c card
     */
    public void add(ArrayList<Card> c) {
        Iterator<Card> it = c.iterator();
        while (it.hasNext()) {
            this.add(it.next());
        }
    }

    /**
     * task5 add card to a hand
     *
     * @param h hand
     */
    public void add(Hand h) {
        this.add(h.getHand());
    }

    /**
     * task6 remove a single card
     *
     * @param c
     * @return true when card is present
     */
    public boolean remove(Card c) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            //compare the present card
            if (card.getRank() == c.getRank() && card.getSuit() == c.getSuit()){
                updateSubHistograms(c);
                //remove card
                this.hand.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * task6 Remove all cards from another hand passed as an argument (if
     * present)
     *
     * @param h
     * @return
     */
    public boolean remove(Hand h) {
        boolean result = true;
        Iterator<Card> it = h.getHand().iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                result = false;
            }
        }
        return result;
    }

    /**
     * task6 Remove the card at a position, using the index
     *
     * @param index
     * @return
     */
    public Card remove(int index) {
        if (index >= this.hand.size() || index < 0) {
            return null;
        }
        Card card = this.hand.get(index);
        updateSubHistograms(card);
        this.hand.remove(index);
        return card;
    }

    /**
     * task7 create iterator and travers the cards in order they were added
     *
     * @return
     */
    @Override
    public Iterator<Card> iterator() {
        class iter implements Iterator<Card> {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < hand.size();
            }

            @Override
            public Card next() {
                return hand.get(cursor++);
            }

            @Override
            public void remove() {
                cursor--;
                hand.remove(cursor);
            }

        }
        return new iter();
    }

    /**
     * task8 sort cards in hand into ascending
     *
     * @param h hand
     * @return new hand, after sorted
     */
    public static Hand sortAscending(Hand h) {
        Hand newHand = new Hand(h);
        Collections.sort(newHand.hand, new Card.CompareSuit());
        Collections.sort(newHand.hand);
        return newHand;
    }

    /**
     * task9 sort cards in hand into descending order
     *
     * @param h hand
     * @return new hand, after sorted
     */
    public static Hand sortDescending(Hand h) {
        Hand newHand = new Hand(h);
        Collections.sort(newHand.getHand(), new Card.CompareSuit());
        Collections.sort(newHand.getHand(), new Card.CompareDescending());
        return newHand;
    }

    /**
     * task10
     *
     * @param s suit
     * @return int, number of suit
     */
    public int countSuit(Suit s) {
        return this.suitCount[s.ordinal()];
    }

    /**
     * task11
     *
     * @param r rank
     * @return int, number of rank
     */
    public int countRank(Rank r) {
        return this.rankCount[r.ordinal()];
    }

    /**
     * task12
     *
     * @return return total rank values of the cards in the hand
     */
    public int handValue() {
        return this.totalValue;
    }

    /**
     * task 13
     *
     * @return display cards in the hand
     */
    @Override
    public String toString() {
        String str = "";
        int i = 0;
        for (Card card : this.getHand()) {            
            str += i + ":" + card.toString();
            i++;
        }
        return str;
    }

    /**
     * task14
     *
     * @return return true of all the card in the hand are the same suit
     */
    public boolean isFlush() {
        for (int i = 0; i < suitCount.length; i++) {
            if (suitCount[i] == this.getHand().size()) {
                return true;
            }
        }
        return false;
    }

    /**
     * task15
     *
     * @return true if cards is in order
     */
    public boolean isStraight() {
        boolean start = false;
        boolean end = false;
        for (int i = 0; i < 13; i++) {
            switch (this.rankCount[i]) {
                case 1:
                    if (!start) {
                        start = true;
                    } else if (end) {
                        return false;
                    }
                    break;
                case 0:
                    if (start) {
                        if (!end) {
                            end = true;
                        }
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public int size() {
        return this.hand.size();
    }

    public static void main(String[] args) {
        Hand hand1 = new Hand();
        /*--add cards to hand1--*/
        hand1.add(new Card(Rank.TEN, Suit.SPADES));
        hand1.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hand1.add(new Card(Rank.EIGHT, Suit.CLUBS));
        hand1.add(new Card(Rank.NINE, Suit.HEARTS));
        hand1.add(new Card(Rank.FIVE, Suit.HEARTS));

        System.out.println("--print cards in the hand");
        for (Card c : hand1) {
            System.out.println(c);
        }

        System.out.println("--count ranks in the hand: "
                + hand1.countRank(Rank.TEN));

        System.out.println("--count suits in the hand: "
                + hand1.countSuit(Suit.SPADES));

        System.out.println("--count value in the hand1: "
                + hand1.handValue());

        System.out.println("--hand1 is flush: " + hand1.isFlush());
        System.out.println("--hand1 is straight: " + hand1.isStraight());

        Hand hand2 = new Hand();
        hand2.add(new Card(Rank.FIVE, Suit.SPADES));
        hand2.add(new Card(Rank.SIX, Suit.DIAMONDS));
        hand2.add(new Card(Rank.FIVE, Suit.CLUBS));
        hand2.add(new Card(Rank.SEVEN, Suit.HEARTS));
        hand2.add(new Card(Rank.TEN, Suit.HEARTS));
        System.out.println("--Cards in hand2");
        for (Card card : hand2) {
            System.out.println(card);
        }

        hand1.add(hand2);
        System.out.println("--Add hand2 cards to hand1:");
        for (Card card : hand1) {
            System.out.println(card);
        }
        System.out.println("--Suits in hand1 \n"
                + "Clubs: " + hand1.countSuit(Suit.CLUBS)
                + "\nSpades: " + hand1.countSuit(Suit.SPADES)
                + "\nDiamonds: " + hand1.countSuit(Suit.DIAMONDS)
                + "\nHearts: " + hand1.countSuit(Suit.HEARTS));

        System.out.println("--Ranks in hand1 \n"
                + "FIVE: " + hand1.countRank(Rank.FIVE)
                + "\nSIX: " + hand1.countRank(Rank.SIX)
                + "\nSEVEN: " + hand1.countRank(Rank.SEVEN)
                + "\nEIGHT: " + hand1.countRank(Rank.EIGHT)
                + "\nNINE: " + hand1.countRank(Rank.NINE)
                + "\nTEN: " + hand1.countRank(Rank.TEN));
        System.out.println("--Total value in hand1: "
                + hand1.handValue());
        System.out.println("--Remove 10 from hand1" + hand1.remove(0));
        System.out.println("--Value left in the hand after removed TEN: "
                + hand1.handValue());

        System.out.println("--sort hand1 cards in ascding order");
        Hand.sortAscending(hand1);

        Iterator<Card> iter = hand1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("--sort hand1 cards in descending order");
        Hand.sortDescending(hand1);
        Iterator<Card> iter2 = hand1.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }
}
