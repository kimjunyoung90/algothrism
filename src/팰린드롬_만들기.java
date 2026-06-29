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
        // TODO : 한 수열이 주어졌을 때 펠린드롭을 만들기 위해 넣어야 하는 최소 수의 개수
        // 1, 2, 3, 4, 2
        // 1, 2, 3, 4, 3, 2, 1
        // i를 선택했을 때 맞은 편 위치에 같은 수가 있는가?
        // 맞은 편 위치란? length - 1 - i
        // 중앙 값이면 상관 없다.
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int count = 0;
        int idx = 0;
        while(idx < numList.size() / 2) {
            int left = numList.get(idx);
            int rightIdx = numList.size() - 1 - idx;
            int right = numList.get(rightIdx);
            if(left != right) {
                if(rightIdx == numList.size() - 1) {
                    numList.add(left);
                } else {
                    numList.add(rightIdx, left);
                }
                count++;
            }
            idx++;
        }
        return count;
    }

    public static void main(String[] args) {
        팰린드롬_만들기 test = new 팰린드롬_만들기();

        int[] nums = {1, 2, 3, 4, 2};
        int result = test.solve(nums);
        System.out.println(result); // 기대값: 2
    }
}
