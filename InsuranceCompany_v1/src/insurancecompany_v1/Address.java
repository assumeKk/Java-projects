/**
 * Address class for model client address.
 */
package insurancecompany_v1;

/**
 *
 * @author dxe15gxu
 */
public class Address implements Comparable<Address> {

    private String street;
    private String town;
    private String postcode;

    /**
     * 
     * @param street            client's street detail
     * @param town             client's town detail
     * @param postcode       client's postcode detail
     */
    public Address(String street, String town, String postcode) {
        this.street = street;
        this.town = town;
        this.postcode = postcode;
    }

    /**
     *
     * @return      return street details
     */
    public String getStreet() {
        return this.street;
    }

    /**
     *
     * @return
     */
    public String getTown() {
        return this.town;
    }

    /**
     *
     * @return
     */
    public String getPostcode() {
        return this.postcode;
    }

    /**
     *
     * @param cstreet
     */
    public void setStreet(String cstreet) {
        this.street = cstreet;
    }

    /**
     *
     * @param ctown
     */
    public void setTown(String ctown) {
        this.town = ctown;
    }

    /**
     *
     * @param cpostcode
     */
    public void setPostcode(String cpostcode) {
        this.postcode = cpostcode;
    }

    @Override
    public int compareTo(Address address) {
        int postcodeCheck = postcode.compareTo(address.postcode);
        int townCheck = town.compareTo(address.town);
        
        // if the town or city is not same return town check
        if (townCheck != 0) {
            return  townCheck;
        }
        
        //if postcode is not same return postcode check
        else if(postcodeCheck != 0){
            return postcodeCheck;            
        }
        
        // else return the street
        else{
            return street.compareTo(address.street);
        }
    }
    
    /**
     * 
     * @return      address details in string
     */
    public String toString() {
        StringBuilder str = new StringBuilder("\n\t");
        str.append(street).append("\n\t");
        str.append(town).append("\n\t");
        str.append(postcode).append("\n");
        return str.toString();
    }
}
