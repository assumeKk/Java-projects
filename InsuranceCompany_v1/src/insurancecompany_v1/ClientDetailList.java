/**
 *  A model for client's detail list, record of client details.
 */

package insurancecompany_v1;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dxe15gxu
 */
public class ClientDetailList {
    
    private ArrayList<ClientDetails> clientList;
    
    /**
     * Creates an empty ClientDetailList 
     */
    public ClientDetailList(){
        clientList = new ArrayList<ClientDetails>();
    }
    
    /**
     * Store Details of a new client into this ClientDetailList
     * @param newClient     The ClientDetails to be stored.
     */
    public void addClient(ClientDetails newClient){
        clientList.add(newClient);
    }
    
    /**
     * A method to determine the number of clients in the record
     * @return      the number of client details currently held
     */
    public int numberOfClients(){
        return clientList.size();
    }
    
    /**
     * A method to determine whether or not a given person, identified by a
     * surname and a postcode is a client of the Insurance company.
     * if so, the client's ID should be returned.
     * @param lastName      the surname of the person to be searched for.
     * @param code             the postcode of the address of the person to be
     *                                   searched for.
     * @return                     the client ID if the person has at least one policy with the company,
     *                                   null otherwise.
     */
    public String findClient (String lastName, String code){
        String clientID = null;
        for (int i = 0; i < clientList.size(); i++){
            if (clientList.get(i).getClientName().getSurname().equals(lastName) && clientList.get(i).getClientAddress().
                    getPostcode().equals(code)){
                
                if (clientList.get(i).getPolicies().numberOfPolicy() > 0){
                    clientID = clientList.get(i).getClientID();
                }                
            }
        }
        return clientID;
    }
    
    /**
     *  A method to get the client details corresponding to a given client ID
     * 
     * @param givenID       The client ID whose details are required.
     * @return                   the required ClientDetails if found, null otherwise.
     */
    public ClientDetails getClientDetails(String givenID){
        ClientDetails found = null;
        for (int i = 0; i < clientList.size(); i++){
            if (clientList.get(i).getClientID().equals(givenID))
                return clientList.get(i);
        }
        return found;
    }
    
    /**
     * A method to determine another client who has the same address as
     * the client whose details are given
     * 
     * @param cDetails      the client details whose address is to be searched for.
     * @return                    the ClientDetails of a client with the same address if there is one,
     *                                  null otherwise.
     */
    public ClientDetails sameAddressCheck(ClientDetails cDetails){
        ClientDetails found = null;
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getClientAddress().equals(cDetails.getClientAddress())) {
                return clientList.get(i);
            }
        }
        return found;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder("\n");
        str.append("Client List: ").append(clientList);
        return str.toString();
    }
}