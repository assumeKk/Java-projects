/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import question1.Card.Rank;
import question1.Card.Suit;//import both enums, rank and suit
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Baokang Zhou
 */
public class Deck implements java.io.Serializable, Iterable<Card> {

    //serialzable ID 101
    static final long serialVersionUID = 101;

    // task1 this arraylist contain a list of cards
    private ArrayList<Card> cards;

    /**
     * Deck constructor
     */
    public Deck() {
        /* task2 Create list of cards*/
        initialCards();
    }
    
    /**
     * initialise card method, it used in constructor and newDeck() method.
     */
    private void initialCards(){
        /* task2 Create list of cards*/
        cards = new ArrayList<>();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                this.cards.add(new Card(r, s));
            }
        }
    }

    /**
     * access method
     *
     * @return cards
     */
    public ArrayList<Card> getCard() {
        return cards;
    }

    /**
     * task3 shuffle method able to shuffle cards on the deck, this method uses
     * Java Math.random() int noc is number of cards.
     */
    public void shuffle() {
        ArrayList<Card> c = new ArrayList<>();
        for (Card card : cards) {
            int noc = (int) (Math.random() * cards.size());
            c.add(cards.get(noc));
            cards.get(noc);
        }
        cards = c;
    }

    /**
     * task4 - Implement a method deal that removes the top card from the deck
     * and returns it.
     *
     * @return take the top card, and return it
     */
    public Card deal() {
        return cards.remove(0);
    }

    /**
     * task5 size() method that returns number of cards remaining in the deck
     *
     * @return int, the number of cards in the arraylist(on the deck)
     */
    public int size() {
        return cards.size();
    }

    /**
     * task5 newDeck method, reinitialise deck
     */
    public final void newDeck() {
        //cards = new Deck().getCard();
        initialCards();
    }

    @Override
    public Iterator<Card> iterator() {
        return new OddEvenIterator();
        //return cards.iterator();
    }

    private class OddEvenIterator implements Iterator<Card> {
        private int cursor; // pointing the index
        
        /**
         * Constructor for OddEvenIterator class, initial the cursor to 0
         */
        public OddEvenIterator() {
            this.cursor = 0;
        }
        
        /**
         * 
         * @return only return false if the cards.size() is +1  is equal 
         * to the cursor, otherwise return true
         */
        @Override
        public boolean hasNext() {
            if (this.cursor == cards.size() + 0) {
                cursor = 1;
                return true;
            } 
            else if(this.cursor == cards.size() + 1) {
                return false;
            } else {
                return true;
            }
        }
        /**
         * if the collection has next, the cursor will add 2 at a time
         * this will found the odd and even position
         * @return current card
         */
        @Override
        public Card next() {
            if (this.hasNext()) {
                Card current = cards.get(cursor);
                cursor += 2;
                return current;
            }
            throw new NoSuchElementException();
        }
        @Override
        public void remove(){
            
        }
        
    }

    public static void main(String[] args) {
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
        System.out.println("--test reinitialise the deck");
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
        
        System.out.println("\n\n--Serialize Cards in odd even order");
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
}