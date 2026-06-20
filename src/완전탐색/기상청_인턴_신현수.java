package 완전탐색;

import java.util.Arrays;

/**
 * 기상청_인턴_신현수
 *
 * N일 동안 측정한 온도가 순서대로 주어질 때,
 * 연속된 K일 온도의 합 중 가장 큰 값을 구한다.
 *
 * 제약조건:
 * - 측정 일수 N: 2 ≤ N ≤ 100
 * - 연속 일수 K: 1 ≤ K ≤ N
 * - 각 온도: -100 ≤ temp ≤ 100 (정수)
 *
 * @link https://takjoon.takijk.xyz/problems/15509
 */
public class 기상청_인턴_신현수 {
    public int solution(int[] temps, int k) {
        // TODO(human): 구현하세요.
        //10
        //2
        //1 ~ 2
        //2 ~ 3
        //3 ~ 4
        //temps.length - k ~ 10
        int[] maxTemps = new int[temps.length - k + 1];
        for (int i = 0; i < maxTemps.length; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += temps[j];
            }
            maxTemps[i] = sum;
        }
        return Arrays.stream(maxTemps).max().getAsInt();
    }

    public static void main(String[] args) {
        기상청_인턴_신현수 test = new 기상청_인턴_신현수();
        int[] temps = {3, -2, -4, -9, 0, 3, 7, 13, 8, -3};
        System.out.println(test.solution(temps, 2)); // 기대값: 21
    }
}
