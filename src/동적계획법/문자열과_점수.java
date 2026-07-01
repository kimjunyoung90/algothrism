package 동적계획법;

/**
 * 문자열과_점수 (백준 2216)
 *
 * 두 문자열 X, Y의 임의의 위치에 공백을 삽입해 길이를 같게 만든 뒤,
 * 같은 위치의 두 문자를 비교해 점수를 매긴다.
 * - 두 문자가 같으면 A점 (단, 둘 다 공백인 경우는 허용되지 않음)
 * - 둘 중 적어도 하나가 공백이면 B점
 * - 둘 다 공백이 아니고 서로 다르면 C점
 * 공백을 적절히 추가했을 때 얻을 수 있는 최대 총점을 구한다.
 *
 * 제약조건:
 * - 0 < A ≤ 10,000
 * - -10,000 ≤ B, C < 0
 * - 각 문자열의 길이는 3,000자를 넘지 않으며, 빈 문자열은 입력으로 주어지지 않는다.
 *
 * @link https://takjoon.takijk.xyz/problems/13185
 */
public class 문자열과_점수 {
    public int solve(int a, int b, int c, String x, String y) {
        // TODO : 최대 점수
        // 두 문자가 같다. = A
        // 둘 중 하나가 공백이다. = B
        // 서로 다르다. = C
        // a b c
        //   d c

        //선택지
        //1. 공백을 선택한다.
        //2. 같은 위치에 있는 문자를 선택한다.
        //  - 같다. = A
        //  - 다르다. = C
        // 마지막 한 칸의 선택지
        //
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        //초기화
        for (int j = 1; j <= y.length(); j++) dp[0][j] = b;
        for (int i = 1; i <= x.length(); i++) dp[i][0] = b;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int point = 0;
                if(x.charAt(i - 1) == y.charAt(j - 1)) {
                    point = a;
                } else {
                    point = c;
                }
                dp[i][j] = Math.max(dp[i - 1][j - 1] + point, Math.max(dp[i - 1][j], dp[i][j - 1]) + b);
            }
        }
        return dp[x.length()][y.length()];
    }

    public static void main(String[] args) {
        문자열과_점수 test = new 문자열과_점수();
        System.out.println(test.solve(10, -1, -5, "abc", "dc")); // 기대값: 7
    }
}
