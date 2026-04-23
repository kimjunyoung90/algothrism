package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 섬의_개수 (Number of Islands)
 * <p>
 * '1'(육지)과 '0'(물)로 이루어진 m x n 2D 그리드가 주어질 때, 섬의 개수를 반환한다.
 * 섬은 물로 둘러싸여 있고, 인접한(수평/수직) 육지들이 연결되어 형성된다.
 * 그리드의 네 변은 모두 물로 둘러싸여 있다고 가정한다.
 * <p>
 * 제약조건:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 300
 * - grid[i][j]는 '0' 또는 '1'이다.
 *
 * @link https://leetcode.com/problems/number-of-islands/
 */
public class 섬의_개수 {
	public int numIslands(char[][] grid) {
		// TODO(human): 구현하세요.
		//전체 지점을 한 번씩 탐색 시도한다.
		int count = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == '1') {
					dfs(grid, r, c);
					count++;
				}
			}
		}
		return count;
	}

	public void dfs(char[][] grid, int r, int c) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') return;
		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
	}

	public static void main(String[] args) {
		섬의_개수 test = new 섬의_개수();

		char[][] grid1 = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};
		System.out.println(test.numIslands(grid1)); // 기대값: 1

		char[][] grid2 = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println(test.numIslands(grid2)); // 기대값: 3
	}
}
