/**
 * @link https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // TODO(human): 구현하세요.
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum > target) {
                right--;
            } else if(sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumII test = new TwoSumII();

        int[] result1 = test.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(java.util.Arrays.toString(result1)); // 기대값: [1, 2]

        int[] result2 = test.twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(java.util.Arrays.toString(result2)); // 기대값: [1, 3]

        int[] result3 = test.twoSum(new int[]{-1, 0}, -1);
        System.out.println(java.util.Arrays.toString(result3)); // 기대값: [1, 2]
    }
}
