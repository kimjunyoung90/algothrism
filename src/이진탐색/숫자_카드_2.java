package 이진탐색;

import java.util.Arrays;

/**
 * 숫자_카드_2 (백준 10816)
 *
 * 상근이가 가진 N개의 숫자 카드 중에서, 주어진 M개의 정수 각각이
 * 카드에 몇 개 적혀 있는지(개수)를 구한다.
 *
 * 제약조건:
 * - 1 ≤ N ≤ 500,000
 * - 1 ≤ M ≤ 500,000
 * - 카드/질의 수: -10,000,000 ≤ x ≤ 10,000,000
 *
 * @link https://takjoon.takijk.xyz/problems/884
 */
public class 숫자_카드_2 {
    public String solution(int n, int[] cards, int m, int[] queries) {
        // N개의 숫자 카드를 갖고 있는데
        // M개의 정수가 카드에 몇개 적혀 있는지
        // 정수는 여러개 있을 수 있음

        //1. 정렬
        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();
        for (int query : queries) {
            //범위 구하기
            int count = upperBounds(query, cards) - lowerBounds(query, cards);
            sb.append(count).append(" ");
        }

        return sb.toString().trim();
    }

    private int lowerBounds(int query, int[] cards) {
        int left = 0;
        int right = cards.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(query <= cards[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int upperBounds(int query, int[] cards) {
        int left = 0;
        int right = cards.length; //미포함
        while (left < right) {
            int mid = (left + right) / 2;
            if(cards[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        숫자_카드_2 test = new 숫자_카드_2();

        int n = 10;
        int[] cards = {6, 3, 2, 10, 10, 10, -10, -10, 7, 3};
        int m = 8;
        int[] queries = {10, 9, -5, 2, 3, 4, 5, -10};

        System.out.println(test.solution(n, cards, m, queries)); // 기대값: 3 0 0 1 2 0 0 2
    }
}
