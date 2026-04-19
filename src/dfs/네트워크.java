package dfs;

import java.util.*;

/**
 * 네트워크
 *
 * 컴퓨터의 개수 n과 연결 정보 computers가 주어질 때, 네트워크의 개수를 구한다.
 * 컴퓨터 A와 B가 연결되어 있고 B와 C가 연결되어 있으면 A와 C도 같은 네트워크에 속한다.
 *
 * 제약조건:
 * - 컴퓨터의 개수 n: 1 이상 200 이하의 자연수
 * - 컴퓨터 번호는 0부터 n-1까지
 * - i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j] = 1
 * - computers[i][i]는 항상 1
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class 네트워크 {
    public int solution(int n, int[][] computers) {
        // 한 번 시작점에서 탐색을 시작하면, 도달할 수 있는 모든 노드는 같은 네트워크
        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < computers.length; i++) {
            if(visited[i]) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 0; j < n; j++) {
                    if(computers[cur][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        네트워크 test = new 네트워크();

        int result1 = test.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(result1); // 기대값: 2

        int result2 = test.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println(result2); // 기대값: 1
    }
}
