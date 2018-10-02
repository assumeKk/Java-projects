/**
 * Card test class for basic main method test
 */
package question1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import static question1.Card.difference;
import static question1.Card.differenceValue;

/**
 *
 * @author Baokang
 */
public class CardTest {

    public static void cardClassTest() {
        /*-- test Cards --*/
        ArrayList<Card> card = new ArrayList<>();
        int i = 0;
        for (Card.Rank r : Card.Rank.values()) {
            for (Card.Suit s : Card.Suit.values()) {
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
        ArrayList<Card.Rank> rank = new ArrayList<>();
        //add all rank enum elements to rank
        rank.addAll(Arrays.asList(Card.Rank.values()));
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
        ascCard.add(new Card(Card.Rank.TEN, Card.Suit.SPADES));
        ascCard.add(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        ascCard.add(new Card(Card.Rank.TWO, Card.Suit.CLUBS));
        ascCard.add(new Card(Card.Rank.SIX, Card.Suit.HEARTS));
        System.out.println("--before sort ascending");
        System.out.println(ascCard);
        /**
         * The collections class provide static methods for sorting the elements
         * of collections. the it interact with comparable interface
         */
        System.out.println("--after sorted ascending");
        Collections.sort(ascCard, new Card.CompareSuit());
        Collections.sort(ascCard);
        System.out.println(ascCard);
        /*--test descending nested class, use rank to compare 
            card and sort in decending order*/
        ArrayList<Card> desCard = new ArrayList<>();
        desCard.add(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        desCard.add(new Card(Card.Rank.TEN, Card.Suit.SPADES));
        desCard.add(new Card(Card.Rank.TWO, Card.Suit.CLUBS));
        desCard.add(new Card(Card.Rank.SIX, Card.Suit.HEARTS));

        System.out.println("Before Sort Descending");
        System.out.println(desCard);
        Collections.sort(desCard, new Card.CompareSuit());
        Collections.sort(desCard, new Card.CompareDescending());
        System.out.println("After Sort Descending");
        System.out.println(desCard);

        /*--test sorting suit suit class, nested in the card class*/
        ArrayList<Card> sortSuit = new ArrayList<>();
        sortSuit.add(new Card(Card.Rank.TEN, Card.Suit.SPADES));
        sortSuit.add(new Card(Card.Rank.FIVE, Card.Suit.SPADES));
        sortSuit.add(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        sortSuit.add(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        sortSuit.add(new Card(Card.Rank.SIX, Card.Suit.DIAMONDS));
        sortSuit.add(new Card(Card.Rank.TWO, Card.Suit.CLUBS));
        sortSuit.add(new Card(Card.Rank.SIX, Card.Suit.SPADES));
        sortSuit.add(new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS));
        sortSuit.add(new Card(Card.Rank.SEVEN, Card.Suit.HEARTS));
        sortSuit.add(new Card(Card.Rank.SIX, Card.Suit.HEARTS));

        System.out.println("Before Sort Suit");
        System.out.println(sortSuit);

        Collections.sort(sortSuit, new Card.CompareSuit());
        Collections.sort(sortSuit, new Card.CompareDescending());
        System.out.println("After Sort Suit");
        System.out.println(sortSuit);
    }

    public static void deckClassTest() {
          /*--test cards on the deck, it store 52 cards--*/
        Deck deck = new Deck();
        int i = 0;
        for (Card card : deck.getCard()) {
            System.out.println(card);
        }
        /*--test shuffle method in the deck class, it ramdonize the cards--*/
        deck.shuffle();
        System.out.println("-----After shuffled cards-----");
        for (Card card : deck.getCard()) {
            i++;
            System.out.println(i + ":" + card);
        }
        /*--test deal method, it removes the top card from
            the deck and return it--*/
        System.out.println("--removed cards and return it value");
        System.out.println(deck.deal());
        System.out.println(deck.deal());
        System.out.println(deck.deal());
        System.out.println(deck.deal());
        System.out.println(deck.deal());
        /*--test size method, it remain number of cards on the deck--*/
        System.out.println("Cards left on the deck after deal: "+deck.size());
        /*--test newDeck() method, reinitialises the deck, 
            it regenerate new cards on the deck--*/
        deck.newDeck();
        int j = 0;
        for (Card card : deck.getCard()) {
            j++;
            System.out.println(j + ":" + card);
        }

        /*--test OddEvenIterator--*/
        System.out.println("--test nested class OddEvenIterator");
        Iterator<Card> it = deck.iterator();
        i = 0;
        while (it.hasNext()) {
            i++;
            Card card = it.next();
            System.out.println(i + " " + card);            
        }
        
        /*--test that the deck class can default iterate the cards in odd
            and even position--*/
        System.out.println("\n--test default deck class default iterator");
        deck.newDeck();
        for(Card card: deck){
            System.out.println(card);
        }
        
        System.out.println("\n\n--Serialize Cards in odd even order file "
                + "called: oddEvenCards.ser");
        String filename = "oddEvenCards.ser";        
        Deck d = new Deck();
        for(Card card: d){
            System.out.println(card);
        }
        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(d);
            out.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("\n\n--Deserialize oddEvenCard.ser");
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            d = (Deck) in.readObject();
            in.close();
            for(Card card: d){
                System.out.println(card);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void handClassTest() {
        Hand hand1 = new Hand();
        /*--add cards to hand1--*/
        hand1.add(new Card(Card.Rank.TEN, Card.Suit.SPADES));
        hand1.add(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        hand1.add(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        hand1.add(new Card(Card.Rank.NINE, Card.Suit.HEARTS));
        hand1.add(new Card(Card.Rank.FIVE, Card.Suit.HEARTS));

        System.out.println("--print cards in the hand");
        for (Card c : hand1) {
            System.out.println(c);
        }

        System.out.println("--count ranks in the hand: "
                + hand1.countRank(Card.Rank.TEN));

        System.out.println("--count suits in the hand: "
                + hand1.countSuit(Card.Suit.SPADES));

        System.out.println("--count value in the hand1: "
                + hand1.handValue());

        System.out.println("--hand1 is flush: " + hand1.isFlush());
        System.out.println("--hand1 is straight: " + hand1.isStraight());

        Hand hand2 = new Hand();
        hand2.add(new Card(Card.Rank.FIVE, Card.Suit.SPADES));
        hand2.add(new Card(Card.Rank.SIX, Card.Suit.DIAMONDS));
        hand2.add(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        hand2.add(new Card(Card.Rank.SEVEN, Card.Suit.HEARTS));
        hand2.add(new Card(Card.Rank.TEN, Card.Suit.HEARTS));
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
                + "Clubs: " + hand1.countSuit(Card.Suit.CLUBS)
                + "\nSpades: " + hand1.countSuit(Card.Suit.SPADES)
                + "\nDiamonds: " + hand1.countSuit(Card.Suit.DIAMONDS)
                + "\nHearts: " + hand1.countSuit(Card.Suit.HEARTS));

        System.out.println("--Ranks in hand1 \n"
                + "FIVE: " + hand1.countRank(Card.Rank.FIVE)
                + "\nSIX: " + hand1.countRank(Card.Rank.SIX)
                + "\nSEVEN: " + hand1.countRank(Card.Rank.SEVEN)
                + "\nEIGHT: " + hand1.countRank(Card.Rank.EIGHT)
                + "\nNINE: " + hand1.countRank(Card.Rank.NINE)
                + "\nTEN: " + hand1.countRank(Card.Rank.TEN));
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

    public static void main(String[] args) {
        System.out.println("/**--Card class test result--**/");
        cardClassTest();
        System.out.println("\n/**--Deck class test result--**/");
        deckClassTest();
        System.out.println("\n/**--Hand class test result--**/");
        handClassTest();
    }
}