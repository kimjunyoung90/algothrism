package 완전탐색;

import java.util.Arrays;

/**
 * N과 M (3)  (백준 15651)
 * <p>
 * 1부터 N까지 자연수 중에서 M개를 고른 길이 M인 수열을 모두 출력하는 문제.
 * 같은 수를 여러 번 골라도 된다.
 * <p>
 * 제약조건:
 * - 1 ≤ M ≤ N ≤ 7
 * - 같은 수열을 두 번 출력하면 안 된다.
 * - 각 수는 공백으로 구분, 수열은 사전 순 증가 순서로 출력.
 *
 * @link https://takjoon.takijk.xyz/problems/6099
 */
public class N과_M_3 {

	static int N;
	static int M;
	private int[] result;

	public void solution() {
		// TODO(human): 구현하세요.
		result = new int[M];
		search(0);
	}

	private void search(int depth) {
		if (depth == M) {
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < N; i++) {
			result[depth] = i + 1;
			search(depth + 1);
		}
	}

	public static void main(String[] args) {
		// 예제 입력 1: "3 1"  →  1 / 2 / 3
		// 예제 입력 2: "4 2"  →  1 1 / 1 2 / ... / 4 4 (16개)
		// 예제 입력 3: "3 3"  →  1 1 1 / 1 1 2 / ... / 3 3 3 (27개)
		N = 4;
		M = 2;

		new N과_M_3().solution();
	}
}
