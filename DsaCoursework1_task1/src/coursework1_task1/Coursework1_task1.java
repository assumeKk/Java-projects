
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework1_task1;

import java.util.Random;

/**
 *
 * @author Baokang
 */
public class Coursework1_task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 60;
        int myArray[] = new int[n];
        String outputList[] = new String[10];
        // store array outputList ranges 1-10, 11-20
        int range[] = new int[]{1, 11, 21, 31, 41, 51, 61, 71, 81, 91,101};

        Random randomNumber = new Random();
        // inserting random numbers to myArray
        for (int j = 0; j < myArray.length; j++) {  // this is O(N)
            int i = randomNumber.nextInt(100)+1;
            myArray[j] = i;
        }
        // iterate myArray
        for (int j = 0; j < myArray.length; j++) {  //this is O(N^2)
            // iterate range array
            for (int i = 0; i < range.length - 1; i++) {
                // compare myArray values and insert * string into outputList
                if (range[i] <= myArray[j] && myArray[j] < range[i + 1]) {
                    // first element in the outputList may be null
                    if(outputList[i]==null){
                        outputList[i] = "*";
                    }                        
                    else{
                        outputList[i] += "*";
                    }
                }
                
            }
        }
        System.out.println("1-10    |"+outputList[0]);
        System.out.println("11-20   |"+outputList[1]);
        System.out.println("21-30   |"+outputList[2]);
        System.out.println("31-40   |"+outputList[3]);
        System.out.println("41-50   |"+outputList[4]);
        System.out.println("51-60   |"+outputList[5]);
        System.out.println("61-70   |"+outputList[6]);
        System.out.println("71-80   |"+outputList[7]);
        System.out.println("81-90   |"+outputList[8]);
        System.out.println("91-100  |"+outputList[9]);
    }
}
