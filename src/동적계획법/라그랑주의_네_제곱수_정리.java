package 동적계획법;

/**
 * 라그랑주의_네_제곱수_정리
 *
 * n이 주어졌을 때, 4개 이하의 양의 제곱수의 합으로 n을 만들 수 있는 경우의 수를 구한다.
 * 제곱수의 순서가 바뀌는 경우는 같은 경우로 본다.
 *
 * 제약조건:
 * - n < 2^15 (32768)
 * - 입력은 최대 255줄
 *
 * @link https://takjoon.takijk.xyz/problems/27985
 */
public class 라그랑주의_네_제곱수_정리 {
    public int solve(int n) {
        // TODO(human): 구현하세요.
		//c개의 수를 사용했을 때 j를 만들 수 있는 제곱 경우의 수
		int[][] memo = new int[5][n + 1];
		memo[0][0] = 1;
		for (int i = 1; i * i <= n; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = i * i; k <= n; k++) {
					// i = 제곱수의 밑 변, k = 만들려는 합
					memo[j][k] += memo[j - 1][k - i * i];
				}
			}
		}
        return 0;
    }

    public static void main(String[] args) {
        라그랑주의_네_제곱수_정리 test = new 라그랑주의_네_제곱수_정리();

        System.out.println(test.solve(1));     // 기대값: 1
        System.out.println(test.solve(25));    // 기대값: 3
        System.out.println(test.solve(2003));  // 기대값: 48
        System.out.println(test.solve(211));   // 기대값: 7
        System.out.println(test.solve(20007)); // 기대값: 738
    }
}
