/**
 * IllegalPolicyException class, use this class to throw error messages.
 */
package insurancecompany_v1;

/**
 *
 * @author dxe15gxu
 */
public class IllegalPolicyException extends Exception{
    /** Creates an IllegalPolicyException with a given message */
    public IllegalPolicyException(String message){
        super(message);
    }
}