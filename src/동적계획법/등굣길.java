package 동적계획법;

import java.util.*;

/**
 * 등굣길
 * <p>
 * 집(1,1)에서 학교(m,n)까지 오른쪽/아래쪽으로만 이동하여 도달할 수 있는 경로의 개수를 구한다.
 * 물에 잠긴 지역(puddles)은 지나갈 수 없으며, 결과는 1,000,000,007로 나눈 나머지를 반환한다.
 * <p>
 * 제약조건:
 * - 격자 크기 m, n: 1 이상 100 이하 자연수
 * - m과 n이 모두 1인 경우는 입력으로 주어지지 않음
 * - 물에 잠긴 지역의 개수: 0개 이상 10개 이하
 * - 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않음
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class 등굣길 {
	private static final int MOD = 1_000_000_007;

	public int solution(int m, int n, int[][] puddles) {
		// TODO(human): 구현하세요.

		int[][] map = new int[n + 1][m + 1];

		for (int[] p : puddles) {
			int r = p[1];
			int c = p[0];
			map[r][c] = -1;
		}

		map[0][1] = 1;
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= m; c++) {
				if(map[r][c] == -1) {
					map[r][c] = 0;
					continue;
				}

				map[r][c] = (map[r][c - 1] + map[r - 1][c]) % MOD;
			}
		}

		return map[n][m];
	}

	public static void main(String[] args) {
		등굣길 test = new 등굣길();
		int[][] puddles = {{2, 2}};
		System.out.println(test.solution(4, 3, puddles)); // 기대값: 4
	}
}
