import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 *
 * 주어진 문자열 s에서 중복 문자가 없는 가장 긴 부분 문자열의 길이를 구하는 문제
 *
 * 제약조건:
 * - 0 <= s.length <= 5 * 10^4
 * - s는 영문자, 숫자, 기호, 공백으로 구성
 *
 * @link https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(test.lengthOfLongestSubstring("abcabcbb")); // 기대값: 3
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));    // 기대값: 1
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));   // 기대값: 3
    }
}
