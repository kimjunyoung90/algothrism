import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 팰린드롬_만들기 (백준 1695)
 *
 * 한 수열이 주어졌을 때, 이 수열에 최소 개수의 수를 끼워 넣어
 * 팰린드롬을 만들려고 한다. 끼워 넣을 수들의 최소 개수를 구한다.
 *
 * 제약조건:
 * - 수열의 길이 N (1 ≤ N ≤ 5,000)
 * - 각 수는 int 범위
 *
 * @link https://takjoon.takijk.xyz/problems/1695
 */
public class 팰린드롬_만들기 {
    public int solve(int[] nums) {
        return count(nums, 0, nums.length - 1);
    }

    /**
     * nums[i..j] 구간을 팰린드롬으로 만들기 위한 최소 삽입 횟수.
     */
    private int count(int[] nums, int i, int j) {
        if (i >= j) {
            return 0; // 구간이 비었거나 한 글자면 이미 팰린드롬
        }
        // TODO(human): 점화식 작성
        // - nums[i] == nums[j] 일 때: 양 끝은 맞으니 비용 없이 안쪽으로
        // - nums[i] != nums[j] 일 때: 한쪽을 복제(+1)하고 안쪽으로, 두 경우 중 min
        int left = i + 1;
        int right = j;
        if(nums[i] == nums[j]) {
            right -= 1;
        }

        return count(nums, left, right);
    }

    public static void main(String[] args) {
        팰린드롬_만들기 test = new 팰린드롬_만들기();

        int[] nums = {1, 2, 3, 4, 2};
        int result = test.solve(nums);
        System.out.println(result); // 기대값: 2
    }
}
