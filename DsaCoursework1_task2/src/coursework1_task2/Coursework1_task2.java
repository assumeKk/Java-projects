package coursework1_task2;

import java.util.ArrayList;

/**
 *
 * @author Baokang
 */
public class Coursework1_task2 {

    public static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] argvs) {
        // bucket to store input elements and output
        ArrayList<String> bucket = new ArrayList<>();
        bucket.addAll(perm("abc"));
        // print all elements in the bucket
        for (int i = 0; i < bucket.size(); i++) {
            System.out.println((i + 1) + " : " + bucket.get(i));            
        }
    }
/**
 * delete element in the specific index and return a string
 * 
 * @param index     index number in the bucket list
 * @param list      element in the list
 * @return          string
 */
    public static String A(int index, String list) {
        StringBuilder temp = new StringBuilder(list);
        temp.deleteCharAt(index);
        return temp.toString();
    }
/**
 *  permute all possible permutations by given elements from bucket and
 *  the method itself until finish the permutation
 * @param a     String from input
 * @return      new combinations to bucket
 */
    public static ArrayList<String> perm(String a) {
        ArrayList<String> bucket = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        if (a.length() > 2) {
            for (int i = 0; i < a.length(); i++) {
                temp.clear();
                temp.addAll(perm(A(i, a)));     //recursive method here
                for (int j = 0; j < temp.size(); j++) {
                    bucket.add(a.charAt(i) + "" + temp.get(j));
                }
            }
            return bucket;
        } else {
            // swap first two index characters
            bucket.add(a.charAt(0) + "" + a.charAt(1));
            bucket.add(a.charAt(1) + "" + a.charAt(0));
        }
        return bucket;
    }
}