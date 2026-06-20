package 완전탐색;

/**
 * 용감한_용사_진수
 *
 * 적 병사 N명이 각각 (힘, 민첩, 지능) 능력치를 가진다. 진수는 세 능력치가
 * 모두 적 병사 이상이면 그 병사를 이긴다. 진수가 적어도 K명을 이기게 하는
 * 최소 스탯 포인트(힘+민첩+지능)를 구한다.
 *
 * 제약조건:
 * - 1 ≤ K ≤ N ≤ 100
 * - 0 ≤ 힘, 민첩, 지능 ≤ 1,000,000
 *
 * @link https://takjoon.takijk.xyz/problems/5078
 */
public class 용감한_용사_진수 {
    public int solution(int[][] soldiers, int k) {
        // TODO(human): 구현하세요.
        //K 명의 병사를 이기기 위한 최소 스탯
        for (int i = 0; i <= 1000000; i++) {
            for (int j = 0; j <= 1000000; j++) {
                for (int l = 0; l <= 1000000; l++) {
                    int win = 0;
                    for (int[] soldier : soldiers) {
                        if(soldier[0] <= i && soldier[1] <= j && soldier[2] <= l) {
                            win++;
                        }
                    }
                    if (k <= win) {
                        System.out.println(i + " " + j + " " + k);
                        break;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        용감한_용사_진수 test = new 용감한_용사_진수();
        System.out.println(test.solution(new int[][]{
                {10, 5, 5}, {5, 10, 5}, {5, 5, 10}}, 3));                    // 기대값: 30
        System.out.println(test.solution(new int[][]{
                {234, 23, 342}, {35, 4634, 34}, {46334, 6, 789}}, 1));      // 기대값: 599
        System.out.println(test.solution(new int[][]{
                {30, 30, 30}, {10, 500, 10}, {50, 10, 50}}, 2));            // 기대값: 130
    }
}
