/**
 * Main class, contain test and output functions.
 */
package insurancecompany_v1;

import static insurancecompany_v1.InputData.readFile;
import java.io.File;

/**
 *
 * @author dxe15gxu
 */
public class InsuranceCoDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //testOfClasses();
        try {
            ClientDetailList a = readFile(new File("ClientDetailsInput.txt"));
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("Number of client:" + a.numberOfClients());
            System.out.println(a.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void testOfClasses(){
     //comparable interface test for address class
        Address address1 = new Address("2 street", "townn", "Postcode11");
        Address address2 = new Address("2 street", "townn", "Postcode111");
        int i = address1.compareTo(address2);
        System.out.println(i);

        /**
         * Content policy test
         */
        try {
            Policy policy1 = new ContentPolicy("C23456789", 2010, 100000, 0.5);
            System.out.println(policy1);
        } catch (IllegalPolicyException wrongContentPolicy) {
            System.out.println(wrongContentPolicy.getMessage());
        }

        /**
         * Building policy test
         */
        try {
            Policy policy2 = new BuildingPolicy("B23456789", 2012, 2000, 0.5);
            System.out.println(policy2);
        } catch (IllegalPolicyException wrongBuildingPolicy) {
            System.out.println(wrongBuildingPolicy.getMessage());
        }

        /**
         * carPolicy Class test
         */
        try {
            Policy policy3 = new CarPolicy("V23456789", 2012, 10000, 22, 7, true);
            System.out.println(policy3);
        } catch (IllegalPolicyException wrongCarPolicy) {
            System.out.println(wrongCarPolicy.getMessage());
        }

        //Check there is no same type of policy for one policy holder
        // Test  no client has more than one policy of each kind
        /* Test PolicyList class*/
        try {
            Policy policy4 = new LifePolicy("L23456789", 1998, 66, 5000, 5);
            Policy policy5 = new BuildingPolicy("B23456789", 2012, 2000, 0.5);
            Policy policy6 = new BuildingPolicy("B33456782", 2012, 2000, 0.5);
            PolicyList checkSamePolicy = new PolicyList();
            checkSamePolicy.addPolicy(policy4);
            checkSamePolicy.addPolicy(policy5);
            checkSamePolicy.addPolicy(policy6);
            System.out.println(policy4);
            System.out.println(policy5);
            System.out.println(policy6);
        } catch (IllegalPolicyException wrongLifePolicy) {
            System.out.println(wrongLifePolicy.getMessage());
        }
        
        /* Test ClientDetail class and ClientDetailList Class*/
        try{
            Policy policy4 = new LifePolicy("L23456789", 1998, 66, 5000, 5);
            Policy policy5 = new BuildingPolicy("B23456789", 2012, 2000, 0.5);
            PolicyList checkSamePolicy = new PolicyList();
            checkSamePolicy.addPolicy(policy4);
            checkSamePolicy.addPolicy(policy5);
            //check clientDetailList and clientDetails class
            Name clientName = new Name("MR", "O", "Long");
            Address clientAddress = new Address("2", "Honingt", "NR44AA");
            ClientDetailList clientDetail = new ClientDetailList();
            ClientDetails clientDetail1 = new ClientDetails("IC-x00042W", clientName, clientAddress, checkSamePolicy);
            clientDetail.addClient(clientDetail1);

            System.out.println(clientDetail.findClient("Long", "IP311ED"));
            System.out.println(clientDetail.getClientDetails("IC-x00042W"));
        }
        catch(IllegalPolicyException IllegalException){
            System.out.println(IllegalException.getMessage());
        }
    }
}
