import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * <p>
 * 문자열 s와 t가 주어질 때, t의 모든 문자(중복 포함)를 포함하는
 * s의 최소 윈도우 부분 문자열을 반환한다.
 * 해당하는 부분 문자열이 없으면 빈 문자열을 반환한다.
 * <p>
 * 제약조건:
 * - 1 <= s.length, t.length <= 10^5
 * - s와 t는 영문 대소문자로 구성
 * - 정답이 존재할 경우 유일함이 보장됨
 *
 * @link https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		// TODO(human): 구현하세요.
		//문자열 s와 t가 주어질 때, t의 모든 문자를 포함하는 s의 최소 부분 문자열을 반환한다.
		//조건을 만족하면 window size를 줄여보는 방식
		int left = 0;
		int right = 0;
		int minLength = Integer.MAX_VALUE;

		Map<Character, Integer> need = new HashMap<>();
		for (Character c : t.toCharArray()) {
			need.merge(c, 1, Integer::sum);
		}

		//right를 한 칸씩 넓히면서 계산한다.
		int start = 0;
		Map<Character, Integer> window = new HashMap<>();
		for (right = 0; right < s.length(); right++) {
			//window에 s.charAt(right) 추가
			window.merge(s.charAt(right), 1, Integer::sum);

			//필요한 모든 문자가 window에 포함되어있는지 확인
			while (check(need, window)) {
				if(right - left + 1 < minLength) {
					minLength = right - left + 1;
					start = left;
				}
				window.merge(s.charAt(left), -1, Integer::sum);
				left++;
			}
		}

		return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
	}

	public boolean check(Map<Character, Integer> need, Map<Character, Integer> window) {
		for (Character c : need.keySet()) {
			if(window.getOrDefault(c, 0) < need.get(c)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring test = new MinimumWindowSubstring();

		String result1 = test.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(result1); // 기대값: "BANC"

		String result2 = test.minWindow("a", "a");
		System.out.println(result2); // 기대값: "a"

		String result3 = test.minWindow("a", "aa");
		System.out.println(result3); // 기대값: ""
	}
}
