package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임_맵_최단거리
 *
 * 좌측 상단 (1,1)에서 우측 하단 (n,m)까지 도달하는 최단 경로의 칸 개수를 구한다.
 * 동서남북으로만 이동 가능하며, 0은 벽, 1은 통로이다. 도달 불가 시 -1을 반환한다.
 *
 * 제약조건:
 * - maps는 n×m 크기 (1 ≤ n, m ≤ 100)
 * - maps는 0과 1로만 구성
 * - (n, m) ≠ (1, 1)
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        // TODO(human): 구현하세요.
        // 좌측 상단부터, 우측 하단 까지 도달하는 최단 경로의 칸 개수
        // 동서남북으로 이동 가능 0은 벽 1은 통로
        // 도달 불가 시 -1
        int[] x = {0, 0, -1, 1};
        int[] y = {1, -1, 0, 0};

        //한 칸 방문시 상하좌우 이동
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            //상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nextx = curx + x[i];
                int nexty = cury + y[i];
                if(nextx >= 0 && nexty >= 0 && nextx < maps.length && nexty < maps[0].length) {
                    //값이 1인 칸만 방문해야함(0은 벽이고, 2이상은 이미 방문했음)
                    if(maps[nextx][nexty] == 1) {
                        //이전 거리에서 이동한 만큼 거리 증분
                        maps[nextx][nexty] = maps[curx][cury] + 1;
                        //다음에 탐색하도록 큐에 추가
                        q.add(new int[]{nextx, nexty});
                    }
                }
            }
        }
        int answer = maps[maps.length - 1][maps[0].length - 1];
        return answer == 1 ? -1 : answer;
    }

    public static void main(String[] args) {
        게임_맵_최단거리 test = new 게임_맵_최단거리();

        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(test.solution(maps1)); // 기대값: 11

        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println(test.solution(maps2)); // 기대값: -1
    }
}
