import java.util.Arrays;

/**
 * 나눌_수_있는_부분_수열
 * <p>
 * 양의 정수 수열에서, 연속하는 부분 수열의 합이 d로 나누어 떨어지는 것의 개수를 구한다.
 * <p>
 * 제약조건:
 * - 1 ≤ d ≤ 1,000,000
 * - 1 ≤ n ≤ 50,000
 * - 1 ≤ 각 원소 ≤ 1,000,000,000
 *
 * @link https://takjoon.takijk.xyz/problems/27738
 */
public class 나눌_수_있는_부분_수열 {
	public long solve(int d, int[] arr) {
		//핵심 = 두 수를 d로 나눈 나머지가 같다. = 두 수의 차는 d의 배수다.
		long[] sum = new long[arr.length];
		sum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum[i] = arr[i] + sum[i - 1];
		}

		int[] divide = new int[d];
		//출발점이 있어야한다....
		divide[0]++;
		for (long j : sum) {
			divide[(int) (j % d)]++;
		}

		//나머지가 같은 수 구하기
		return Arrays.stream(divide).filter(i -> i > 1).reduce(0, (acc, i) -> i * (i - 1) / 2 + acc);
	}

	public static void main(String[] args) {
		나눌_수_있는_부분_수열 test = new 나눌_수_있는_부분_수열();

		// 예제 1: 기대값 0
		System.out.println(test.solve(7, new int[]{1, 2, 3}));
		// 예제 2: 기대값 6
		System.out.println(test.solve(4, new int[]{2, 1, 2, 1, 1, 2, 1, 2}));
	}
}
