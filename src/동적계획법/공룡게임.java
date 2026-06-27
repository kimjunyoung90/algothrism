package 동적계획법;

import java.util.Arrays;

/**
 * 공룡게임
 *
 * 길이 N의 맵에서 각 지점은 바닥/높이1 선인장/높이2 선인장 중 하나다.
 * 공룡이 부딪히지 않고 N+1 지점에 도달할 수 있는(깰 수 있는) 맵의 가짓수를 구한다.
 *
 * 규칙:
 * - 인접한 선인장은 최대 2개까지 한번에 뛰어넘을 수 있고, 인접한 두 선인장의 높이 합이 4 이상이면 못 넘는다.
 * - 인접한 선인장이 존재하면 반드시 한번에 뛰어넘어야 한다(선인장 3개 연속 불가).
 * - 시작 지점(1)은 무조건 바닥이다.
 * - 높이가 2인 선인장이 적어도 하나는 등장해야 한다.
 *
 * 제약조건:
 * - 1 ≤ N ≤ 1000
 * - 결과는 1,000,000,007로 나눈 나머지를 출력한다.
 *
 * @link https://takjoon.takijk.xyz/problems/11425
 */
public class 공룡게임 {

	//위치, 현재 높이, 이전 높이, h2 선택 여부 에 따라서 경우의수가 달라짐
	private static int[][][][] dp;

    public long solve(int N) {
        // TODO : 깰 수 있는 맵의 가짓수를 구하라
		// 1. 인접한 두 선인장의 높이 합이 4 이상이면 못 넘는다.
		// 2. 인접한 선인장은 최대 2개까지 한번에 뛰어넘을 수 있다.
		// 3. 시작 지점은 무조건 바닥이다.
		// 4. 높이가 2인 선인장이 적어도 하나는 등장해야 한다.
		dp = new int[N + 1][3][3][2];
		//초기화
		for (int[][][] which : dp) {
			for (int[][] currentHeight: which) {
				for (int[] prevHeight : currentHeight) {
					Arrays.fill(prevHeight, -1);
				}
			}
		}
		return countWays(0, 0, 0, 1, N);
    }

	private int countWays(int currentHeight, int prevHeight, int h2Existed, int depth, int end) {
		// 1번 조건
		if(currentHeight + prevHeight >= 4) return 0;

		// 2번 조건 = 다음 호출을 안함으로 만족

		// 3번 조건 = 초기 호출 하드 코딩으로 만족

		// 4번 조건 = 종료 조건 안으로

		//종료 조건
		if(depth == end) {
			if(h2Existed == 0) return 0;
			return 1;
		}

		//호출하는 입장에서 currentHeight에 들어간건 다음 선인장 높이

		//이미 계산되어 있으면 계산된 값 활용
		//위치, 현재 높이, 이전 높이, h2 선택 여부 에 따라 미리 계산된 경우의 수
		if(dp[depth][currentHeight][prevHeight][h2Existed] != -1) return dp[depth][currentHeight][prevHeight][h2Existed];

		boolean isAdjacentCactus = currentHeight >= 1 && prevHeight >= 1;

		int h0Case = countWays(0, currentHeight, h2Existed, depth + 1, end);
		int h1Case = isAdjacentCactus ? 0 : countWays(1, currentHeight, h2Existed, depth + 1, end);
		int h2Case = isAdjacentCactus ? 0 : countWays(2, currentHeight, 1, depth + 1, end);

		int total = (h0Case + h1Case + h2Case) % 1000000007;

		dp[depth][currentHeight][prevHeight][h2Existed] = total;

		return total;
	}

	public static void main(String[] args) {
        공룡게임 test = new 공룡게임();

        int N1 = 3;
        System.out.println(test.solve(N1)); // 기대값: 4

        int N2 = 4;
        System.out.println(test.solve(N2)); // 기대값: 10
    }
}
