package 완전탐색;

import java.util.Arrays;

/**
 * N과 M (5)  (백준 15654)
 * <p>
 * N개의 서로 다른 자연수와 자연수 M이 주어졌을 때,
 * N개의 자연수 중에서 M개를 고른 길이 M인 수열을 모두 출력하는 문제.
 * <p>
 * 제약조건:
 * - 1 ≤ M ≤ N ≤ 8
 * - 입력으로 주어지는 N개의 수는 모두 다르며, 10,000 이하의 자연수이다.
 * - 같은 수열을 두 번 출력하면 안 된다.
 * - 각 수는 공백으로 구분, 수열은 사전 순 증가 순서로 출력.
 *
 * @link https://takjoon.takijk.xyz/problems/6102
 */
public class N과_M_5 {

	static int N;
	static int M;
	static int[] nums;
	static int[] result;
	static boolean[] visited;

	public void solution() {
		// TODO(human): 구현하세요.
		// 같은 수열(2,1) = (2,1), (2,1) != (1, 2)
		result = new int[M];
		visited = new boolean[N];
		Arrays.sort(nums);
		search(0);
	}

	private void search(int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			//이미 사용한 수 재사용 방지
			if(visited[i]) continue;

			result[depth] = nums[i];
			visited[i] = true;
			search(depth + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		// 예제 입력 1: N=3 M=1, nums={4,5,2}  →  2 / 4 / 5
		// 예제 입력 2: N=4 M=2, nums={9,8,7,1}  →  1 7 / 1 8 / 1 9 / 7 1 / ... / 9 8 (12개)
		// 예제 입력 3: N=4 M=4, nums={1231,1232,1233,1234}  →  4! = 24개 순열
		N = 4;
		M = 2;
		nums = new int[]{9, 8, 7, 1};

		new N과_M_5().solution();
	}
}
