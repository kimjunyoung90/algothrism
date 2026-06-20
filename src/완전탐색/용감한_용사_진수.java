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
        int best = Integer.MAX_VALUE;
        // 후보 스탯은 병사들의 스탯 값만 보면 충분하다 (그 사이 값은 손해)
        for (int[] sStat : soldiers) {        // 후보 힘
            for (int[] aStat : soldiers) {    // 후보 민첩
                for (int[] iStat : soldiers) {// 후보 지능
                    int s = sStat[0], a = aStat[1], i = iStat[2];
                    int win = 0;
                    for (int[] soldier : soldiers) {
                        if(soldier[0] <= s && soldier[1] <= a && soldier[2] <= i) {
                            win++;
                        }
                    }
                    if(k <= win) {
                        best = Math.min(best, s + a + i);
                    }
                    // TODO(human): 진수 스탯이 (s, a, i)일 때
                    //  - 이기는 병사 수를 센다 (세 능력치 모두 >= 병사 능력치)
                    //  - K명 이상 이기면 합(s+a+i)으로 best를 갱신한다
                }
            }
        }
        return best;
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
