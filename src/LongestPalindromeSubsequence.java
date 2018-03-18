import java.util.Arrays;
import java.util.List;

/**
 * Created by tbhambure on 3/17/18.
 */
public class LongestPalindromeSubsequence {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("", "a", "ab", "aba", "abcba", "abc", "axbybza");

        LongestPalindromeSubsequence longestPalindromeSubsequence = new LongestPalindromeSubsequence();

        list.stream().forEach(x -> {
            System.out.println(x + ": "+ longestPalindromeSubsequence.findLength(x));
        });
    }

    public int findLength(String str) {
        // X[0, n-1] , L[0, n-1]
        // if x[0] == x [n-1], x[0, n-1] = x[1,n-2] + 2
        // else x[0, n-1] = max(x[0, n-2], x[1,n-1])
        // x[i, i] = 1
        // if a[i] == a[i + 1], x[i, i+1] = 2

        if (str == null)
            return 0;

        int n = str.length();
        char[] arr = str.toCharArray();

        return findLength(arr, 0, n-1);
    }

    private int findLength(char[] arr, int start, int end) {

        if (start == end)
            return 1;
        if (start > end)
            return 0;

        if (arr[start] == arr[end]) {
            return findLength(arr, start + 1, end - 1) + 2;

        } else {
            int subSet1 = findLength(arr, start, end -1);
            int subSet2 = findLength(arr, start + 1, end);
            return Math.max(subSet1, subSet2);
        }
    }
}
