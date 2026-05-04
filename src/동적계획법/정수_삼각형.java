package 동적계획법;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 정수 삼각형
 * <p>
 * 삼각형의 꼭대기에서 바닥까지 대각선 왼쪽/오른쪽으로 한 칸씩만 이동할 때,
 * 거쳐간 숫자들의 합 중 최댓값을 구한다.
 * <p>
 * 제약조건:
 * - 삼각형의 높이: 1 이상 500 이하
 * - 숫자: 0 이상 9,999 이하의 정수
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class 정수_삼각형 {
	public int solution(int[][] triangle) {
		// TODO(human): 구현하세요.
		for (int r = 1; r < triangle.length; r++) {
			for (int c = 0; c <= r ; c++) {
				int left = c > 0 ? triangle[r - 1][c -1] : 0;
				int right = c < r ? triangle[r - 1][c] : 0;
				triangle[r][c] += Math.max(left, right);
			}
		}
		int max = 0;
		for (int v : triangle[triangle.length - 1]) {
			max = Math.max(max, v);
		}
		return max;
	}

	private void sum(int r, int c, int[][] dp, int[][] origin) {
		if (r == origin.length - 1) return;
		int current = dp[r][c];

		int next = r + 1;
		int left = c;
		int right = c + 1;

		dp[next][left] = Math.max(dp[next][left], origin[next][left] + current);
		dp[next][right] = Math.max(dp[next][right], origin[next][right] + current);

		//next 탐색
		sum(next, left, dp, origin);
		sum(next, right, dp, origin);
	}

	public static void main(String[] args) {
		정수_삼각형 test = new 정수_삼각형();
		int[][] triangle = {
				{7},
				{3, 8},
				{8, 1, 0},
				{2, 7, 4, 4},
				{4, 5, 2, 6, 5}
		};
		System.out.println(test.solution(triangle)); // 기대값: 30
	}
}
