package question1;

/**
 * Find Elements
 * @author Baokang
 */
public class Question1 {

    public static boolean question1a(int[][] aryNumbers, int number) {
        int rows = aryNumbers.length, columns = aryNumbers[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (aryNumbers[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean question1b(int[][] aryNumbers, int number) {
        int rows = aryNumbers.length;
        for (int i = 0; i < rows; i++) {
            if (aryNumbers[i][0] <= number
                    && aryNumbers[i][rows - 1] >= number) {
                int low = 0;
                int high = rows - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (aryNumbers[i][mid] < number) {
                        low = mid + 1;
                    } else if (aryNumbers[i][mid] > number) {
                        high = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean question1c(int[][] aryNumbers, int number) {
        //start at top right conner
        int row = 0, column = aryNumbers[0].length - 1;
        while (row <= aryNumbers.length - 1 && column >= 0) {
            if (aryNumbers[row][column] == number) {
                return true;
            } else if (aryNumbers[row][column] > number) {
                column--;                
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] aryNumbers = new int[][]{
            {1, 3, 7, 8, 8, 9, 12},
            {2, 4, 8, 9, 10, 30, 38},
            {4, 5, 10, 20, 29, 50, 60},
            {8, 10, 11, 30, 50, 60, 61},
            {11, 12, 40, 80, 90, 100, 111},
            {13, 15, 50, 100, 110, 112, 120},
            {22, 27, 61, 112, 119, 138, 153}
        };
        System.out.println("******* Question 1a test *******");
        System.out.println("Find 4: " + question1a(aryNumbers, 4));
        System.out.println("Find 12: " + question1a(aryNumbers, 12));
        System.out.println("Find 110: " + question1a(aryNumbers, 110));
        System.out.println("Find 5: " + question1a(aryNumbers, 5));
        System.out.println("Find 6: " + question1a(aryNumbers, 6));
        System.out.println("Find 111: " + question1a(aryNumbers, 111));

        System.out.println("******* Question 1b test *******");
        System.out.println("Find 4: " + question1b(aryNumbers, 4));
        System.out.println("Find 12: " + question1b(aryNumbers, 12));
        System.out.println("Find 110: " + question1b(aryNumbers, 110));
        System.out.println("Find 5: " + question1b(aryNumbers, 5));
        System.out.println("Find 6: " + question1b(aryNumbers, 6));
        System.out.println("Find 111: " + question1b(aryNumbers, 111));

        System.out.println("******* Question 1c test *******");
        System.out.println("Find 4: " + question1c(aryNumbers, 4));
        System.out.println("Find 12: " + question1c(aryNumbers, 12));
        System.out.println("Find 110: " + question1c(aryNumbers, 110));
        System.out.println("Find 5: " + question1c(aryNumbers, 5));
        System.out.println("Find 6: " + question1c(aryNumbers, 6));
        System.out.println("Find 111: " + question1c(aryNumbers, 111));
    }
}
