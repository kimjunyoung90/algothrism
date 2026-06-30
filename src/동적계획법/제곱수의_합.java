package 동적계획법;

import java.util.Arrays;

/**
 * 제곱수의_합 (백준 1699)
 *
 * 자연수 N을 제곱수들의 합으로 표현할 때, 그 제곱수 항의 최소 개수를 구한다.
 *
 * 제약조건:
 * - 1 ≤ N ≤ 100,000
 *
 * @link https://takjoon.takijk.xyz/problems/7560
 */
public class 제곱수의_합 {
    public int solve(int n) {
        // TODO : N을 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하라
        // N = 7
        // 6을 만들기 위한 항의 최소개수
        // 5를 만들기 위한 항의 최소개수
        // 4를 만들기 위한 항의 최소개수
        // 3을 만들기 위한 항의 최소개수
        // ....

        // 제곱수가 나왔어. 그럼 그 제곱수를 n에서 빼는 경우 그 수를 나타낼 수 있는 제곱수들의 합
        int[] minSquareSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minSquareSum[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            //7이라는 값을 항의 제곱수의 합으로 표현하기 위해서
            //1^2 + 6을 만들 때 필요한 최소 항 수
            for (int j = i * i; j <= n; j++) {
                //i를 만들기 위해 필요한 제곱수의 최소 항
                //예 2 = 현재
                minSquareSum[j] = Math.min(minSquareSum[j], minSquareSum[j - i * i] + 1);
            }
        }

        return minSquareSum[n];
    }

    public static void main(String[] args) {
        제곱수의_합 test = new 제곱수의_합();
        System.out.println(test.solve(7));  // 기대값: 4
        System.out.println(test.solve(1));  // 기대값: 1
        System.out.println(test.solve(4));  // 기대값: 1
        System.out.println(test.solve(11)); // 기대값: 3
        System.out.println(test.solve(13)); // 기대값: 2
    }
}
