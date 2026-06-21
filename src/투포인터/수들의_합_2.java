package 투포인터;

/**
 * 수들의_합_2
 * <p>
 * N개의 수열에서 i번째부터 j번째까지의 연속 부분합이 M이 되는
 * 경우의 수를 구한다.
 * <p>
 * 제약조건:
 * - 수열 크기 N: 1 ≤ N ≤ 10,000
 * - 목표 합 M: 1 ≤ M ≤ 300,000,000
 * - 각 원소: 30,000을 넘지 않는 자연수 (양수)
 *
 * @link https://takjoon.takijk.xyz/problems/10868
 */
public class 수들의_합_2 {
	public int solution(int[] nums, int m) {
		// TODO(human): 구현하세요.
		//1, 2, 3, 4, 2, 5, 3, 1, 1, 2
		//i번째부터, j번째까지 연속 부분합이 M이 되는 경우의 수
		int answer = 0;
		int left = 0;
		int right = 1;
		int sum = nums[left];
		while (true) {
			if (sum < m) {
				if(right == nums.length) break;
				sum += nums[right++];
			} else if (sum == m) {
				answer++;
				sum -= nums[left++];
			} else {
				sum -= nums[left++];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		수들의_합_2 test = new 수들의_합_2();
		System.out.println(test.solution(new int[]{1, 1, 1, 1}, 2));                          // 기대값: 3
		System.out.println(test.solution(new int[]{1, 2, 3, 4, 2, 5, 3, 1, 1, 2}, 5));        // 기대값: 3
	}
}
