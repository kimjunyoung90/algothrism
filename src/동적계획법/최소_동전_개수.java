package 동적계획법;

import java.util.Arrays;

/**
 * 최소_동전_개수 (Coin Change)
 * <p>
 * 서로 다른 액면가의 동전 배열 coins와 목표 금액 amount가 주어진다.
 * 목표 금액을 만들기 위해 필요한 동전의 최소 개수를 반환한다.
 * 만들 수 없는 경우 -1을 반환한다.
 * 각 동전은 무한히 사용 가능하다.
 * <p>
 * 제약조건:
 * - 1 <= coins.length <= 12
 * - 1 <= coins[i] <= 2^31 - 1
 * - 0 <= amount <= 10^4
 *
 * @link https://leetcode.com/problems/coin-change/
 */
public class 최소_동전_개수 {

	public int coinChange(int[] coins, int amount) {
		// dp[i] = i원을 만드는 최소 동전 개수
		// 도달 불가능을 표시할 값으로 amount + 1 사용 (절대 나올 수 없는 큰 값 = 최소 1원 기준)
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;  // 0원은 동전 0개로 만들 수 있음

		// 1원부터 amount 원까지 차례대로 필요한 최소 동전 개수를 채워나간다.
		for (int i = 1; i <= amount; i++) {
			int totalCount = getCount(i, 0, 0, coins, 0);
			dp[i] = Math.min(dp[i], totalCount);
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

	//동전을 사용할때마다 사용한 동전의 수를 count = depth
	public int getCount(int amount, int depth, int sum, int[] coins, int start) {
		if(amount == sum) return depth;
		if(amount < sum) return amount + 1;
		int totalCount = 0;
		for (int i = start; i < coins.length; i++) {
			totalCount = getCount(amount, depth + 1, sum + coins[i], coins, i);
		}
		return totalCount;
	}

	public static void main(String[] args) {
		최소_동전_개수 test = new 최소_동전_개수();

		// Example 1: coins = [1,2,5], amount = 11 -> 3 (5+5+1)
		int result1 = test.coinChange(new int[]{1, 2, 5}, 11);
		System.out.println(result1); // 기대값: 3

		// Example 2: coins = [2], amount = 3 -> -1
		int result2 = test.coinChange(new int[]{2}, 3);
		System.out.println(result2); // 기대값: -1

		// Example 3: coins = [1], amount = 0 -> 0
		int result3 = test.coinChange(new int[]{1}, 0);
		System.out.println(result3); // 기대값: 0
	}
}
