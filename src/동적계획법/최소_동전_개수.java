package 동적계획법;

import java.util.*;

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
    private int min;
    public int coinChange(int[] coins, int amount) {
        // TODO(human): 구현하세요.
        //목표 금액을 만들기 위해 필요한 동전의 최소 개수
        //목표 금액이 되기까지 동전을 하나씩 사용하면서 목표금액을 만족했을 때 사용된 동전의 갯수를 반환하고 최소 값을 확인하면 되겠네.
        //떠오르는데로 해보자.
        //정렬 default는 오름차순
        min = Integer.MAX_VALUE;
        getUsedCount(0, amount, 0, 0, coins);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void getUsedCount(int start, int amount, int sum, int depth, int[] coins) {
        if(depth > min) return;
        if(amount == sum) {
            min = Math.min(depth, min);
            return;
        }
        if(sum > amount) return;
		for (int i = start; i < coins.length; i++) {
            int coin = coins[i];
			getUsedCount(i, amount, sum + coin, depth + 1, coins);
		}
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
