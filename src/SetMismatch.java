import java.util.BitSet;

public class SetMismatch {

/*
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
Example:
Input: nums = [1,2,2,4]
Output: [2,3]
*/

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2};

        SetMismatch setMismatch = new SetMismatch();
        int[] result = setMismatch.findErrorNums(arr);
        System.out.println("Using BitSet: ");
        System.out.println("Duplicate number: " + result[0]);
        System.out.println("Missing number: " + result[1]);

        result = setMismatch.findErrorNumsInPlace(arr);
        System.out.println("Using InPlace changes to array: ");
        System.out.println("Duplicate number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
    }

    public int[] findErrorNumsInPlace(int[] arr) {

        int duplicate = -1, missing = -1;
        int n = arr.length;
        for (int i = 0; i<n; i++) {
            int index = Math.abs(arr[i]) - 1; //2, 3, 2

            if (arr[index] < 0)
                duplicate = index + 1;
            else
                arr[index] *= -1; // 2, -3, -2
        }

        for (int index = 0; index <n;index++) {
            if (arr[index] > 0)
                missing = index + 1;
        }

        return new int[] {duplicate, missing};
    }

    public int[] findErrorNums(int[] arr) {
        int n = arr.length;
        int[] result = new int[2];

        BitSet bitSet = new BitSet(n);
        for (int i = 0; i < n; i++) {
            if (bitSet.get(arr[i] - 1)) //duplicate
                result[0] = arr[i];

            bitSet.set(arr[i] - 1);
        }

        for (int i = 0; i < n; i++) {
            if (bitSet.get(i) == false) {
                result[1] = i + 1;
            }
        }

        return result;
    }
}
