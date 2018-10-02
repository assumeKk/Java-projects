package question2;

import java.util.Random;
import question1.Card;
import question1.Card.Rank;
import question1.Hand;

/**
 *
 * @author Baokang
 */
public class MyStrategy implements Strategy {
    Hand discardHand;//to record discarded cards
    int rankCount[] = new int[13];

    public MyStrategy() {
        this.discardHand = new Hand(); //initialise
        for(int i = 0; i < rankCount.length; i++){
            // fill rank count elements with 0s
            rankCount[i]=0;
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
        Rank currentRank = b.getRank();
        Rank nextRank = currentRank.getNext();
        //the player will still cheat if current rank count it less then 2
        if ((h.countRank(currentRank) > 0 || h.countRank(nextRank) > 0)) {
            return rankCount[b.getRank().ordinal()] < 2;
        }
        return true;
    }

    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        Rank nextRank;
        if (h.countRank(b.getRank()) > 0) {
            nextRank = b.getRank();
        } else {
            nextRank = b.getRank().getNext();
        }
        if (cheat) {
            Hand bidHand = new Hand();
            Random random = new Random();
            //if hand have more than 5 cards, remove first two index
            if (h.size() > 5) {
                bidHand.add(h.remove(0));
                bidHand.add(h.remove(1));
            } //else remove the average index card.
            else {
                bidHand.add(h.remove(h.size() / 2));
            }
            discardHand.add(bidHand);
            return new Bid(bidHand, nextRank);
        } else { // if not cheat
            Hand bidHand = new Hand();
            for (int i = 0; i < h.size(); i++) {
                Card card = h.getHand().get(i);
                if (card.getRank() == nextRank) {
                    bidHand.add(h.remove(i));
                }
            }
            return new Bid(bidHand, nextRank);
        }
    }

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
        } else if (joinHand.countRank(b.getRank()) + b.getCount() > 3) {
            // 3/4 chance depend on how many of the
            //current rank in the discard pile
            return randomPercent(75); 
        } else {
            return false;
        }
    }
}
