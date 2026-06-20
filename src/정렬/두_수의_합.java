package 정렬;

import java.util.Arrays;

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
        //5, 12, 7, 10, 9, 1, 2, 3, 11
        //i < j 만족하면서 x인 쌍을 찾아라.
        //정렬을 하면 우측이 크거나 같은 수잖아.
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        //합계
        while (left < right) {
            int sum = nums[left] + nums[right];
            if(sum < x) {
                left++;
            } else if (x < sum) {
                right--;
            } else {
                //같으면??
                //다른 조합도 가능 한지
                //서로 다른 양의 정수임.
                answer++;
                left++;
                right--;
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
