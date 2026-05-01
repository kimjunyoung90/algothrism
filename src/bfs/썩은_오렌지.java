package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 썩은_오렌지 (Rotting Oranges)
 * <p>
 * m x n 그리드의 각 셀은 다음 세 값 중 하나이다:
 * - 0: 빈 칸
 * - 1: 신선한 오렌지
 * - 2: 썩은 오렌지
 * 매 분마다 썩은 오렌지에 4방향(상하좌우)으로 인접한 신선한 오렌지가 썩는다.
 * 모든 신선한 오렌지가 썩는 데 걸리는 최소 시간을 반환한다.
 * 불가능하면 -1을 반환한다.
 * <p>
 * 제약조건:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 10
 * - grid[i][j]는 0, 1, 2 중 하나이다.
 *
 * @link https://leetcode.com/problems/rotting-oranges/
 */
public class 썩은_오렌지 {
	public int orangesRotting(int[][] grid) {

		int fresh = 0;
		Queue<int[]> sucked = new LinkedList<>();

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 1) {
					fresh++;
				}
				if (grid[r][c] == 2) {
					sucked.offer(new int[]{r, c});
				}
			}
		}

		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		int time = 0;
		int freshed = 0;
		while (!sucked.isEmpty()) {
			int size = sucked.size();
			boolean next = false;
			for (int i = 0; i < size; i++) {
				int[] cur = sucked.poll();
				int cr = cur[0];
				int cc = cur[1];

				for (int j = 0; j < 4; j++) {
					int nr = cr + dr[j];
					int nc = cc + dc[j];

					if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) continue;

					if (grid[nr][nc] == 1) {
						sucked.offer(new int[]{nr, nc});
						grid[nr][nc] = 2;
						freshed++;
						next = true;
					}
				}
			}
			if (next) time++;
		}

		return fresh == freshed ? time : -1;
	}

	public static void main(String[] args) {
		썩은_오렌지 test = new 썩은_오렌지();

		int[][] grid1 = {
				{2, 1, 1},
				{1, 1, 0},
				{0, 1, 1}
		};
		System.out.println(test.orangesRotting(grid1)); // 기대값: 4

		int[][] grid2 = {
				{2, 1, 1},
				{0, 1, 1},
				{1, 0, 1}
		};
		System.out.println(test.orangesRotting(grid2)); // 기대값: -1

		int[][] grid3 = {
				{0, 2}
		};
		System.out.println(test.orangesRotting(grid3)); // 기대값: 0
	}
}
