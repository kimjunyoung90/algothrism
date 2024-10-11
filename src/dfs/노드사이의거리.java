package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 노드사이의거리 {
    static ArrayList<Node>[] adjNodeLists;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfNodes = Integer.parseInt(st.nextToken());
        int searchNodesNum = Integer.parseInt(st.nextToken());

        adjNodeLists = new ArrayList[numberOfNodes + 1];
        visited = new boolean[numberOfNodes + 1];

        for (int i = 1; i < numberOfNodes + 1; i++) {
            adjNodeLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfNodes - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            adjNodeLists[node1].add(new Node(node2, distance));
            adjNodeLists[node2].add(new Node(node1, distance));
        }

        for (int i = 0; i < searchNodesNum; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            //거리계산
            dfs(startNode, destination, 0);
            visited = new boolean[numberOfNodes + 1];

        }
    }

    private static void dfs(int visitNode, int destination, int totalDistance) {

        visited[visitNode] = true;

        if(visitNode == destination) {
            System.out.println(totalDistance);
            return;
        }

        //인접 노드 방문
        for(Node adjNode : adjNodeLists[visitNode]) {
            int nodeNum = adjNode.adj;
            int distance = adjNode.distance;
            if(!visited[nodeNum]) {
                dfs(nodeNum, destination, totalDistance + distance);
            }
        }
    }
}

class Node {
    int adj;
    int distance;

    Node(int adj, int distance) {
        this.adj = adj;
        this.distance = distance;
    }
}
