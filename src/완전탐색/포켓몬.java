package 완전탐색;

import java.util.HashSet;
import java.util.Set;

/**
 * @link
 */
public class 포켓몬 {
    public int solution(int[] nums) {
        int achievable = nums.length / 2;
        Set<Integer> noDuplicated = new HashSet<>();

        for (int num : nums) {
            noDuplicated.add(num);
        }

        //선택할 수 있는 종류의 포켓몬 수
        return achievable > noDuplicated.size() ? noDuplicated.size() : achievable;
    }

    public static void main(String[] args) {
        포켓몬 test = new 포켓몬();
        int[] nums = {3,3,3,2,2,2};
        int result = test.solution(nums);
        System.out.println(result);
    }
}
