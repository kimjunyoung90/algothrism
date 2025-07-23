package bfs;

import java.util.*;

public class 기본 {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int n; //노드 개수
    static int m; //edge 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int startNode = sc.nextInt();
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        BFS(startNode);
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            List<Integer> adj = adjList[node];
            for (Integer adjNode : adj) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    System.out.println(adjNode);
                    queue.add(adjNode);
                }
            }
        }
    }
}
