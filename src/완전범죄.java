public class 완전범죄 {
    public static int answer = Integer.MAX_VALUE;
    public int solution(int[][] info, int n, int m) {
        search(info, 0, 0, 0, n, m);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public void search(int[][] info, int a, int b, int depth, int n, int m) {
        if(depth == info.length) {
            if(a < n && b < m) {
                answer = Math.min(answer, a);
            }
            return;
        }
        search(info, a + info[depth][0], b, depth + 1, n, m);
        search(info, a, b + info[depth][1], depth + 1, n, m);
    }

    public static void main(String[] args) {
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 4, m =  4;
        System.out.println(new 완전범죄().solution(info, n, m));
    }
}
