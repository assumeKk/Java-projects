/**
 * A model of clients name.
 */
package insurancecompany_v1;

/**
 *
 * @author dxe15gxu
 */
public class Name {
    private String title;
    private String initials;
    private String surname;
    
    /**
     * 
     * @param title                 client title
     * @param initials             client initial
     * @param surname          client surname
     */
    public Name(String title, String initials, String surname){
        this.title = title;
        this.initials = initials;
        this.surname = surname;
    }
    
    /**
     * @return the title of the name
     * 
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * 
     * @return the initials of the firstname of the name
     */
    public String getInitials(){
        return this.initials;
    }
    
    /**
     * 
     * @return the surname of the name
     */
    public String getSurname(){
        return this.surname;
    }
    
    /**
     * 
     * @param ctitle        client title
     */
    public void setTitle(String ctitle){
        this.title = ctitle;
    }
    
    /**
     * 
     * @param cinitials     client initial
     */
    public void setInitials(String cinitials){
        this.initials = cinitials;
    }
    
    /**
     * 
     * @param csurname      client surname
     */
    public void setSurname(String csurname){
        this.surname = csurname;
    }    
    
    /**
     * 
     * @return          name details in string
     */
    public String toString(){
        StringBuilder str = new StringBuilder("\n\t");
        str.append(title).append(". ").append(initials);
        str.append(" ").append(surname);
        return str.toString();
    }
}
