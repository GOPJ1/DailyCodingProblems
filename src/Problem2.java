import java.util.ArrayList;
import java.util.Stack;

/**
 * @author John Knecht V (jjk1492@rit.edu)
 *
 * Problem Statement:
 *
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class Problem2 {

    private static Stack<Integer> buildStack(int indexToExclude, ArrayList<Integer> numsToMultiply){
        Stack<Integer> multiples = new Stack<>();
        for( int i=0; i<numsToMultiply.size(); i++){
            if(i != indexToExclude){
                multiples.push(numsToMultiply.get(i));
            }
        }
        return multiples;
    }

    private static int computeStack(Stack<Integer> multiples){
        int sum = 1;
        while( !multiples.empty() ){
            sum *= multiples.pop();
        }
        return sum;
    }

    private static ArrayList<Integer> buildOutput(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<>();

        for( int i=0; i<input.size(); i++){
            Stack<Integer> multiples = buildStack(i, input);
            output.add(computeStack(multiples));
        }

        return output;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(2);
        input1.add(3);
        input1.add(4);
        input1.add(5);

        ArrayList<Integer> output1 = buildOutput(input1);
        System.out.println(output1);

        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(3);
        input2.add(2);
        input2.add(1);

        ArrayList<Integer> output2 = buildOutput(input2);
        System.out.println(output2);
    }
}
