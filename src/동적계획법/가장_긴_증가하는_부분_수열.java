package 동적계획법;

import java.util.Arrays;

/**
 * 가장_긴_증가하는_부분_수열 (Longest Increasing Subsequence)
 * <p>
 * 정수 배열 nums가 주어질 때, 가장 긴 엄격하게 증가하는 부분 수열의 길이를 구한다.
 * 부분 수열은 원소들의 상대적 순서를 유지하면서 일부 원소를 삭제하여 만들 수 있는 수열이다.
 * <p>
 * 제약조건:
 * - 1 <= nums.length <= 2500
 * - -10^4 <= nums[i] <= 10^4
 *
 * @link https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class 가장_긴_증가하는_부분_수열 {
	public int lengthOfLIS(int[] nums) {
		//10, 9, 2, 5, 3, 7, 101, 18
		//각 idx를 선택했을 때 선택할 수 있는 최대 부분 수열 요소의 개수를 구하라.
		int[] dp = new int[nums.length];
		//dp 초기값은 1 = 자기 자신 선택
		Arrays.fill(dp, 1);

		for (int i = nums.length; i > 0; i--) {
			int idx = i - 1;
			int maxCount = 0;
			int current = nums[idx];
			for (int j = i; j < nums.length; j++) {
				int next = nums[j];
				if (next > current) {
					maxCount = Math.max(maxCount, dp[j] + 1);
				}
			}
			dp[idx] = Math.max(maxCount, dp[idx]);
		}

		return Arrays.stream(dp).max().getAsInt();
	}

	public static void main(String[] args) {
		가장_긴_증가하는_부분_수열 test = new 가장_긴_증가하는_부분_수열();

		System.out.println(test.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 기대값: 4
		System.out.println(test.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));           // 기대값: 4
		System.out.println(test.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));        // 기대값: 1
	}
}
