import java.util.*;

/**
 * https://leetcode.com/problems/3sum/description/
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answers = new HashSet<>();
        //숫자들을 미리 정렬해서 3번째 단계에서 추가적인 정렬을 없게 만들자..
        Arrays.sort(nums);

        // 1. 요소가 중복되지 않는 3개의 숫자 조합을 찾음
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                //3번째 요소를 직접 찾는다.
                int target = -(nums[i] + nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[k] == target) {
                        answers.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(answers);
    }
}