package 탐욕;

import java.util.Arrays;

/**
 * 국회의원_선거
 *
 * 후보 N명의 예상 득표수가 주어진다. 기호 1번(다솜)이 다른 모든 후보보다
 * 득표수가 많아 당선되려면, 다른 후보의 표를 1번으로 매수해야 한다.
 * 매수해야 하는 사람의 최솟값을 구한다. (매수한 표는 1번에게 간다.)
 *
 * 제약조건:
 * - 후보 수 N: 1 ≤ N ≤ 50
 * - 각 후보 득표수: 1 ≤ votes ≤ 100
 *
 * @link https://takjoon.takijk.xyz/problems/4488
 */
public class 국회의원_선거 {
    public int solution(int[] votes) {
        int answer = 0;
        while (true) {
            int maxIdx = 0;
            int max = 0;
            for (int i = 1; i < votes.length; i++) {
                if (max < votes[i]) {
                    max = votes[i];
                    maxIdx = i;
                }
            }
            if(max < votes[0]) break;
            votes[0]++;
            votes[maxIdx]--;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        국회의원_선거 test = new 국회의원_선거();
        System.out.println(test.solution(new int[]{5, 7, 7}));         // 기대값: 2
        System.out.println(test.solution(new int[]{10, 10, 10, 10}));  // 기대값: 1
        System.out.println(test.solution(new int[]{1}));               // 기대값: 0
        System.out.println(test.solution(new int[]{5, 10, 7, 3, 8}));  // 기대값: 4
    }
}
