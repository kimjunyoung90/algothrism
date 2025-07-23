package dfs;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class 네트워크 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int network = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                탐색(i, computers, visited);
                network++;
            }
        }

        return network;
    }

    private void 탐색(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        int[] adjcents = computers[current];

        for (int i = 0; i < adjcents.length; i++) {
            if(i == current) continue;
            if(adjcents[i] == 1 && !visited[i]) {
                탐색(i, computers, visited);
            }
        }
    }
}
