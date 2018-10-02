/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.Random;
import question1.Card;
import question1.Card.Rank;
import question1.Hand;

/**
 *
 * @author Baokang
 */
public class ThinkerStrategy implements Strategy {

    Hand discardHand;//to record discarded cards
    int rankCount[] = new int[13];

    public ThinkerStrategy() {
        this.discardHand = new Hand(); //initialise
        for (int i = 0; i < rankCount.length; i++) {
            // fill rank count elements with 0s
            rankCount[i] = 0;
        }
    }

    //persentage that will decide to cheat
    private boolean randomPercent(int percent) {
        Random random = new Random();
        int percentage = random.nextInt();
        return percentage < percent;
    }

    @Override
    public boolean cheat(Bid b, Hand h) {
        Rank currentRank = b.getRank(); //current bid rank
        Rank nextRank = currentRank.getNext(); //next rank
        // if player dont have current or next bid rank, return false
        // if player have current or next bid rank, it has 1/4 chance to cheat
        if ((h.countRank(currentRank) > 0) || h.countRank(nextRank) > 0) {
            return !randomPercent(75); // 1/4 chance not cheat
        } else {
            return true;
        }
    }

    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        Rank nextRank; //the bid rank and next rank
        if (h.countRank(b.getRank()) > 0) {//if dont have current rank, go next
            nextRank = b.getRank();
        } else {
            nextRank = b.getRank().getNext();
        }
        if (cheat) { //if current player have to cheat
            Random random = new Random();
            Hand bidHand = new Hand();
            Card removeCard; //store card want to remove
            //player have 1/4 chance to discard lower cards
            if (randomPercent(25)) {
                //half the card size(low/high)
                removeCard = h.remove(random.nextInt(h.size() / 2));
            } else {
                // decide 1/4 card in the hand is high rank
                removeCard = h.remove(random.nextInt(h.size() / 4));
            }
            h.remove(removeCard); //discard card from current hand
            bidHand.add(removeCard); //add discard card to bid hand
            discardHand.add(bidHand); //add discard cards to discard hand
            return new Bid(bidHand, nextRank);
        } else { //player may occasionally cheat
            Hand bidHand = new Hand();
            Random random = new Random();
            Card removeCard;
            if (randomPercent(80)) { // 1/5 will not cheat
                for (int i = 0; i < h.size(); i++) {
                    Card card = h.getHand().get(i);
                    if (card.getRank() == nextRank) {
                        bidHand.add(h.remove(i));
                        discardHand.add(bidHand);
                    }
                }
            } else { // 20% player may cheat, and discard a random card
                removeCard = h.remove(random.nextInt(h.size() / 4));
                bidHand.add(removeCard);
                discardHand.add(bidHand);//add discard cards to discard hand
            }
            return new Bid(bidHand, nextRank);
        }
    }

    /**
     * merge cards in discard hand and current to make decision: call cheat
     *
     * @param h hand
     * @param b bid
     * @return
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        //remove same cards if discard hand have same cards as current hand
        discardHand.remove(h);
        //merge two cards in two hands, get all cards
        Hand joinHand = new Hand();
        joinHand.add(h);
        joinHand.add(discardHand);
        // if 100% sure, other player cheat
        if (joinHand.countRank(b.getRank()) + b.getCount() > 4) {
            return true;
        } else {
            if (randomPercent(25)) {
                // 1/4 chance depend on how many of the 
                //current rank in the discard pile
                if (rankCount[b.getRank().ordinal()] > 4) {
                    return true;
                }
            }
            return false;
        }
    }

}
