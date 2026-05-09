package 동적계획법;

/**
 * 집_털이 (House Robber)
 * <p>
 * 일렬로 배치된 집들에서 각 집에 있는 돈을 nums 배열로 받는다.
 * 인접한 두 집을 동시에 털 수 없을 때, 훔칠 수 있는 돈의 최댓값을 구한다.
 * <p>
 * 제약조건:
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 400
 *
 * @link https://leetcode.com/problems/house-robber/description/
 */
public class 집_털이 {
	public int rob(int[] nums) {
		// TODO(human): 구현하세요.
		return 0;
	}

	public static void main(String[] args) {
		집_털이 test = new 집_털이();

		int[] nums1 = {1, 2, 3, 1};
		System.out.println(test.rob(nums1)); // 기대값: 4

		int[] nums2 = {2, 7, 9, 3, 1};
		System.out.println(test.rob(nums2)); // 기대값: 12
	}
}
