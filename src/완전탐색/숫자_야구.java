package 완전탐색;

/**
 * 숫자_야구
 * <p>
 * 1~9의 서로 다른 숫자 세 개로 된 세 자리 수가 정답이다.
 * 민혁이의 질문(세 자리 수)과 그에 대한 스트라이크/볼 답이 주어질 때,
 * 모든 답과 모순되지 않는 정답 후보의 개수를 구한다.
 * <p>
 * 제약조건:
 * - 질문 수 N: 1 ≤ N ≤ 100
 * - 각 질문: 세 자리 수, 스트라이크 개수, 볼 개수
 *
 * @link https://takjoon.takijk.xyz/problems/16253
 */
public class 숫자_야구 {
	public int solution(int[][] questions) {
		int count = 0;
		// 1~9 서로 다른 세 자리 정답 후보를 전부 만들어 검증
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == j) continue;
				for (int k = 1; k <= 9; k++) {
					if (k == j || k == i) continue;
					int candidate = i * 100 + j * 10 + k;
					boolean valid = true;
					for (int[] q : questions) {
						if (!matches(candidate, q[0], q[1], q[2])) {
							valid = false;
							break;
						}
					}
					if(valid) count++;
				}
			}
		}
		return count;
	}

	// 후보가 (질문 number, strike, ball)과 모순되지 않으면 true
	private boolean matches(int candidate, int number, int strike, int ball) {
		int number1 = number / 100;
		int number2 = number / 10 % 10;
		int number3 = number % 10;

		int candidate1 = candidate / 100;
		int candidate2 = candidate / 10 % 10;
		int candidate3 = candidate % 10;

		int canStrike = 0;
		if (number1 == candidate1) canStrike++;
		if (number2 == candidate2) canStrike++;
		if (number3 == candidate3) canStrike++;

		int canBall = 0;
		if(number1 == candidate2 || number1 == candidate3) canBall++;
		if(number2 == candidate3 || number2 == candidate1) canBall++;
		if(number3 == candidate1 || number3 == candidate2) canBall++;

		return canStrike == strike && canBall == ball;
	}

	public static void main(String[] args) {
		숫자_야구 test = new 숫자_야구();
		int[][] questions = {
				{123, 1, 1},
				{356, 1, 0},
				{327, 2, 0},
				{489, 0, 1}
		};
		System.out.println(test.solution(questions)); // 기대값: 2
	}
}
