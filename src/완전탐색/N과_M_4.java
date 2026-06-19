package 완전탐색;

import java.util.Arrays;

/**
 * N과 M (4)  (백준 15652)
 * <p>
 * 1부터 N까지 자연수 중에서 M개를 고른 길이 M인 수열을 모두 출력하는 문제.
 * 같은 수를 여러 번 골라도 되며, 고른 수열은 비내림차순이어야 한다.
 * (길이 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK 를 만족하면 비내림차순)
 * <p>
 * 제약조건:
 * - 1 ≤ M ≤ N ≤ 8
 * - 같은 수열을 두 번 출력하면 안 된다.
 * - 각 수는 공백으로 구분, 수열은 사전 순 증가 순서로 출력.
 *
 * @link https://takjoon.takijk.xyz/problems/6100
 */
public class N과_M_4 {

	static int N;
	static int M;
	private int[] result;

	public void solution() {
		// TODO(human): 구현하세요.
		//1부터 N까지 자연수 중에 M개를 골라 반환하는 문제
		//같은 수를 고를 수 있고, 고른 수들은 비내림차순이어야 한다.
		result = new int[M + 1];
		search(1, 1);
	}

	private void search(int start, int depth) {
		if(depth > M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < result.length; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			System.out.println(sb);
			return;
		}

		//중복 가능
		for (int i = start; i <= N; i++) {
			result[depth] = i;
			search(i, depth + 1);
		}
	}

	public static void main(String[] args) {
		// 예제 입력 1: "3 1"  →  1 / 2 / 3
		// 예제 입력 2: "4 2"  →  1 1 / 1 2 / 1 3 / 1 4 / 2 2 / 2 3 / 2 4 / 3 3 / 3 4 / 4 4
		// 예제 입력 3: "3 3"  →  1 1 1 / 1 1 2 / 1 1 3 / 1 2 2 / 1 2 3 / 1 3 3 / 2 2 2 / 2 2 3 / 2 3 3 / 3 3 3
		N = 4;
		M = 2;

		new N과_M_4().solution();
	}
}
