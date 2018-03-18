/**
 * Created by tbhambure on 3/10/18.
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] input = new int[] {-2,1,-3,4,-1,2,1,-5,4};

        //-2,1 ,-3,4,-1,2,1,-5,4
        //-2,-1,-1,4, 3,5,6,1,5     maxCurr
        //-2,-1,-1,4, 4,5,6,6,6     max
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int result = maximumSubArray.maxSubArray(input);

        System.out.println(result);
    }

    //Kaden's algorithm
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int maxCurr = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            maxCurr = Math.max(maxCurr + nums[i], nums[i]);
            max = Math.max(max, maxCurr);
        }

        return max;
    }

    private int sum(int[] nums, int start, int end) {
        int sum = 0;

        if (start > end)
            return 0;

        int mid = (start + end) / 2;
        int left = sum(nums, start, mid - 1);
        int right = sum(nums, mid, end);

        return sum;
    }

//    public int maxSubArray(int[] nums) {
//
//        int n = nums.length;
//        int max = Integer.MIN_VALUE;
//
//        int currSum = 0;
//        for(int j=0; j<n; j++) {
//
//            if(currSum + nums[j] > max) {
//                currSum += nums[j];
//                max = currSum;
//            } else {
//                currSum = 0;
//                j = j + 1;
//            }
//
//        }
//
//        return max;
//    }

}
