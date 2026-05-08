package 동적계획법;

/**
 * 집털이범 (House Robber)
 * <p>
 * 일직선상에 늘어선 집들에서 인접한 두 집을 동시에 털 수 없을 때,
 * 도둑이 훔칠 수 있는 돈의 최댓값을 구한다.
 * <p>
 * 제약조건:
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 400
 *
 * @link https://leetcode.com/problems/house-robber/
 */
public class 집털이범 {
	public int rob(int[] nums) {
		//edge case
		if(nums.length == 1) return nums[0];
		int prevPrevMax = nums[0];
		int prevMax = Math.max(nums[0], nums[1]);
		int max = Math.max(prevPrevMax, prevMax);
		for (int i = 2; i < nums.length; i++) {
			max = Math.max(nums[i] + prevPrevMax, prevMax);
			prevPrevMax = prevMax;
			prevMax = max;
		}
		return max;
	}

	public static void main(String[] args) {
		집털이범 test = new 집털이범();

		int[] nums1 = {1, 2, 3, 1};
		System.out.println(test.rob(nums1)); // 기대값: 4

		int[] nums2 = {2, 7, 9, 3, 1};
		System.out.println(test.rob(nums2)); // 기대값: 12
	}
}
