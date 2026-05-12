package 동적계획법;

/**
 * 동전_교환 (The Coin Change Problem)
 *
 * 주어진 금액 n과 동전 종류 c[]가 있을 때,
 * 해당 금액을 만들 수 있는 서로 다른 방법의 수를 구하는 문제.
 * 각 동전은 무한히 사용할 수 있다.
 *
 * 제약조건:
 * - 동전 종류는 모두 서로 다르다.
 * - 결과값은 32비트 정수 범위를 초과할 수 있다 (long 사용).
 * - 0원을 만드는 방법은 1가지 (동전을 사용하지 않음).
 *
 * @link https://www.hackerrank.com/challenges/coin-change/problem
 */
public class 동전_교환 {
    public long getWays(int n, int[] c) {
        // TODO(human): 구현하세요.
        return 0L;
    }

    public static void main(String[] args) {
        동전_교환 test = new 동전_교환();

        // Sample 0: n=4, coins=[1, 2, 3] -> 4
        long result0 = test.getWays(4, new int[]{1, 2, 3});
        System.out.println(result0); // 기대값: 4

        // Sample 1: n=10, coins=[2, 5, 3, 6] -> 5
        long result1 = test.getWays(10, new int[]{2, 5, 3, 6});
        System.out.println(result1); // 기대값: 5
    }
}
