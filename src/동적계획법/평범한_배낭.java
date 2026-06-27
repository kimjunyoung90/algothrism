package 동적계획법;

import java.util.Arrays;

/**
 * 평범한_배낭 (백준 12865)
 * <p>
 * N개의 물건이 무게 W와 가치 V를 가질 때, 최대 K 무게까지 담아
 * 가치합의 최댓값을 구하는 0/1 배낭 문제.
 * <p>
 * 제약조건:
 * - 1 ≤ N ≤ 100
 * - 1 ≤ K ≤ 100,000
 * - 1 ≤ W ≤ 100,000
 * - 0 ≤ V ≤ 1,000
 *
 * @link https://takjoon.takijk.xyz/problems/3089
 */
public class 평범한_배낭 {
	public int solution(int N, int K, int[][] items) {
		// values[w] = 무게 한도가 w일 때 담을 수 있는 최대 가치
		int[] values = new int[K + 1];
		for (int[] item : items) {
			int weight = item[0];
			int value = item[1];
			for (int i = K; weight <= i; i--) {
				values[i] = Math.max(values[i], value + values[i - weight]);
			}
		}
		return values[K];
	}

	public static void main(String[] args) {
		평범한_배낭 test = new 평범한_배낭();
		int N = 4;
		int K = 7;
		int[][] items = {
				{6, 13},
				{4, 8},
				{3, 6},
				{5, 12}
		};
		System.out.println(test.solution(N, K, items)); // 기대값: 14
	}
}
