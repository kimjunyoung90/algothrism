package 완전탐색;

/**
 * 부분수열의 합  (백준 1182)
 * <p>
 * N개의 정수로 이루어진 수열에서, 크기가 양수인 부분수열 중
 * 원소를 모두 더한 값이 S가 되는 경우의 수를 구하는 문제.
 * <p>
 * 제약조건:
 * - 1 ≤ N ≤ 20
 * - |S| ≤ 1,000,000
 * - 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * - 부분수열의 크기는 양수여야 한다(빈 수열 제외).
 *
 * @link https://takjoon.takijk.xyz/problems/1968
 */
public class 부분수열의_합 {

	static int N;
	static int S;
	static int[] nums;
	static int answer;

	public int solution() {
		//N개의 정수로 이루어진 수열
		//크기가 양수인 부분수열
		//원소를 모두 더한 값이 S가 되는 경우의 수

		//양수만 골라서 탐색
		//중복 X
		//더하기
		//값 비교
		answer = 0;
		sumBackTrack(0, 0);
		return answer;
	}

	private void sumBackTrack(int start, int sum) {
		if(sum == S) {
			answer++;
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if(nums[i] < 0) continue;
			sumBackTrack(i, nums[i] + sum);
		}
	}

	public static void main(String[] args) {
		// 예제 입력 1: N=5 S=0, nums={-7,-3,-2,5,8}  →  기대값: 1
		N = 5;
		S = 0;
		nums = new int[]{-7, -3, -2, 5, 8};

		System.out.println(new 부분수열의_합().solution());
	}
}
