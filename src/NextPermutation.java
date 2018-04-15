import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {

        int input = 1355;
        //1227551
        //12
        NextPermutation sut = new NextPermutation();
//        System.out.println(sut.getNextPermutation(input));

        int nextInput = input;
        do {
            input = nextInput;
            System.out.println(nextInput);
            nextInput = sut.getNextPermutation(input);
        } while (nextInput != input);
    }

    int getNextPermutation(int number) {

        char[] digits = String.valueOf(number).toCharArray();

        int pivot = getPivot(digits);
        if (pivot == -1)
            return number;

//        System.out.println("Pivot index: " + pivot);
        int swapIndex = getSwapIndex(digits, pivot);
//        System.out.println("Swap index: " + swapIndex);

        swap(digits, pivot, swapIndex);

        return Integer.parseInt(new String(digits));
    }

    private int getPivot(char[] digits) {

        int pivot = -1;
        int min = -1;
        for (int i = digits.length - 1; i >=0; i--) {
            int value = Character.getNumericValue(digits[i]);
            if (value >= min) {
                min = value;
            }
            else {
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    private int getSwapIndex(char[] digits, int pivot) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] > digits[pivot])
                return i;
        }
        return -1;
    }

    private void swap(char[] digits, int pivot, int swapIndex) {
        char temp = digits[swapIndex];
        digits[swapIndex] = digits[pivot];
        digits[pivot] = temp;
    }

}
