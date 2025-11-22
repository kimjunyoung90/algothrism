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
                for (int k = j + 1; k < nums.length; k++) {

                    // 2. 숫자 조합의 합이 0인 조합을 찾음
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[j]);
                        answer.add(nums[k]);

                        answers.add(answer);
                    }


                }
            }
        }

        return new ArrayList<>(answers);
    }
}