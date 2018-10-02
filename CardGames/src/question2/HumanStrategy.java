/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.Scanner;
import question1.Card.*;
import question1.Hand;

/**
 *
 * @author Baokang
 */
public class HumanStrategy implements Strategy {

    Scanner scan = new Scanner(System.in);

    /**
     * The player will make decision whether cheat or not
     *
     * @param b bid
     * @param h hand
     * @return false, let the player decide
     */
    @Override
    public boolean cheat(Bid b, Hand h) {
        return false;
    }

    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        Rank currentRank = b.getRank();
        Rank nextRank = currentRank.getNext(); //the next card of current card
        Rank declareRank; //the player declare which rank is in next round
        Hand hand = new Hand(); //store cards to be remove
        while (true) {
            System.out.println("input the index of card you want to discard "
                    + "(0-" + (h.size() - 1) + "): ");
            int index = scan.nextInt();
            scan.nextLine();
            //if input is not in index range
            if (index < 0 || index >= h.size()) {
                System.out.println("Invalid index");
                System.out.println("Range must between:"
                        + "(0-" + (h.size() - 1) + ")");
            } else { //if input is in index range
                hand.add(h.remove(index));
                // the player are only allow drop 4 cards at once
                // drop 5 cards at once is too obvious cheating
                if (hand.size() >= 4) {
                    break;
                }
                System.out.println("Want add more cards into? Y/ or any"
                        + "key to discard current card: ");
                String s = scan.nextLine().toLowerCase(); //read user input
                if (!s.equals("y")) {
                    break;
                }
            }
        }
        /**
         *while the player still true, ask player want to declare the card rank
         * as current or next rank
         */
        while (true) {
            System.out.println("Declare your discard rank as: 1 "
                    + currentRank + "or 2" + nextRank + "(Enter 1 or 2)");
            String s = scan.nextLine();//player declare the rank
            if ("1".equals(s)) {
                declareRank = currentRank;
                break;
            } else if ("2".equals(s)) {
                declareRank = nextRank;
                break;
            } else {
                System.out.println("Only accept 1 or 2");
            }

        }
        return new Bid(hand, nextRank);
    }

    /**
     *
     * @param h hand
     * @param b bid
     * @return if player enter y, means call cheat, else false
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        String s;
        System.out.println("Do you want call cheat- Y/N: ");
        s = scan.nextLine().toLowerCase();
        return s.equals("y");
    }

}
