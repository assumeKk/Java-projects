/**
 * 
 * A molder for building policy, and contain method to get the premium.
 */

package insurancecompany_v1;
import java.text.NumberFormat;

/**
 *
 * @author dxe15gxu
 */
public class BuildingPolicy extends Policy{
    private double estimatedCost;
    private double levelOfRisk = 0;
    private final static double REBUILD_FACTOR = 0.001;

/**
 * 
 * @param policyNo                  unique policy ID
 * @param year                        year of issue
 * @param estimated_cost        estimated cost of the building
 * @param level_of_risk             level of risk
 * @throws IllegalPolicyException       throw error message
 */
    public BuildingPolicy(String policyNo, int year, double estimated_cost, double level_of_risk) throws IllegalPolicyException{
        super(policyNo, year);
        if (policyNo.charAt(0) == 'B'){
            this.estimatedCost = estimated_cost;
            this.levelOfRisk = level_of_risk;
        }
        else{
            throw new IllegalPolicyException("Building policy number must begin with 'B'");
        }
    }
    
    /**
     * 
     * @return      estimated cost
     */
    public double getEstimatedCost(){
        return estimatedCost;
    }
    
    /**
     * 
     * @return level of risk
     */
    public double getLevelOfRisk(){
        return levelOfRisk;
    }
    
/**
 * 
 * @param cost 
 */
    public void setEstimatedCost(double cost){
        this.estimatedCost = cost;
    }
   /**
    * 
    * @param level 
    */ 
    public void setLevelOfRisk(double level){
        this.levelOfRisk = level;
    }
    /**
     * 
     * @return          premium cost
     */
    @Override
    public double getPremium(){
        double premium;
        return premium = estimatedCost * REBUILD_FACTOR * (1 + levelOfRisk);        
    }
    /**
     * 
     * @return          building policy details in string
     */
    @Override    
    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        StringBuilder str = new StringBuilder("\n"+super.toString());
        str.append("Estimated cost: ").append(estimatedCost);
        str.append("\n");
        str.append("Level of risk: ").append(levelOfRisk);
        str.append("\n");
        str.append("Premium cost: ").append(fmt.format(getPremium()));
        return str.toString();
    }
}
