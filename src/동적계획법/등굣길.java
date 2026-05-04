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
	public int solution(int m, int n, int[][] puddles) {
		// TODO(human): 구현하세요.
		//우측/아래를 반복하면서 좌표를 돌면서 해당 좌표에 도달하면 이전 좌표에 도달할 수 있는 경우의 수를 해당 좌표에 더한다.
		int[][] map = new int[m][n];

		for (int[] p : puddles) {
			int r = p[0];
			int c = p[1];
			map[r - 1][c - 1] = -1;
		}
		//위, 좌 값 가져오기
		//시작점
		map[0][0] = 1;
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if(map[r][c] == -1) continue;
				//좌측 좌표 값 가져오기
				int vpc = c - 1 < 0 ? 0 : map[r][c - 1];
				if(vpc != -1) map[r][c] += vpc;
				//위 좌표 값 가져오기
				int vpr = r - 1 < 0 ? 0 : map[r - 1][c];
				if(vpr != -1) map[r][c] += vpr;
			}
		}

		//우로 탐색
		//하로 탐색
		return 0;
	}

	public static void main(String[] args) {
		등굣길 test = new 등굣길();
		int[][] puddles = {{2, 2}};
		System.out.println(test.solution(4, 3, puddles)); // 기대값: 4
	}
}
