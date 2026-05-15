package 동적계획법;

import java.util.Arrays;

/**
 * 백트래킹 vs DP 시간 비교 벤치마크
 */
public class 최소_동전_개수_벤치마크 {

	// ===== 백트래킹 버전 (기존 풀이) =====
	private int min;

	public int coinChangeBacktracking(int[] coins, int amount) {
		min = Integer.MAX_VALUE;
		getUsedCount(0, amount, 0, 0, coins);
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public void getUsedCount(int start, int amount, int sum, int depth, int[] coins) {
		if (depth > min) return;
		if (amount == sum) {
			min = Math.min(depth, min);
			return;
		}
		if (sum > amount) return;
		for (int i = start; i < coins.length; i++) {
			int coin = coins[i];
			getUsedCount(i, amount, sum + coin, depth + 1, coins);
		}
	}

	// ===== DP 버전 =====
	public int coinChangeDP(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

	// ===== 벤치마크 =====
	public static void main(String[] args) {
		최소_동전_개수_벤치마크 test = new 최소_동전_개수_벤치마크();

		int[][] testCases = {
				{1, 2, 5},
				{1, 2, 5, 10, 25},
				{1, 2, 5, 10, 25, 50},
				{1, 2, 5, 10, 25, 50, 100},
				{186, 419, 83, 408},  // LeetCode 악명 높은 테스트 케이스
				{1, 2, 5},
		};
		int[] amounts = {500, 1000, 2000, 5000, 6249, 10000};

		System.out.printf("%-12s %-8s %-20s %-20s%n", "coins", "amount", "백트래킹(ms)", "DP(ms)");
		System.out.println("--------------------------------------------------------------------");

		for (int t = 0; t < testCases.length; t++) {
			int[] coins = testCases[t];
			int amount = amounts[t];

			long bt;
			int btResult;
			long start = System.nanoTime();
			try {
				btResult = test.coinChangeBacktracking(coins, amount);
				bt = (System.nanoTime() - start) / 1_000_000;
			} catch (StackOverflowError e) {
				btResult = -999;
				bt = -1;
			}

			start = System.nanoTime();
			int dpResult = test.coinChangeDP(coins, amount);
			long dp = (System.nanoTime() - start) / 1_000_000;

			System.out.printf("%-12s %-8d %-20s %-20s (정답: BT=%d, DP=%d)%n",
					Arrays.toString(coins), amount,
					bt < 0 ? "StackOverflow" : bt + "ms",
					dp + "ms",
					btResult, dpResult);
		}
	}
}
