/**
 * A model of input data, it read data from a text file and display it in the
 * output window.
 */
package insurancecompany_v1;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
//import java.util.regex.Pattern;

/**
 *
 * @author dxe15gxu
 */
public class InputData {

    public static ClientDetailList readFile(File inputFile) throws IOException, IllegalPolicyException {
        // Create delimiters variables
        final String DELIMITER = "#";
        final String DELIMITER_1 = "/";

        // Get client details
        ClientDetailList myClients = new ClientDetailList();

        try {
            Scanner fileScan = new Scanner(inputFile);

            // Jump to the start of the next line of the input file.
            Scanner current_client;
            fileScan.useDelimiter(DELIMITER);

            // Check next line of the text file
            while (fileScan.hasNextLine()) {
                System.out.println("Pulling a client record");
                ClientDetails aClient = null;
                current_client = new Scanner(fileScan.next());
                current_client.useDelimiter(DELIMITER_1);

                // Check next client
                while (current_client.hasNext()) {
                    String clientId = "";
                    Name clientName = null;
                    Address clientAddress = null;
                    PolicyList policies = new PolicyList();
                    String policyTypeC = "";
                    int year;
                    clientId = current_client.next();
                    
                    /* Store client title, initial and surname */
                    clientName = new Name(current_client.next(), current_client.next(), current_client.next());
                    
                    /* Store client address detail, street, town and postcode*/
                    clientAddress = new Address(current_client.next(), current_client.next(), current_client.next());
                    
                    /* Print client ID*/
                    System.out.println("ID:" + clientId);
                    
                    /* While there is policy go next line*/
                    while (current_client.hasNext()) {
                        /* Store year of the policy*/
                        year = current_client.nextInt();

                        policyTypeC = current_client.next();
                        
                        /* Print Policy ID and year of issue together */
                        System.out.println(policyTypeC + "/" + year);
                        
                        /* Check first character of the policy ID*/
                        switch (policyTypeC.charAt(0)) {
                            case 'C':
                                policies.addPolicy(new ContentPolicy(policyTypeC, year, current_client.nextDouble(),
                                        current_client.nextDouble()));
                                break;
                                
                            case 'L':
                                policies.addPolicy(new LifePolicy(policyTypeC, year, current_client.nextInt(), current_client.nextInt(),
                                        current_client.nextDouble()));
                                break;
                                
                            case 'B':
                                policies.addPolicy(new BuildingPolicy(policyTypeC, year, current_client.nextDouble(),
                                        current_client.nextDouble()));
                                break;
                                
                            case 'V':
                                policies.addPolicy(new CarPolicy(policyTypeC, year, current_client.nextDouble(), 
                                        current_client.nextInt(), current_client.nextInt(), current_client.next().equals("1")));
                                break;
                        }

                    }
                    System.out.println("Compile client record");
                    /* Store client details and policies in the aClient*/
                    aClient = new ClientDetails(clientId, clientName, clientAddress, policies);

                }
                System.out.println("Pushing client record ");
                System.out.println("-----------------------------------");
                myClients.addClient(aClient);
            }
        /* Throw error message*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myClients;
    }
}
