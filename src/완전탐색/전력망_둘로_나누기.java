package 완전탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=java
 */
public class 전력망_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        //인접 송전탑 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //양방향 연결
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        //전력망 연결 정보를 기준으로 하나씩 연결을 끊었을 때 어느 정도 차이가 나는지 전체 탐색
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            //송전탑 연결 끊기
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));

            //연결이 끊긴 한쪽 전력망의 송전탑 개수 계산
            int count = bfs(graph, a, n);

            //차이 계산
            //2개의 전력망을 a와 b라고 할 때 현재 한쪽의 전력망에 속한 송전탑의 크기를 구한것임
            //a의 송전탑 - b의 송전탑 = count - (n - count) = count -n + count = count * 2 - n
            //위 값을 Mat h클래스의 abs를 사용하여 절대값으로 변환
            int diff = Math.abs(count * 2 - n);

            //최소 차이 갱신
            answer = Math.min(answer, diff);

            //송전탑 연결 원복
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return answer;
    }

    //주변에 연결된 송전탑을 하나씩 탐색
    public int bfs(List<List<Integer>> graph, int start, int n) {
        //송전탑 번호는 1 ~ n. 따라서 노드 방문 여부를 저장하는 visited 를 n + 1로 생성
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int result = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        전력망_둘로_나누기 test = new 전력망_둘로_나누기();
        int n = 9;
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };
        int result = test.solution(n, wires);
        System.out.println(result);
    }
}
