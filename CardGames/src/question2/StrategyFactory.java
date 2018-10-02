/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

/**
 *
 * @author Baokang
 */
public class StrategyFactory {

    public enum StrategyType {
        Basic, Human, Thinker, My
    }
    /**
     * 
     * @param type
     * @param discardsRankCount
     * @return      different type of strategy for player
     */
    public static Strategy CreateStrategy(StrategyType type,
            int[] discardsRankCount) {
        switch (type) {
            case Basic:
                return new BasicStrategy();
            case Human:
                return new HumanStrategy();
            case Thinker:
                return new ThinkerStrategy();
            case My:
                return new MyStrategy();
            default:
                break;
        }
        return null;
    }
}
