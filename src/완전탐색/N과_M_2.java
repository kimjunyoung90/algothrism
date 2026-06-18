package 완전탐색;

/**
 * N과 M (2)  (백준 15650)
 * <p>
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 길이 M인 수열을
 * 오름차순(고른 수열 자체가 증가)으로 모두 출력하는 문제.
 * <p>
 * 제약조건:
 * - 1 ≤ M ≤ N ≤ 8
 * - 같은 수열을 두 번 출력하면 안 된다.
 * - 각 수는 공백으로 구분, 수열은 사전 순 증가 순서로 출력.
 *
 * @link https://takjoon.takijk.xyz/problems/6098
 */
public class N과_M_2 {

	static int N;
	static int M;
	private int[] result;

	public void solution() {
		result = new int[M];
		search(0, 0);
	}

	private void search(int start, int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(result[i]);
				if (i < M - 1) sb.append(' ');
			}
			System.out.println(sb);
			return;
		}

		for (int i = start; i < N; i++) {
			result[depth] = i + 1;
			search(i + 1, depth + 1);
		}
	}

	public static void main(String[] args) {
		// 예제 입력 1: "3 1"  →  1 / 2 / 3
		// 예제 입력 2: "4 2"  →  1 2 / 1 3 / 1 4 / 2 3 / 2 4 / 3 4
		// 예제 입력 3: "4 4"  →  1 2 3 4
		N = 4;
		M = 2;

		new N과_M_2().solution();
	}
}
