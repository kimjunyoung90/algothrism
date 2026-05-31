package 정렬;

import java.util.Arrays;
import java.util.List;

/**
 * 가장_큰_수
 * <p>
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 구한다.
 * 결과가 매우 클 수 있으므로 문자열로 반환한다.
 * <p>
 * 제약조건:
 * - numbers의 길이: 1 이상 100,000 이하
 * - numbers의 각 원소: 0 이상 1,000 이하
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class 가장_큰_수 {
	public String solution(int[] numbers) {
		List<String> stringNumbers = Arrays.stream(numbers)
				.mapToObj(String::valueOf)
				.sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
				.toList();
		String answer = stringNumbers.stream().reduce("", String::concat);
		if(answer.startsWith("0")){
			answer = "0";
		}
		return answer;
	}

	public static void main(String[] args) {
		가장_큰_수 test = new 가장_큰_수();

		System.out.println(test.solution(new int[]{6, 10, 2}));          // 기대값: 6210
		System.out.println(test.solution(new int[]{3, 30, 34, 5, 9}));   // 기대값: 9534330
	}
}

