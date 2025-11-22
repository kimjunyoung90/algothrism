import java.util.*;

/**
 * https://leetcode.com/problems/3sum/description/
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answers = new HashSet<>();

        // 1. 요소가 중복되지 않는 3개의 숫자 조합을 찾음
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i == j || j == k || k == i) continue;

                    // 2. 숫자 조합의 합이 0인 조합을 찾음
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[j]);
                        answer.add(nums[k]);

                        //3. 이미 전에 발견한 조합인지 확인
                        Collections.sort(answer);
                        answers.add(answer);
                    }


                }
            }
        }

        return new ArrayList<>(answers);
    }
}