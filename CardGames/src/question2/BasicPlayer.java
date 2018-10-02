/*
 * This class store the player information about the game
 */
package question2;

import question1.Card;
import question1.Hand;

/**
 *
 * @author Baokang
 */
public class BasicPlayer implements Player{
    private Hand hand;
    private Strategy strategy;
    private CardGame cardGame;
    
    public BasicPlayer(Strategy strategy, CardGame cardGame){
        this.hand = new Hand(); 
        this.strategy = strategy;
        this.cardGame = cardGame;              
    }
    
    public BasicPlayer(Strategy strategy, CardGame cardGame, Hand hand){
        this.hand = hand;
        this.strategy = strategy;
        this.cardGame = cardGame;
    }

    @Override
    public void addCard(Card c) {
        this.hand.add(c);
    }

    @Override
    public void addHand(Hand h) {
        this.hand.add(h);
    }

    @Override
    public int cardsLeft() {
        return this.hand.size();
    }

    @Override
    public void setGame(CardGame g) {
        this.cardGame = g;
    }

    @Override
    public void setStrategy(Strategy s) {
        this.strategy = s;
    }

    @Override
    public Bid playHand(Bid b) {
        return this.strategy.chooseBid
        (b, this.hand, this.strategy.cheat(b, hand));
    }

    @Override
    public boolean callCheat(Bid b) {
        return this.strategy.callCheat(this.hand, b);
    }
    
    @Override
    public String toString(){
        return Hand.sortAscending(this.hand) + "     ";
    }
}
