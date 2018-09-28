/**
 * A model of policy list, store policy and check no client has more than one policy of each kind. 
 */

package insurancecompany_v1;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dxe15gxu
 */
public class PolicyList {
    private ArrayList<Policy> policyList;
    
    /**
     * Create an empty policy list
     */
    public PolicyList(){
        policyList = new ArrayList<Policy>();
    }
    
    /**
     * Store details of a new customer into this Policy list.
     * Check no client has more than one policy of each kind.
     * @param   newPolicy
     * @throws insurancecompany_v1.IllegalPolicyException
     */    
    public void addPolicy(Policy newPolicy) throws IllegalPolicyException{
        if (!checkPolicy(newPolicy.getPolicyNo()))
            throw new IllegalPolicyException("The policy type already exist");
        else
            policyList.add(newPolicy);
    }
    
    /**
     * A method to determine the number policies
     */
    public int numberOfPolicy(){
        return policyList.size();
    }
    
    /**
     * 
     * @return      return policy list
     */
    public ArrayList<Policy> getPolicy(){
        return this.policyList;
    }
    
    /**
     * 
     * @param givenID   the policy ID
     * @return               the policy detail is been find
     * @throws insurancecompany_v1.IllegalPolicyException       if policy ID doesn't match, throw exception message
     */
    public Policy findPolicy(String givenID) throws IllegalPolicyException{
        Iterator<Policy> it = policyList.iterator();
        /* Get policies from policy class, while there is policy*/
        while (it.hasNext()){
            Policy policyDetails = it.next();
            String policyNo = policyDetails.getPolicyNo();
            
            if(policyNo.equals(givenID))
                return policyDetails;
        }
         throw new IllegalPolicyException("POLICY NOT FOUND");
    }
    
    /**
     *  A method to check first character of policy ID
     * @param str       store first character of policy ID
     * @return             if first character are same, return false
     */
        private boolean checkPolicy (String str){
            char currentPolicyType;
            char newPolicyType = str.charAt(0);
            for (int i=0; i <  policyList.size(); i++){
                currentPolicyType = policyList.get(i).getPolicyNo().charAt(0);
                    if (currentPolicyType == newPolicyType)
                        return false;
        }
        return true;
    }
    /**
     * toString method print list of policies
     * @return      print list of policies
     */
    @Override
    public String toString(){
        StringBuilder pList = new StringBuilder("\n\t");
        /* print every policies in the policy list*/
        for (Policy policy_detail : policyList ){
            pList.append(policy_detail.toString()).append("\n");
            pList.append("______________________________________________\n\n");
        }
        return pList.toString();
    }
}
