package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class 게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 시작점(0, 0)
        visited[0][0] = true;
        distance[0][0] = 1; // 시작점의 거리는 1

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
