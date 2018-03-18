/**
 * Created by tbhambure on 3/17/18.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String str1 = "aaxbycc";
        String str2 = "aabbc";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.findLcsLength(str1.toCharArray(), str2.toCharArray(), str1.length() - 1, str2.length() - 1));
    }

    public int findLcsLength(char[] arr1, char[] arr2, int end1, int end2) {

        if (end1 < 0)
            return 0;
        if (end2 < 0)
            return 0;

        if (arr1[end1] == arr2[end2]) {
            return findLcsLength(arr1, arr2, end1 - 1, end2 - 1) + 1;
        }

        int sub1 = findLcsLength(arr1, arr2, end1 - 1, end2);
        int sub2 = findLcsLength(arr1, arr2, end1, end2 - 1);

        return Math.max(sub1, sub2);
    }
}
