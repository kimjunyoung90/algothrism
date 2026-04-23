package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 섬의_개수 (Number of Islands)
 *
 * '1'(육지)과 '0'(물)로 이루어진 m x n 2D 그리드가 주어질 때, 섬의 개수를 반환한다.
 * 섬은 물로 둘러싸여 있고, 인접한(수평/수직) 육지들이 연결되어 형성된다.
 * 그리드의 네 변은 모두 물로 둘러싸여 있다고 가정한다.
 *
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
        int[] x = {0, 0, -1, 1};
        int[] y = {1, -1, 0, 0};
        //전체 지점을 한 번씩 탐색 시도한다.
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == '0') continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{col, row});
                grid[row][col] = '0';
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextx = cur[0] + x[k];
                        int nexty = cur[1] + y[k];
                        if(nextx >= 0 && nexty >= 0 && nextx < grid[0].length && nexty < grid.length) {
                            if(grid[nexty][nextx] == '1') {
                                grid[nexty][nextx] = '0';
                                q.add(new int[]{nextx, nexty});
                            }
                        }
                    }
                }
                count++;
            }
        }
        return count;
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
