package 이진탐색;

import java.util.Arrays;

/**
 * 두_배열의_합 (백준 2143)
 *
 * 두 배열 A, B가 주어졌을 때, A의 부 배열 합 + B의 부 배열 합 = T가 되는
 * 부 배열 쌍의 개수를 구한다.
 *
 * 제약조건:
 * - -1,000,000,000 ≤ T ≤ 1,000,000,000
 * - 1 ≤ n, m ≤ 1,000
 * - 각 원소의 절댓값은 1,000,000 이하
 *
 * @link https://takjoon.takijk.xyz/problems/12399
 */
public class 두_배열의_합 {
    public long solve(int T, int[] A, int[] B) {
        int[] prefixSumA = A.clone();
        Arrays.parallelPrefix(prefixSumA, Integer::sum);
        int[] prefixSumB = B.clone();
        Arrays.parallelPrefix(prefixSumB, Integer::sum);

        return 0;
    }

    public static void main(String[] args) {
        int T = 5;
        int[] A = {1, 3, 1, 2};
        int[] B = {1, 3, 2};

        System.out.println(new 두_배열의_합().solve(T, A, B)); // 기대값: 7
    }
}
