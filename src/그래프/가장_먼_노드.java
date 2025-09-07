package 그래프;

import java.util.*;

public class 가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        //양방향 연결
        for (int[] near : edge) {
            adjList.get(near[0]).add(near[1]);
            adjList.get(near[1]).add(near[0]);
        }

        //탐색
        int[] dist = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adjList.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                }
            }
        }

        int max = Arrays.stream(dist).max().getAsInt();
        return (int) Arrays.stream(dist).filter(i -> i == max).count();
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(new 가장_먼_노드().solution(n, edge));
    }
}
