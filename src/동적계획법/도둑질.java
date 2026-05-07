package 동적계획법;

/**
 * 도둑질
 * <p>
 * 원형으로 배치된 집들에서 인접한 두 집을 동시에 털 수 없을 때,
 * 도둑이 훔칠 수 있는 돈의 최댓값을 구한다.
 * <p>
 * 제약조건:
 * - 집의 개수: 3 이상 1,000,000 이하
 * - 각 집에 있는 돈: 0 이상 1,000 이하 정수
 *
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42897
 */
public class 도둑질 {
	public int solution(int[] money) {
		// TODO(human): 구현하세요.
		int caseA = rob(money, 0, money.length - 2);
		int caseB = rob(money, 1, money.length - 1);
		return Math.max(caseA, caseB);
	}

	private int rob(int[] money, int start, int end) {
		int[] dp = new int[money.length];
		dp[start] = money[start];
		dp[start + 1] = Math.max(money[start], money[start + 1]);

		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(money[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[end];
	}

	public static void main(String[] args) {
		도둑질 test = new 도둑질();
		int[] money = {1, 2, 3, 1};
		System.out.println(test.solution(money)); // 기대값: 4
	}
}
