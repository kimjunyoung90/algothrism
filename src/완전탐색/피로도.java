package 완전탐색;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class 피로도 {
    int answer = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        for (int i = 0; i < dungeons.length; i++) {
            int required = dungeons[i][0];
            int consume = dungeons[i][1];
            if(!visited[i] && k >= required) {
                visited[i] = true;
                dfs(k - consume, dungeons, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        피로도 test = new 피로도();
        int k = 80;
        int[][] dungeons = {
                { 80, 20 },
                { 50, 40 },
                { 30, 10 }
        };
        System.out.println(test.solution(k, dungeons));
    }
}
