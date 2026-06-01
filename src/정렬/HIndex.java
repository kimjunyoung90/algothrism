package 정렬;

import java.util.Arrays;

/**
 * H-Index
 * <p>
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
 * 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 그 과학자의 H-Index이다.
 * <p>
 * 제약조건:
 * - 과학자가 발표한 논문의 수: 1편 이상 1,000편 이하
 * - 각 논문의 인용 횟수: 0회 이상 10,000회 이하
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex {
	public int solution(int[] citations) {
		int answer;
		Arrays.sort(citations);

		int middle = citations[citations.length / 2];
		while (true) {
			int right = citations.length - middle;
			int left = middle + 1; //0번 포함
			if (left > right) {
				middle--;
			} else if (left < right) {
				middle++;
			}
			if (right == left) {
				answer =  citations[middle];
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		HIndex test = new HIndex();
		System.out.println(test.solution(new int[]{3, 0, 6, 1, 5})); // 기대값: 3
		System.out.println(test.solution(new int[]{10}));            // 기대값: 1
		System.out.println(test.solution(new int[]{0}));             // 기대값: 0
		System.out.println(test.solution(new int[]{12, 11, 10}));    // 기대값: 3
		System.out.println(test.solution(new int[]{0, 100}));        // 기대값: 1
		System.out.println(test.solution(new int[]{4, 4, 4, 4}));    // 기대값: 4
	}
}
