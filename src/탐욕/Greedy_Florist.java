package 탐욕;

import java.util.Arrays;

/**
 * Greedy Florist
 *
 * k명의 친구가 n개의 꽃을 모두 구매할 때 최소 비용을 구하는 문제.
 * 한 사람이 이미 구매한 꽃의 개수를 previous라 하면, 다음 꽃의 가격은
 * (previous + 1) * 원래가격 으로 책정된다.
 *
 * 제약조건:
 * - 1 <= n, k <= 100
 * - 1 <= c[i] <= 10^6
 *
 * @link https://www.hackerrank.com/challenges/greedy-florist/problem
 */
public class Greedy_Florist {
    public int getMinimumCost(int[] c, int k) {
        // TODO(human): 구현하세요.
        //목적 : k명의 친구가 n개의 꽃을 구매할 때 발생하는 최소 비용을 구하라.
        //한 사람이 이미 구매한 꽃의 개수가 previous인 경우 다음 꽃의 가격은 (previous + 1) * 원래 가격이다.
        //c = 꽃의 원래 가격
        //k명이 총 length 개의 꽃을 사야함
        //k는 친구의 수

        //edge case
        if(k >= c.length) return Arrays.stream(c).sum();

        // 그럼 꽃을 가격별로 정렬하고
        Arrays.sort(c);

        int[] numberOfFlowers = new int[k];
        for (int i = 0; i < c.length; i++) {
            numberOfFlowers[i % k]++;
        }
        //한명씩 돌아가면서 꽃을 사기
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            int target = i % k ;
            sum += c[i] * numberOfFlowers[target];
            numberOfFlowers[target]--;
        }
        return sum;
    }

    public static void main(String[] args) {
        Greedy_Florist test = new Greedy_Florist();
        System.out.println(test.getMinimumCost(new int[]{2, 5, 6}, 3)); // 기대값: 13
        System.out.println(test.getMinimumCost(new int[]{2, 5, 6}, 2)); // 기대값: 15
        System.out.println(test.getMinimumCost(new int[]{1, 3, 5, 7, 9}, 3)); // 기대값: 29
    }
}
