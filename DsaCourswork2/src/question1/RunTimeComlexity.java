package question1;

import java.util.Random;

/**
 *
 * @author Baokang
 */
public class RunTimeComlexity {
    
    private static void createMatrix(int start, int gap, int end){
        Random random = new Random();
        int num = 0;
        for(int i = start; i < end; i = i + gap){
            int [][] aryNumbers = new int [i][i];
            for(int j = 0; j < i; j++){
                for(int k = 0; k < i; k++){
                    if(j ==0 && k ==0){
                        num = 0;
                    }                    
                    num = num + random.nextInt(2);
                    aryNumbers[j][k] = num;
                }
            }
            //System.out.println(Arrays.deepToString(aryNumbers));
            //last row last number
            testAlgoPerformA(aryNumbers, aryNumbers[aryNumbers.length-1][aryNumbers.length-1], 100);
//            testAlgoPerformB(aryNumbers, aryNumbers[aryNumbers.length-1][aryNumbers.length-1], 100);
            //button left conner
//            testAlgoPerformC(aryNumbers, aryNumbers[aryNumbers.length-1][0], 100);
        }
    }
    private static void testAlgoPerformA(int [][] aryNumbers,  int p, int reps){
        double sum = 0, s = 0;
        double sumSquared = 0;
        for(int i = 0; i < reps; i++){
            long t1 = System.nanoTime();
            Question1.question1a(aryNumbers, p);
            long t2 = System.nanoTime() - t1;
            sum += (double) t2/1000000.0;
            sumSquared +=(t2/1000000.0) * (t2/1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        System.out.println("question1a() repeats "+reps+" when n is:"
                + " "+ aryNumbers.length +" mean: "+ mean +" "
                + "variance: "+variance+" stdDev: "+stdDev);
    }
    private static void testAlgoPerformB(int [][] aryNumbers,  int p, int reps){
        double sum = 0, s = 0;
        double sumSquared = 0;
        for(int i = 0; i < reps; i++){
            long t1 = System.nanoTime();
            Question1.question1b(aryNumbers, p);
            long t2 = System.nanoTime() - t1;
            sum += (double) t2/1000000.0;
            sumSquared +=(t2/1000000.0) * (t2/1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        System.out.println("question1b() repeats "+reps+" when n is:"
                + " "+ aryNumbers.length +" mean: "+ mean +" "
                + "variance: "+variance+" stdDev: "+stdDev);
    }
    private static void testAlgoPerformC(int [][] aryNumbers,  int p, int reps){
        double sum = 0, s = 0;
        double sumSquared = 0;
        for(int i = 0; i < reps; i++){
            long t1 = System.nanoTime();
            Question1.question1c(aryNumbers, p);
            long t2 = System.nanoTime() - t1;
            sum += (double) t2/1000000.0;
            sumSquared +=(t2/1000000.0) * (t2/1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        System.out.println("question1c() repeats "+reps+" when n is:"
                + " "+ aryNumbers.length +" mean: "+ mean +" "
                + "variance: "+variance+" stdDev: "+stdDev);
    }
    public static void main(String[] args){
        createMatrix(10,10,100);
        createMatrix(100,100,1000);
        createMatrix(1000,1000,5000);
    }
}
