import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        //1. prefix 섬 준비(0 ~ n - 1 의 합)
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        System.out.println(Arrays.toString(prefix));

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
