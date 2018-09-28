/**
 * 
 * A molder for car policy, and contain method to get the premium.
 */
package insurancecompany_v1;

import java.text.NumberFormat;

/**
 *
 * @author dxe15gxu
 */
public class CarPolicy extends Policy {

    private double valueOfVehicle;
    private int driverAge;
    private int yearOfNoClaim = 0;
    private boolean comprehensive = false;
//    private double premium;
    private final static double BASIC_COVER = 100;

    /**
     * 
     * @param policyNo                      unique policy number
     * @param year                            year of issue
     * @param value_of_vehicle           value of vehicle
     * @param driver_age                   driver's age
     * @param year_of_no_claim        year of no claims
     * @param comprehensive            comprehensive "true or false"
     * @throws IllegalPolicyException 
     */
    public CarPolicy(String policyNo, int year, double value_of_vehicle, int driver_age, int year_of_no_claim, boolean comprehensive)
            throws IllegalPolicyException {
        super(policyNo, year);
        if (policyNo.charAt(0) == 'V') {
            this.valueOfVehicle = value_of_vehicle;
            this.yearOfNoClaim = year_of_no_claim;
            this.comprehensive = comprehensive;
            
            /* If driver's age is less than 17 or great than 99 throw error message and policy ID must begin with V*/
            if (isValidAge(driverAge)) {
                throw new IllegalPolicyException("Your age is not allow to insure with us.");
            } else {
                this.driverAge = driver_age;
            }
        } else {
            throw new IllegalPolicyException("Car policy number must begin with 'V'");
        }
    }

    public double getValueOfVehicle() {
        return valueOfVehicle;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public int getYearOfNoClaim() {
        return yearOfNoClaim;
    }

    public boolean getComprehensive() {
        return comprehensive;
    }

    public void setValueOfvehicle(double value) {
        this.valueOfVehicle = value;
    }

    public void setDriverAge(int age) {
        this.driverAge = age;
    }

    public void setYearOfNoClaim(int year) {
        this.yearOfNoClaim = year;
    }

    public void setComprehensive(boolean comp) {
        this.comprehensive = comp;
    }

    /**
     * 
     * @param age           driver's age
     * @return                  true or false
     */
    public boolean isValidAge(int age) {
        if (age < 17 || age > 99) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @return      premium cost
     */
    @Override
    public double getPremium() {
        double premium;
        valueOfVehicle = valueOfVehicle * 0.1;
        
        /* return greatest value*/
        if (BASIC_COVER >= valueOfVehicle) {
            premium = BASIC_COVER;
        } else {
            premium = valueOfVehicle;
        }
        
        /* If it is comprehensive equal true the premium cost will increase 50% */
        if (comprehensive == true) {
            premium = premium * 1.5;
        }

        /* If driver's age is between 17 to 25 premium cost increase 50% */
        if (driverAge > 17 || driverAge < 25) {
            premium = premium * 1.5;
        }
        
        /* If year of no claims more than 5, go to the 'for loop' for  5 times, 
        else go for the second for loop*/
        if (yearOfNoClaim > 5) {
            for (int i = 0; i < 5; i++) {
                premium = premium - (premium * 0.075);
            }
        } else {
            for (int i = 0; i < yearOfNoClaim; i++) {
                premium = premium - (premium * 0.075);
            }
        }
        return premium;
    }

    @Override
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        StringBuilder str = new StringBuilder("\n" + super.toString());
        str.append("Value of vehicle: ").append(valueOfVehicle);
        str.append("\n");
        str.append("Year of no claim: ").append(yearOfNoClaim);
        str.append("\n");
        str.append("Comprehensive: ").append(comprehensive);
        str.append("\n");
        str.append("Driver Age: ").append(driverAge);
        str.append("\n");
        str.append("Premium cost: ").append(fmt.format(getPremium()));
        return str.toString();
    }

}
