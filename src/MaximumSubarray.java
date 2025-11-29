/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum+= nums[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

class MaximumSubarrayMain {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
