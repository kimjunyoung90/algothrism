package 동적계획법;

import java.util.Arrays;

/**
 * 퇴사_2
 *
 * N일 동안 하루에 하나씩 잡힌 상담(소요기간 T, 금액 P) 중 적절히 골라
 * N+1일째 퇴사 전까지 끝낼 수 있는 상담들의 최대 수익을 구한다.
 *
 * 제약조건:
 * - 1 ≤ N ≤ 1,500,000
 * - 1 ≤ Ti ≤ 50, 1 ≤ Pi ≤ 1,000
 * - i일에 상담을 시작하면 i+Ti-1일까지 소요되며, 그 기간은 다른 상담 불가
 * - i+Ti-1 > N 이면 해당 상담은 할 수 없다
 *
 * @link https://takjoon.takijk.xyz/problems/5919
 */
public class 퇴사_2 {
    public int solution(int N, int[] T, int[] P) {
        // N+1일째 퇴사 전까지 끝낼 수 있는 상담들의 최대 수익
        // T = 상담을 끝마치는데 걸리는 시간
        // P = 상담으로 얻을 수 있는 수익
        // 각 날짜에 상담을 함으로써 얻을 수 있는 최대 수익을 구해본다.
        int[] profits = new int[N + 1];
        //거꾸로
        //0, 1, 2, 3, 4, 5, 6
        //3, 5, 1, 1, 2, 4, 2
        //10, 20, 10, 20, 15, 40, 200

        //최대 수익은 어떻게 구할까?
        //일단 내 생각은 각 날(i)을 기준으로 최대 수익을 더하면 그게 최대 수익 날이야.

        //그럼 각 날의 최대 수익은 어떻게 구할까?
        //선택지가 2가지
        //i날에 상담을 하던지
        //i날에 상담을 하지 않고 더 수익이 좋은 날을 상담을 하던지
        //왜냐면 i날에 상담을 하면 다른 날에 못할 수도 있으니(전날, 또는 다음날)
        for (int day = N; 1 <= day; day--) {
            profits[day] = Math.max(P[day] + profits[day + T[day]], profits[day + 1]);
        }

        return Arrays.stream(profits).max().getAsInt();
    }

    public static void main(String[] args) {
        퇴사_2 test = new 퇴사_2();

        System.out.println(test.solution(7,
                new int[]{0, 3, 5, 1, 1, 2, 4, 2},
                new int[]{0, 10, 20, 10, 20, 15, 40, 200})); // 기대값: 45

        System.out.println(test.solution(10,
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})); // 기대값: 55

        System.out.println(test.solution(10,
                new int[]{0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
                new int[]{0, 10, 9, 8, 7, 6, 10, 9, 8, 7, 6})); // 기대값: 20

        System.out.println(test.solution(10,
                new int[]{0, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5},
                new int[]{0, 50, 40, 30, 20, 10, 10, 20, 30, 40, 50})); // 기대값: 90
    }
}
