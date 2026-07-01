package 동적계획법;

import java.util.Arrays;

/**
 * 문자열과_점수
 * <p>
 * 두 문자열 X, Y의 임의 위치에 공백을 넣어 길이를 같게 맞춘 뒤,
 * 같은 위치의 두 문자를 비교해 점수를 매긴다.
 * - 두 문자가 같으면 A점 (둘 다 공백은 불가)
 * - 적어도 하나가 공백이면 B점
 * - 둘 다 공백이 아니고 서로 다르면 C점
 * 얻을 수 있는 최대 총점을 구한다.
 * <p>
 * 제약조건:
 * - 0 < A ≤ 10,000
 * - -10,000 ≤ B, C < 0
 * - 각 문자열 길이 ≤ 3,000, 빈 문자열 없음
 *
 * @link https://takjoon.takijk.xyz/problems/13185
 */
public class 문자열과_점수 {
	public int solve(int A, int B, int C, String X, String Y) {
		// TODO : 최대 총점
		// 두 문자가 같으면 A
		// 하나가 공백이면 B
		// 서로 다르면 C
		// 둘 다 공백 불가

		int[][] dp = new int[X.length() + 1][Y.length() + 1];
		//초기화
		for (int i = 1; i < dp.length; i++) dp[i][0] = i * B;
		for (int j = 1; j < dp[0].length; j++) dp[0][j] = j * B;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1] + (X.charAt(i - 1) == Y.charAt(j - 1) ? A : C), Math.max(dp[i - 1][j], dp[i][j - 1]) + B);
			}
		}

		return dp[X.length()][Y.length()];
	}

	public static void main(String[] args) {
		문자열과_점수 test = new 문자열과_점수();

		int a = 10, b = -1, c = -5;
		String x = "abc";
		String y = "dc";
		System.out.println(test.solve(a, b, c, x, y)); // 기대값: 7
	}
}
