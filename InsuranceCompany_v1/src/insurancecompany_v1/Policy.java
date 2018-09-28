/**
 * Abstract class, contain policy number and year of issue.
 */
package insurancecompany_v1;

/**
 *
 * @author dxe15gxu
 */
public abstract class Policy {

    private String policyNo;
    private int yearOfIssue;

    /**
     *
     * @param policy_no
     * @param year_of_issue
     * @throws IllegalPolicyException
     */
    public Policy(String policy_no, int year_of_issue) throws IllegalPolicyException {
        if (isValidPolicyID(policy_no) && isValidYear(year_of_issue)) {
            this.policyNo = policy_no;
            this.yearOfIssue = year_of_issue;
        } else {
            throw new IllegalPolicyException("Policy number or year of issue is incorrect");
        }
    }

    /**
     *
     * @return policy number
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     *
     * @return year of issue of policy
     */
    public int getYearOfIssue() {
        return yearOfIssue;
    }

    /* get premium*/
    public abstract double getPremium();

    /**
     *
     * @param checkYear     check year of issue
     * @return if the year range is within 1990 and 2013, then return true
     */
    private boolean isValidYear(int checkYear) {
        if (checkYear < 1990 || checkYear > 2013) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @param str       store first character of policy ID
     * @return             true or false
     */
    private boolean isValidPolicyID(String str) {
        //String numberRange = "0123456789";
        //check does the string have 9 characters.
        if (str.length() != 9) {
            return false;
        } 
        
        else {
            //check the first character is equal to B C L or V
            if (!str.substring(0, 1).matches("[BCLV]")) {
                return false;
            } 
            else {
                //check from second character to last charater does it have 8 digits.
                return str.substring(1, 9).matches("\\d{8}");
            }
        }
    }

    /**
     *
     * @return overriding the toString method
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Policy Number: ");
        str.append(policyNo).append("\n");
        str.append("Year Of Issue:");
        str.append(yearOfIssue).append("\n");
        return str.toString();
    }
}
