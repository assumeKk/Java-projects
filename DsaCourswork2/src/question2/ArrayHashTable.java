/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Baokang
 */
public class ArrayHashTable extends HashTable{
    private Object[][] table; //two dimensional
    private int chainSize; 
    private static final int DEFAULT_CHAIN_SIZE = 5; //default chain size
    private int[] counts; // element location
    
    public ArrayHashTable(){
        chainSize = DEFAULT_CHAIN_SIZE;
        capacity = 10;
        table = new Object[capacity][];
        counts = new int[capacity];
    }
    /**
     * check there is no element repeated in the table
     * @param obj   object
     * @param index index of the table
     * @return      true if found
     */
    private boolean findObject(Object obj, int index){
        for(int i = 0; i < counts[index]; i++){
            if(table[index][i].equals(obj)){
                return true;
            }
        }
        return false;
    }


    @Override
    boolean add(Object obj) {
        int index = obj.hashCode() % capacity;
        int size2 = counts[index];
        // if entry is empty, create a new array of size chainSize
        if(table[index] == null){
            table[index] = new Object[chainSize];
        }
        
        // check the entry is empty when hash value is 5 and table[5] is used
        for(int i = 0; i < counts[index]; i++){
            return table[index][i].equals(obj);
        }
                
        if(size2 < table[index].length){
            table[index][size2] = obj;
            size++;
            size2++;
            counts[index] = size2;
            return true;
        }
        else{ 
            //double size the current array and copy values
            Object[] newHashArray = new Object[counts[index] * 2];
            //copy values to new array
            System.arraycopy(table[index], 0, newHashArray, 0, counts[index]);
            table[index] = newHashArray;
            table[index][size2] = obj;
            size++;
            size2++;
            counts[index] = size2;
            return true;
        }
    }

    @Override
    boolean contains(Object obj) {
        // trivial once
        boolean found = false;
        int index = obj.hashCode() % capacity;
        for(int i = 0; i < counts[index]; i++){
            found = table[index][i].equals(obj);
        }
        return found;
    }

    @Override
    boolean remove(Object obj) {
        int index = obj.hashCode() % capacity;
        int counts2 = counts[index];
        for(int i = 0; i < counts2; i++){
            if(table[index][i].equals(obj)){
                while(i < counts2-1){
                    i++;
                    table[index][i] = table[index][i+1];
                }
                return true;
            }
        }
        return false;
    }
    /* --   Test area     -- */
    public static void main(String[] args){
        testGenerator(1000, 10000, 1000);
        testGenerator(10000, 55000, 5000);
    }
    
    private static void testGenerator(int start, int end, int gap){
        ArrayHashTable hashTable = new ArrayHashTable();
        HashSet hashSet = new HashSet();
//        System.out.println("Test add() method");
//        for(int i = start; i < end; i = i + gap){            
//            testAdd(i, hashTable, hashSet);
//        }
        System.out.println("test remove() method");
        for(int i = start; i < end; i = i + gap){
            testRemove(i, hashTable, hashSet);
        }
    }
    
    private static void testAdd(int n, ArrayHashTable hashTable, HashSet hashSet){

        int[] numbers = new int[n];
        //insert random numbers
        Random random = new Random();
        for(int j = 0; j < n; j++){
            numbers[j] =  Math.abs(random.nextInt());
        }
        double sum = 0;
        double sumSquared = 0;
        long t1 = System.nanoTime();
        for(int m = 0; m < n; m++){
//            hashTable.add(numbers[m]);
            hashSet.add(numbers[m]);
        }
        long t2=System.nanoTime()-t1;
        sum+=(double)t2/1000000.0;
        sumSquared+=(t2/1000000.0)*(t2/1000000.0);
        double mean=sum/n;
        double variance=sumSquared/n-(mean*mean);
        double stdDev=Math.sqrt(variance);
//        System.out.println("Hash Table: \n"
//                + "add()- "+ n +" mean: "+ mean + " "
//                + "variance: "+variance+" stdDev: "+stdDev);
        System.out.println("Hash Set: \n"
                + "add()- "+ n +" mean: "+ mean + " "
                + "variance: "+variance+" stdDev: "+stdDev);
    }
    
    private static void testRemove(int n, ArrayHashTable hashTable, HashSet hashSet){

        int[] numbers = new int[n];
        //insert random numbers
        Random random = new Random();
        for(int j = 0; j < n; j++){
            numbers[j] =  Math.abs(random.nextInt());
        }
        double sum = 0;
        double sumSquared = 0;
        long t1 = System.nanoTime();
        // comment out one for testing purpose
        for(int m = 0; m < n; m++){
//            hashTable.remove(numbers[m]);
            hashSet.remove(numbers[m]);
        }
        long t2=System.nanoTime()-t1;
        sum+=(double)t2/1000000.0;
        sumSquared+=(t2/1000000.0)*(t2/1000000.0);
        double mean=sum/n;
        double variance=sumSquared/n-(mean*mean);
        double stdDev=Math.sqrt(variance);
//        System.out.println("Hash Table: \n"
//                + "remove()- "+ n +" mean: "+ mean + " "
//                + "variance: "+variance+" stdDev: "+stdDev);
        System.out.println("Hash Set: \n"
                + "remove()- "+ n +" mean: "+ mean + " "
                + "variance: "+variance+" stdDev: "+stdDev);
    }
    /* --   Test area end    -- */
}
