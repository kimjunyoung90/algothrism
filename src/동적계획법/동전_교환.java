package 동적계획법;

import java.util.Arrays;
import java.util.List;

/**
 * 동전_교환 (The Coin Change Problem)
 * <p>
 * 주어진 금액 n과 동전 종류 c[]가 있을 때,
 * 해당 금액을 만들 수 있는 서로 다른 방법의 수를 구하는 문제.
 * 각 동전은 무한히 사용할 수 있다.
 * <p>
 * 제약조건:
 * - 동전 종류는 모두 서로 다르다.
 * - 결과값은 32비트 정수 범위를 초과할 수 있다 (long 사용).
 *
 * @link https://www.hackerrank.com/challenges/coin-change/problem
 */
public class 동전_교환 {
	// memo[plus][start] = (현재까지 합이 plus이고 start번째 동전부터 사용 가능할 때) 가능한 방법 수
	// 미계산 상태는 -1로 표시
	private int[][] memo;

	public long getWays(int n, int[] c) {
		memo = new int[n][c.length];
		for (int[] row : memo) Arrays.fill(row, -1);
		return fn(0, 0, n, c);
	}

	private int fn(int startIdx, int accum, int target, int[] coins) {
		if(accum == target) return 1;
		if(accum > target) return 0;
		if(memo[accum][startIdx] != -1) return memo[accum][startIdx];
		int count = 0;
		for (int i = startIdx; i < coins.length; i++) {
			count += fn(i, accum + coins[i], target, coins);
		}
		memo[accum][startIdx] = count;
		return count;
	}

	public static void main(String[] args) {
		동전_교환 test = new 동전_교환();

		// Sample 0: n=4, coins=[1, 2, 3] -> 4
		long result0 = test.getWays(4, new int[]{1, 2, 3});
		System.out.println(result0); // 기대값: 4

		// Sample 1: n=10, coins=[2, 5, 3, 6] -> 5
//		long result1 = test.getWays(10, new int[]{2, 5, 3, 6});
//		System.out.println(result1); // 기대값: 5
	}
}
