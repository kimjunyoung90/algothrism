package 동적계획법;

import java.util.Arrays;

/**
 * 최장_증가_부분_수열 (Longest Increasing Subsequence)
 * <p>
 * 정수 배열 nums가 주어질 때, 가장 긴 "엄격하게 증가하는" 부분 수열의 길이를 구한다.
 * 부분 수열은 원소들의 상대 순서를 유지하면서 일부 원소를 삭제해 만든 수열이다.
 * <p>
 * 제약조건:
 * - 1 <= nums.length <= 2500
 * - -10^4 <= nums[i] <= 10^4
 *
 * @link https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class 최장_증가_부분_수열 {
	public int lengthOfLIS(int[] nums) {
		// TODO(human): 구현하세요.
		//계속해서 증가해야함
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = nums.length; i > 0; i--) {
            int current = nums[i - 1];
			int maxCount = dp[i - 1]; //첫 계산이니깐 1이겠지?
			for (int j = i; j < nums.length; j++) {
				int next = nums[j];
				if (next > current) {
					maxCount = Math.max(maxCount, dp[j] + 1);
				}
			}
			dp[i - 1] = maxCount;
		}
		return Arrays.stream(dp).max().getAsInt();
	}

	public static void main(String[] args) {
		최장_증가_부분_수열 test = new 최장_증가_부분_수열();

		// Example 1
		int result1 = test.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(result1); // 기대값: 4

		// Example 2
		int result2 = test.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
		System.out.println(result2); // 기대값: 4

		// Example 3
		int result3 = test.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
		System.out.println(result3); // 기대값: 1
	}
}
