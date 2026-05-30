package 동적계획법;

/**
 * 가장_긴_공통_부분_수열 (Longest Common Subsequence)
 *
 * 두 문자열 text1, text2가 주어졌을 때, 두 문자열의 가장 긴 공통 부분 수열의 길이를 반환한다.
 * 부분 수열은 원래 문자열에서 일부 문자를 (없을 수도 있음) 삭제하되,
 * 남은 문자들의 상대적인 순서는 유지하여 만들어지는 새로운 문자열이다.
 * 공통 부분 수열은 두 문자열 모두에 공통으로 존재하는 부분 수열이다.
 *
 * 제약조건:
 * - 1 <= text1.length, text2.length <= 1000
 * - text1, text2는 소문자 영어 알파벳으로만 이루어진다.
 *
 * @link https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class 가장_긴_공통_부분_수열 {
    public int longestCommonSubsequence(String text1, String text2) {
        //text1에서 i 선택, text2에서 j 선택 시 구할 수 있는 공통된 최대 부분 수열을 구하라.
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //각각의 앞글자.
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                // TODO(human): 점화식을 적용해 dp[i][j]를 채우세요.
                if(c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        가장_긴_공통_부분_수열 test = new 가장_긴_공통_부분_수열();

        System.out.println(test.longestCommonSubsequence("abcde", "ace")); // 기대값: 3
        System.out.println(test.longestCommonSubsequence("abc", "abc"));   // 기대값: 3
        System.out.println(test.longestCommonSubsequence("abc", "def"));   // 기대값: 0
    }
}
