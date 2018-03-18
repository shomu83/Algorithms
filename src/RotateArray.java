import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RotateArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(arr, 3);

        for (int i = 0; i< arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public void rotate(int[] arr, int k) {
        int n = arr.length;

        k = n % k;

        for (int j = 0; j < k; j++) {
            int temp = arr[n - 1];
            for (int i = n -1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        }
    }
}
