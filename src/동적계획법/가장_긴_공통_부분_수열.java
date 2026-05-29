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
        // TODO(human): 구현하세요.
        return 0;
    }

    public static void main(String[] args) {
        가장_긴_공통_부분_수열 test = new 가장_긴_공통_부분_수열();

        System.out.println(test.longestCommonSubsequence("abcde", "ace")); // 기대값: 3
        System.out.println(test.longestCommonSubsequence("abc", "abc"));   // 기대값: 3
        System.out.println(test.longestCommonSubsequence("abc", "def"));   // 기대값: 0
    }
}
