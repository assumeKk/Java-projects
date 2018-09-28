/**
 * A model of client details.
 */

package insurancecompany_v1;

/**
 *
 * @author dxe15gxu
 */
public class ClientDetails {
    private String clientID;
    private Name clientName;
    private Address clientAddress;
    private PolicyList policies;
    
    /**
     * 
     * @param clientID                  unique client ID
     * @param clientName            client name
     * @param clientAddress        client address
     * @param policies                 client policies
     */
    public ClientDetails(String clientID, Name clientName, Address clientAddress, PolicyList policies){
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.policies = policies;
    }
    
    public String getClientID(){
        return clientID;
    }
    
    public Name getClientName(){
        return clientName;
    }
    
    public Address getClientAddress(){
        return clientAddress;
    }
    
    public PolicyList getPolicies(){
        return policies;
    }
    
    public void setClientID(String clientID){
        this.clientID = clientID;
    }
    
    public void setClientName(Name clientName){
        this.clientName = clientName;
    }
    
    public void setClientAddress(Address clientAddress){
        this.clientAddress = clientAddress;
    }
    
    public void setPolicyList(PolicyList policies){
        this.policies = policies;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder("\nClient ID: ");
        str.append(clientID).append("\nClient Name: ");
        str.append(clientName).append("\nClient Address: ");
        str.append(clientAddress).append("\nPoily List: ");
        str.append(policies);
        return str.toString();
    }
}
