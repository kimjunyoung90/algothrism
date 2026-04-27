package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 연결된_셀 (Connected Cells in a Grid)
 * <p>
 * 0과 1로 이루어진 n x m 행렬이 주어진다. 값이 1인 셀은 "채워진" 셀이고,
 * 두 셀이 수평/수직/대각선으로 인접하면 연결된 것으로 본다.
 * 연결된 채워진 셀들의 그룹을 region이라 할 때, 가장 큰 region의 크기(셀 개수)를 반환한다.
 * <p>
 * 제약조건:
 * - 0 < n, m < 10
 * - matrix[i][j] ∈ {0, 1}
 *
 * @link https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
 */
public class 연결된_셀 {
	int count;

	public int connectedCell(int[][] matrix) {
		// TODO(human): 구현하세요.
		// 값이 1인 것만 채워진 cell이다.
		// 수평, 수직, 대각선인 경우에만 연결되어 있다.
		// 가장 큰 면적을 구하라.
		// 하나의 cell을 지정하고 갈 수 있는 곳으로 가본다.
		// 그리고, 연결이 끊길 때까지 면적을 구해본다.
		// 연결이 끊기면 제자리로 돌아와서 갈 수 있는데로 다시 끝까지 가본다.

		//면적 구하기
		int maxArea = 0;
		for (int c = 0; c < matrix[0].length; c++) {
			for (int r = 0; r < matrix.length; r++) {
				if (matrix[r][c] == 1) {
					count = 0;
					dfs(matrix, r, c);
					maxArea = Math.max(count, maxArea);
				}
			}
		}
		return maxArea;
	}

	private void dfs(int[][] matrix, int r, int c) {
		if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length) return;
		if (matrix[r][c] == 0) return;

		//방문 표기
		matrix[r][c] = 0;

		//면적 증가
		count++;

		// 3. 8방향 이웃에게도 같은 일 시키기
		int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
		int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
		for (int i = 0; i < 8; i++) {
			dfs(matrix, r + dy[i], c + dx[i]);
		}
	}

	public static void main(String[] args) {
		연결된_셀 test = new 연결된_셀();

		int[][] matrix1 = {
				{1, 1, 0, 0},
				{0, 1, 1, 0},
				{0, 0, 1, 0},
				{1, 0, 0, 0}
		};
		System.out.println(test.connectedCell(matrix1)); // 기대값: 5

		int[][] matrix2 = {
				{0, 0, 1, 1},
				{0, 0, 1, 0},
				{0, 1, 1, 0},
				{0, 1, 0, 0},
				{1, 1, 0, 0}
		};
		System.out.println(test.connectedCell(matrix2)); // 기대값: 8
	}
}
