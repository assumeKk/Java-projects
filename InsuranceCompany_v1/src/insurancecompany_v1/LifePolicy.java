/**
 * 
 * A molder for life policy, and contain method to get the premium.
 */

package insurancecompany_v1;
import java.text.NumberFormat;
/**
 *
 * @author dxe15gxu
 */
public class LifePolicy extends Policy{
    private int holderAge;
    private int amountOfCover;
    private double healthRisk = 0;
    private final static int THRESHOLD = 60;
    
    /**
     * 
     * @param holder_age                    policy holder age
     * @param amount_of_cover            amount of cover
     * @param health_risk                    level of health risk
     * @throws IllegalPolicyException 
     */
    public LifePolicy(String policyNo, int year, int holder_age, int amount_of_cover, double health_risk) throws IllegalPolicyException{
        super(policyNo, year);
        /* check the first character of the policy ID*/
        if (policyNo.charAt(0) == 'L'){
            this.holderAge = holder_age;
            this.amountOfCover = amount_of_cover;
            this.healthRisk= health_risk;
        }
        else{
            throw new IllegalPolicyException("Life policy number must begin with 'L'");
        }
    }
    
    public int getHolderAge(){
        return this.holderAge;
    }
    
    public int getAmountOfCover(){
        return this.amountOfCover;
    }
    
    public double getHealthRisk(){
        return this.healthRisk;
    }
    
    /**
     * 
     * @return premium cost
     */
    @Override
    public double getPremium(){
        double premium;
        premium = amountOfCover / 1000;
        premium = premium * (1 + healthRisk);
        if(holderAge < THRESHOLD){
            return premium;
        }
        else{
            return premium * (holderAge / THRESHOLD);
        }
    }
    
    /**
     * 
     * @return      return life policy details in string
     */
    @Override
    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        StringBuilder str = new StringBuilder("\n"+super.toString());
        str.append("Holder Age: ").append(holderAge);
        str.append("\n");
        str.append("Amount of cover: ").append(amountOfCover);
        str.append("\n");
        str.append("Health risk: ").append(healthRisk);
        str.append("\n");
        str.append("Premium cost: ").append(fmt.format(getPremium()));
        return str.toString();
    }
}
