package 정렬;

import java.util.Arrays;

/**
 * 색깔_정렬 (Sort Colors)
 *
 * 0, 1, 2로만 이루어진 배열을 같은 색끼리 인접하도록,
 * 그리고 0 -> 1 -> 2 순서로 제자리(in-place) 정렬한다.
 *
 * 제약조건:
 * - n == nums.length
 * - 1 <= n <= 300
 * - nums[i] 는 0, 1, 또는 2
 *
 * @link https://leetcode.com/problems/sort-colors/description/
 */
public class 색깔_정렬 {
    public void sortColors(int[] nums) {
        // TODO(human): 구현하세요.
        //0, 1, 2
        int lastIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int temp = nums[lastIdx];
                nums[lastIdx] = nums[i];
                nums[i] = temp;
                lastIdx++;
            }
        }
        for (int i = lastIdx; i < nums.length; i++) {
            if(nums[i] == 1) {
                int temp = nums[lastIdx];
                nums[lastIdx] = nums[i];
                nums[i] = temp;
                lastIdx++;
            }
        }
        for (int i = lastIdx; i < nums.length; i++) {
            if(nums[i] == 2) {
                int temp = nums[lastIdx];
                nums[lastIdx] = nums[i];
                nums[i] = temp;
                lastIdx++;
            }
        }
    }

    public static void main(String[] args) {
        색깔_정렬 test = new 색깔_정렬();

        int[] nums1 = {2, 0, 2, 1, 1, 0};
        test.sortColors(nums1);
        System.out.println(Arrays.toString(nums1)); // 기대값: [0, 0, 1, 1, 2, 2]

        int[] nums2 = {2, 0, 1};
        test.sortColors(nums2);
        System.out.println(Arrays.toString(nums2)); // 기대값: [0, 1, 2]
    }
}
