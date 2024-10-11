package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2178
 * 방문할 수 있는 공간이 지정되어 있을 때 목적지 까지 최단 거리로 이동하는 방법
 */
public class 미로_탐색 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int width;
    static int height;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        bfs(0, 0);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int targetY = now[0] + dy[i];
                int targetX = now[1] + dx[i];
                if((targetX >= 0 && targetX < width) && (targetY >= 0 && targetY < height)) {
                    if(!visited[targetY][targetX] && map[targetY][targetX] == 1) {
                        visited[targetY][targetX] = true;
                        map[targetY][targetX] = map[now[0]][now[1]] + 1;
                        queue.add(new int[] {targetY, targetX});
                    }
                }
            }

        }
    }
}
