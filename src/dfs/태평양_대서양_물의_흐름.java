package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 태평양_대서양_물의_흐름 (Pacific Atlantic Water Flow)
 *
 * m x n 정수 행렬 heights는 대륙의 각 셀의 높이를 나타낸다.
 * 태평양은 대륙의 왼쪽 및 위쪽 가장자리에 접해 있고,
 * 대서양은 오른쪽 및 아래쪽 가장자리에 접해 있다.
 * 물은 인접한 셀(상하좌우)로 현재 셀보다 높이가 같거나 낮은 곳으로 흐를 수 있다.
 * 빗물이 두 바다 모두로 흐를 수 있는 셀의 좌표 리스트를 반환하라.
 *
 * 제약조건:
 * - m == heights.length
 * - n == heights[r].length
 * - 1 <= m, n <= 200
 * - 0 <= heights[r][c] <= 10^5
 *
 * @link https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
public class 태평양_대서양_물의_흐름 {

    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // TODO(human): 구현하세요.

        int rows = heights.length;
        int columns = heights[0].length;

        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];

        //태평양부터 탐색
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
        }

        for (int c = 1; c < columns; c++) {
            dfs(heights, 0, c, pacific);
        }

        //대서양부터 탐색
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, columns - 1, atlantic);
        }

        for (int c = 0; c < columns - 1; c++) {
            dfs(heights, rows - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        //엣지케이스
        int maxRow = heights.length;
        int maxColumn = heights[0].length;

        if(r < 0 || c < 0 || r >= maxRow || c >= maxColumn) return;

        //방문 노드 제외
        if(visited[r][c]) return;

        //방문 표기
        visited[r][c] = true;

        //다음 탐색

		for (int i = 0; i < 4; i++) {
            int nr = r + DR[i];
            int nc = c + DC[i];
            if(nr < 0 || nc < 0 || nr >= maxRow || nc >= maxColumn) continue;
            if(heights[r][c] > heights[nr][nc]) continue;
            dfs(heights, nr, nc, visited);
        }
    }

    public static void main(String[] args) {
        태평양_대서양_물의_흐름 test = new 태평양_대서양_물의_흐름();

        int[][] heights1 = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(test.pacificAtlantic(heights1));
        // 기대값: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

        int[][] heights2 = {{1}};
        System.out.println(test.pacificAtlantic(heights2));
        // 기대값: [[0,0]]
    }
}
