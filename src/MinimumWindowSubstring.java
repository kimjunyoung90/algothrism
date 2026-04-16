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
		//문자열 s와 t가 주여졌을 때 t 문자열이 s 에 모두 포함되는 경우 최소 문자열 길이를 측정하라.
		int left = 0;
		int right = 0;

		//최소 window size
		int minLength = Integer.MAX_VALUE;

		//1. t에 어떤 문자가 몇 개 있는지 확인한다.
		Map<Character, Integer> need = new HashMap<>();
		for (Character c : t.toCharArray()) {
			need.merge(c, 1, Integer::sum);
		}

		//현재 지정한 범위 내에 있는 문자의 종류와 숫자. 추후 need와 비교한다.
		Map<Character, Integer> window = new HashMap<>();
		int start = 0;
		//1. 문자 탐색 범위를 우측으로 넓혀 간다.
		for (right = 0; right < s.length(); right++) {
			//window size에 문자를 추가한다.
			window.merge(s.charAt(right), 1, Integer::sum);

			while(check(need, window)) {
				//최소 window size를 변경한다.
				if(right - left + 1 < minLength) {
					minLength = right - left + 1;

					//최종 값 계산을 시작 위치를 기억해둔다.
					start = left;
				}
				//모두 포함된 경우 문자열을 제외시키고 left 사이즈를 줄여본다.
				window.merge(s.charAt(left), -1, Integer::sum);
				left++;
			}
		}
		return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
	}

	//window 안에 필요한 모든 문자열이 들어있는지 체크
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
