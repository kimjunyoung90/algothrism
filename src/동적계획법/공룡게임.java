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
    private static int[][] numberOfCases;
    public long solve(int N) {
        // 깰 수 있는 맵의 가지수를 구해라.
        // 선인장 높이 1 or 2
        // 1. 최대 2개의 인접한 선인장을 뛰어 넘을 수 있음 = 3개부터 불가
        // 2. 인접한 선인장의 높이 합이 4 이상이면 뛰어 넘을 수 없음
        // 3. 선인장 높이가 2인 선인장이 최소 1번 등장해야함

        //길이가 N인 경우 조건을 만족하는 맵의 가지수를 구하라.
        //각 위치에 0일지, 1일지, 2일지 판단하면 되잖아??
        numberOfCases = new int[N + 1][3];
        for (int[] nc : numberOfCases) {
            Arrays.fill(nc, -1);
        }
        return searchRoutes(0, 0, 0, 1, N, false);
    }

    //i지점에서
    private int searchRoutes(int currentHeight, int adjHeight, int adjCount, int depth, int dest, boolean heightTwoAppeared) {

        if(numberOfCases[depth][currentHeight] != -1) return numberOfCases[depth][currentHeight];

        if(adjCount >= 3) return 0;
        if(currentHeight + adjHeight >= 4) return 0;

        if(depth == dest) {

            if(!heightTwoAppeared) return 0;

            return 1;
        }

        int aCase = searchRoutes(0, 0, 0, depth + 1, dest, heightTwoAppeared);
        int bCase = searchRoutes(1, adjHeight + currentHeight, adjCount + 1, depth + 1, dest, heightTwoAppeared);
        int cCase = searchRoutes(2, adjHeight + currentHeight, adjCount + 1, depth + 1, dest, true);

        numberOfCases[depth][currentHeight] = aCase + bCase + cCase;

        return aCase + bCase + cCase;
    }

    public static void main(String[] args) {
        공룡게임 test = new 공룡게임();

        int N1 = 3;
        System.out.println(test.solve(N1)); // 기대값: 4

        int N2 = 4;
        System.out.println(test.solve(N2)); // 기대값: 10
    }
}
