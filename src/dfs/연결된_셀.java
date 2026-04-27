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
	public int connectedCell(int[][] matrix) {
		// TODO(human): 구현하세요.
		// 값이 1인 것만 채워진 cell이다.
		// 수평, 수직, 대각선인 경우에만 연결되어 있다.
		// 가장 큰 면적을 구하라.
		// 하나의 cell을 지정하고 연결이 끊길 때까지 면적을 구해본다.
		// 대각선은 어떻게 할건가?
		int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
		int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

		//면적 구하기
		int maxArea = 0;
		for (int c = 0; c < matrix[0].length; c++) {
			for (int r = 0; r < matrix.length; r++) {
				Queue<int[]> q = new LinkedList<>();
				if (matrix[r][c] == 1) {
					matrix[r][c] = 0;
					q.offer(new int[]{r, c});
				}
				int maxtemp = 0;
				while (!q.isEmpty()) {
					//갈 수 있는 경로만 방문
					int[] curr = q.poll();
					//maxArea 추가
					maxtemp += 1;
					//인접 섬 방문
					for (int i = 0; i < 8; i++) {
						int nextY = curr[0] + dy[i];
						int nextX = curr[1] + dx[i];
						//방문 최적화
						if (nextX >= 0 && nextY >= 0 && nextX < matrix[0].length && nextY < matrix.length && matrix[nextY][nextX] == 1) {
							//방문 표시
							matrix[nextY][nextX] = 0;
							q.offer(new int[]{nextY, nextX});
						}
					}

				}
				maxArea = Math.max(maxtemp, maxArea);
			}
		}
		return maxArea;
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
