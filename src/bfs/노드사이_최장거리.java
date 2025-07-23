package bfs;

import java.util.*;

/**
 * 5
 * 1 3 2 -1
 * 2 4 4 -1
 * 3 1 2 4 3 -1
 * 4 2 4 3 3 5 6 -1
 * 5 4 6 -1
 */
public class 노드사이_최장거리 {
    static int N; //노드 개수
    static boolean[] visited; //노드 방문 여부
    static List<Node>[] adjList; //인접 노드
    static int[] distance; //노드 사이의 거리

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adjList = new ArrayList[N + 1];
        //인접 노드 초기화
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt(); //기준 노드

            while (true) {
                int node = sc.nextInt();
                if(node == -1) {
                    break;
                }
                int value = sc.nextInt();
                adjList[a].add(new Node(node, value));
            }
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(1);
        int max = 1;
        for (int i = 2; i <= N; i++) {
            if(distance[max] > distance[i]) {
                max = i;
            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(max);
        Arrays.sort(distance);
        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i]);
        }
//        System.out.println(distance[N]);
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < adjList[node].size(); i++) {
               Node adjNode = adjList[node].get(i);
               if(!visited[adjNode.edge]) {
                   visited[adjNode.edge] = true;
                   queue.add(adjNode.edge);
                   distance[adjNode.edge] = distance[node] + adjNode.value;
               }
            }
        }
    }
}

class Node {
    int edge;
    int value;
    Node(int edge, int value) {
        this.edge = edge;
        this.value = value;
    }
}
