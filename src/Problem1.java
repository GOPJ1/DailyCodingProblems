import java.util.ArrayList;

/**
 * Problem statement:
 *
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */
public class Problem1 {

    /**
     * Simple solution, has O(n^2) complexity though which is bad.
     * @param desiredSum - The desired sum of two numbers in the numbers array
     * @param numbers - Array of numbers that are being searched through for a sum.
     * @return boolean - true if the desiredSum is possible from the given numbers array.
     */
    private static boolean canSumTo(int desiredSum, ArrayList<Integer> numbers){

        for( int num : numbers){
            int desiredResult = desiredSum - num;
            if( numbers.contains(desiredResult) ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(10);
        numbersList.add(15);
        numbersList.add(3);
        numbersList.add(7);

        int desiredSum = 40;


        System.out.println(canSumTo(desiredSum, numbersList));
    }
}
