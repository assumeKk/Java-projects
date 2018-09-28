/**
 * A molder for content policy, and contain method to get the premium.
 */

package insurancecompany_v1;
import java.text.NumberFormat;
/**
 *
 * @author dxe15gxu
 */
public class ContentPolicy extends Policy{
    private double valueOfContents;
    private double levelOfRisk = 0;
    private final static double CONTENTS_FACTOR = 0.01;
    
    /**
     * 
     * @param policyNo                          policy ID for content policy
     * @param year                                year of issue
     * @param value_of_contents             value of content
     * @param level_of_risk                     level of risk
     * @throws IllegalPolicyException       throw error exception
     */
    public ContentPolicy(String policyNo, int year, double value_of_contents, double level_of_risk) throws IllegalPolicyException{
        super(policyNo, year);
        if(policyNo.charAt(0) == 'C'){
            this.valueOfContents = value_of_contents;
            this.levelOfRisk = level_of_risk;
        }
        else{
            throw new IllegalPolicyException("Content policy number must begin with 'C'");
        }
    }
    
    /**
     * 
     * @return      value of content
     */
    public double getValueOfContents(){
        return valueOfContents;
    }
    
    /**
     * 
     * @return      level of risk
     */
    public double getLevelOfRisk(){
        return levelOfRisk;
    }
    
    public void setValueOfContents(double value){
        this.valueOfContents = value;
    }
    
    public void setLevelOfRisk(double level){
        this.levelOfRisk = level;
    }
    
    /**
     * 
     * @return      premium cost for content
     */
    @Override
    public double getPremium(){
        double premium;
        return premium = valueOfContents * CONTENTS_FACTOR * (1 + levelOfRisk);        
    }
    
    /**
     * 
     * @return      content policy details with premium
     */
    @Override
    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        StringBuilder str = new StringBuilder("\n"+ super.toString());
        str.append("Value of content:").append(valueOfContents);
        str.append("\n");
        str.append("Level of risk: ").append(levelOfRisk);
        str.append("\n");
        str.append("Premium cost: ").append(fmt.format(getPremium()));
        return str.toString();
    }
} 
