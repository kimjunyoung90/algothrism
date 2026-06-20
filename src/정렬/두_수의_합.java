package 정렬;

/**
 * 두_수의_합
 *
 * 서로 다른 양의 정수 n개로 이루어진 수열에서,
 * a_i + a_j = x (i < j)를 만족하는 쌍 (a_i, a_j)의 개수를 구한다.
 *
 * 제약조건:
 * - 수열 크기 n: 1 ≤ n ≤ 100,000
 * - 각 원소: 1 ≤ a_i ≤ 1,000,000
 * - 목표 합 x: 1 ≤ x ≤ 2,000,000
 *
 * @link https://takjoon.takijk.xyz/problems/24597
 */
public class 두_수의_합 {
    public int solution(int[] nums, int x) {
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == x) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        두_수의_합 test = new 두_수의_합();
        int[] nums = {5, 12, 7, 10, 9, 1, 2, 3, 11};
        System.out.println(test.solution(nums, 13)); // 기대값: 3
    }
}
