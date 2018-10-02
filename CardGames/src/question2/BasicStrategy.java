package question2;

import java.util.Random;
import question1.Card;
import question1.Card.Rank;
import question1.Hand;

/**
 *
 * @author Baokang
 */
public class BasicStrategy implements Strategy{
    /**
     * 
     * @param b     bid card
     * @param h     card in hand
     * @return      true if rank or rank2 value is greater than 0
     */
    @Override
    public boolean cheat(Bid b, Hand h) {
        Rank currentRank = b.getRank();
        //nextRank is the next value of rank
        Rank nextRank = currentRank.getNext();
        //return true if rank or nextRank value is greater than 0
        return !((h.countRank(currentRank) > 0) || h.countRank(nextRank) > 0);
    }
    
    /**
     * 
     * @param b     bid
     * @param h     hand
     * @param cheat boolean, player decide cheat or not cheat
     * @return      a new bid hand with cheat or not cheat
     */
    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        Rank nextRank;
        if(h.countRank(b.getRank()) > 0 ){//if dont have current rank, go next
            nextRank = b.getRank();
        } 
        else {
            nextRank = b.getRank().getNext();
        }
        if(cheat){ //if current player have to cheat
            Random random = new Random(); //pick a random card
            //add remove card to bid hand
            Hand bidHand = new Hand();
            //the random card will remove from hand
            Card removeCard = h.remove(random.nextInt(h.size()));
            bidHand.add(removeCard);
            //return a new bid hand with cheat statement
            return new Bid(bidHand, nextRank);
        }
        else{ // if not cheat
            Hand bidHand = new Hand(); // create new a new bid hand
            //loop all cards in the hand
            for(int i = 0; i < h.size(); i++){
                //add current card in hand to card
                Card card = 
                        
                        h.getHand().get(i);
                //if current card's rank is equal to next bid rank
                if(card.getRank() == nextRank){
                    //add current card to bid hand
                    bidHand.add(h.remove(i));
                }
            }
            //return a new bid hand with NOT cheat statement
            return new Bid(bidHand, nextRank);
        }
    }
    /**
     * Call cheat if when certain player is cheating
     * @param h     hand
     * @param b     bid
     * @return      true if myCurrent rank plus bid rank is greater than 4
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        int size = b.getCount(); //get the card number in bid
        int mySize = h.countRank(b.getRank()); //get card number in hand
        return size + mySize > 4; //return true if greater than 4
    }
    
}
