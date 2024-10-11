package dfs;

import java.util.ArrayList;

public class Basic {
    public static ArrayList<Integer>[] adjNodeList;
    public static Boolean[] visited;

    public static void main(String[] args) {
        int n = 6;

        //초기화
        adjNodeList = new ArrayList[n];
        visited = new Boolean[n];
        for (int i = 0; i < n; i++) {
            adjNodeList[i] = new ArrayList<>();
            visited[i] = false;
        }

        adjNodeList[0].add(1);
        adjNodeList[0].add(2);
        adjNodeList[1].add(0);
        adjNodeList[1].add(3);
        adjNodeList[1].add(4);
        adjNodeList[2].add(0);
        adjNodeList[2].add(1);
        adjNodeList[2].add(4);
        adjNodeList[3].add(1);
        adjNodeList[3].add(5);
        adjNodeList[4].add(2);
        adjNodeList[5].add(3);

        int rootNode = 0;
        dfs(rootNode);
    }

    private static void dfs(int rootNode) {
        visited[rootNode] = true;
        System.out.print(rootNode + "->");
        for(int adjNode : adjNodeList[rootNode]) {
            if(!visited[adjNode]) {
                dfs(adjNode);
            }
        }
    }

}
