package 동적계획법;

import java.util.Arrays;

/**
 * 팰린드롬_만들기 (백준 1695)
 *
 * 주어진 수열에 최소 개수의 수를 끼워 넣어 팰린드롬으로 만들 때,
 * 끼워 넣어야 하는 수의 최소 개수를 구한다.
 *
 * 제약조건:
 * - 수열의 길이 N (1 ≤ N ≤ 5,000)
 * - 각 수는 int 범위
 *
 * @link https://takjoon.takijk.xyz/problems/7518
 */
public class 팰린드롬_만들기 {
    public int solve(int[] arr) {
        int[][] memo = new int[arr.length][arr.length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return countAdditional(arr, memo, 0 , arr.length - 1);
    }

    private int countAdditional(int[] arr, int[][] memo, int left, int right) {
        if(left >= right) {
            return 0;
        }

        if(memo[left][right] != -1) return memo[left][right];

        if(arr[left] == arr[right]) {
            return memo[left][right] = countAdditional(arr, memo, left + 1, right - 1);
        } else {
            return memo[left][right] = Math.min(countAdditional(arr, memo, left + 1, right), countAdditional(arr, memo, left, right - 1)) + 1;
        }
    }

    public static void main(String[] args) {
        팰린드롬_만들기 test = new 팰린드롬_만들기();
        System.out.println(test.solve(new int[]{1, 2, 3, 4, 2})); // 기대값: 2
    }
}
