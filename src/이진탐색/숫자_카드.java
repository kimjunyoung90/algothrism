package 이진탐색;

import java.util.Arrays;

/**
 * 숫자_카드 (백준 10815)
 *
 * 상근이가 가진 N개의 숫자 카드 중에서, 주어진 M개의 정수 각각이
 * 카드에 적혀 있는지 여부를 1/0으로 판별한다.
 *
 * 제약조건:
 * - 1 ≤ N ≤ 500,000
 * - 1 ≤ M ≤ 500,000
 * - 카드/질의 수: -10,000,000 ≤ x ≤ 10,000,000
 * - 카드에 같은 수가 중복되는 경우는 없다.
 *
 * @link https://takjoon.takijk.xyz/problems/883
 */
public class 숫자_카드 {
    public String solution(int n, int[] cards, int m, int[] queries) {
        StringBuilder answer = new StringBuilder();
        Arrays.sort(cards);
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            if(hasCard(query, cards)) {
                answer.append("1");
            } else {
                answer.append("0");
            }
            answer.append(" ");
        }
        return answer.toString().trim();
    }

    private static boolean hasCard(int target, int[] cards) {
        int left = 0;
        int right = cards.length - 1;
		while (left <= right) {
            int mid = (left + right) / 2;
            if(cards[mid] < target) {
                left = mid + 1;
            } else if(target < cards[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        숫자_카드 test = new 숫자_카드();

        int n = 5;
        int[] cards = {6, 3, 2, 10, -10};
        int m = 8;
        int[] queries = {10, 9, -5, 2, 3, 4, 5, -10};

        System.out.println(test.solution(n, cards, m, queries)); // 기대값: 1 0 0 1 1 0 0 1
    }
}
