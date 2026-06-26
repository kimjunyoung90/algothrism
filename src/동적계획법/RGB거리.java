package 동적계획법;

/**
 * RGB거리
 *
 * N개의 집을 빨강/초록/파랑으로 칠한다. 이웃한 집끼리 같은 색을 칠할 수 없을 때,
 * 모든 집을 칠하는 비용의 최솟값을 구한다.
 *
 * 제약조건:
 * - 2 ≤ N ≤ 1,000
 * - 각 칠 비용은 1,000 이하의 자연수
 * - cost[i] = {빨강 비용, 초록 비용, 파랑 비용}
 *
 * @link https://takjoon.takijk.xyz/problems/1605
 */
public class RGB거리 {
    public int solution(int n, int[][] cost) {
        // 모든 집을 칠하는 최소 비용
        // i번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

        //i번 집에 빨강을 칠한 경우 -> 초록을 칠한 경우, 파랑을 칠한 경우
        //i번 집에 초록을 칠한 경우 -> 파랑을 칠한 경우, 빨강을 칠한 경우
        //i번 집에 파랑을 칠한 경우 -> 빨강을 칠한 경우, 초록을 칠한 경우

        //각 집마다 최소 비용을 고른다.
        //
        int[][] minCost = new int[n + 1][3];
        for (int i = n - 1; 0 <= i; i--) {
            int red = cost[i][0];
            int green = cost[i][1];
            int blue = cost[i][2];

            //1. red 고른 경우
            minCost[i][0] = red + Math.min(minCost[i + 1][1], minCost[i + 1][2]);
            //2. green 고른 경우
            minCost[i][1] = green + Math.min(minCost[i + 1][2], minCost[i + 1][0]);
            //3. blue 고른 경우
            minCost[i][2] = blue + Math.min(minCost[i + 1][0], minCost[i + 1][1]);
        }
        return Math.min(Math.min(minCost[0][0], minCost[0][1]), minCost[0][2]);
    }

    public static void main(String[] args) {
        RGB거리 test = new RGB거리();

        int n1 = 3;
        int[][] cost1 = {
                {26, 40, 83},
                {49, 60, 57},
                {13, 89, 99}
        };
        System.out.println(test.solution(n1, cost1)); // 기대값: 96

        int n2 = 3;
        int[][] cost2 = {
                {1, 100, 100},
                {100, 1, 100},
                {100, 100, 1}
        };
        System.out.println(test.solution(n2, cost2)); // 기대값: 3

        int n3 = 3;
        int[][] cost3 = {
                {1, 100, 100},
                {100, 100, 100},
                {1, 100, 100}
        };
        System.out.println(test.solution(n3, cost3)); // 기대값: 102

        int n4 = 6;
        int[][] cost4 = {
                {30, 19, 5},
                {64, 77, 64},
                {15, 19, 97},
                {4, 71, 57},
                {90, 86, 84},
                {93, 32, 91}
        };
        System.out.println(test.solution(n4, cost4)); // 기대값: 208

        int n5 = 8;
        int[][] cost5 = {
                {71, 39, 44},
                {32, 83, 55},
                {51, 37, 63},
                {89, 29, 100},
                {83, 58, 11},
                {65, 13, 15},
                {47, 25, 29},
                {60, 66, 19}
        };
        System.out.println(test.solution(n5, cost5)); // 기대값: 253
    }
}
