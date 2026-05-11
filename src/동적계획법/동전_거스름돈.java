package 동적계획법;

/**
 * 동전_거스름돈 (The Coin Change Problem)
 * <p>
 * 주어진 동전 종류로 금액 n을 만들 수 있는 서로 다른 방법의 개수를 구한다.
 * (각 동전은 무한히 사용 가능)
 * <p>
 * 제약조건:
 * - 동전 종류는 서로 다르다.
 * - 결과값이 32비트 정수 범위를 초과할 수 있어 long을 반환한다.
 *
 * @link https://www.hackerrank.com/challenges/coin-change/problem
 */
public class 동전_거스름돈 {
	public static long getWays(int n, int[] c) {
		// TODO(human): 구현하세요.
		//n이 4인 경우 동전을 만들 수 있는 경우의 수
		//첫 번째 동전을 몇개 쓸까?
		//0 = 나머지 동전으로 만들기
		//1 = n - 1 -> 나머지 동전으로 만들기
		//2 = n - 2 -> 나머지 동전으로 만들기
		//3 = n - 3 -> 나머지 동전으로 만들기
		//4 = n - 4 -> 나머지 동전으로 만들기

		//남은 금액, 시작 동전 인덱스

		return dp(n, 0, c);
	}

	private static long dp (int remaining, int idx, int[] coins) {
		if(remaining == 0) return 1;
		if(remaining < 0) return 0;
		if(idx >= coins.length) return 0;

		int coin = coins[idx];
		long sum = 0L;
		for (int i = 0; i * coin <= remaining ; i++) {
			sum += dp(remaining - i * coin, i + 1, coins);
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] c1 = {1, 2, 3};
		System.out.println(getWays(4, c1)); // 기대값: 4

		int[] c2 = {2, 5, 3, 6};
		System.out.println(getWays(10, c2)); // 기대값: 5
	}
}
